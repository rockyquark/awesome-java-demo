SET @ST='2025-06-01 00:00:00';

SET @ET=date_add(@ST, interval DAY(LAST_DAY(@ST)) day);

SET @V_TIME = '2024-01-01 00:00:00'; #音频入库时间
SET @TAG = 4;

SELECT
    C3.chk_user_id,
    U1.`name`,
    C3.chk_date,
    C3.chk_total AS '审核量',
    C3.edit_distance AS '编辑距离',
    ROUND(C3.chk_total_time/3600,4) '审核时长',
    IF(C5.about_count IS NULL,0,C5.about_count) AS '审核丢弃（条目）',
    C5.about_time/3600 AS '审核丢弃（时长）',
    C5.about_count/C3.chk_total AS '审核丢弃条目比例',
    C5.about_time/C3.chk_total_time AS '审核丢弃时长比例',
    C4.dif_count AS '审核有修改',
    C4.dif_count/C3.chk_total AS '修改比例',
    C1.review_total AS '复核抽检',

    C1.review_total/(C3.chk_total-IF(C5.about_count IS NULL,0,C5.about_count)) AS '抽检比例',
    IF(C2.review_total_r IS NULL,0,C2.review_total_r) AS '抽检错误',
    ROUND(C2.review_total_r/C1.review_total,4) AS '抽检错误率',
    IF(C2.review_total_r IS NULL,0,ROUND(C2.review_total_r/C1.review_total,4)) AS '抽检错误率',
    C2.review_total_r_time/3600 AS '抽检错误（时长）'
    ROUND(C2.review_total_r_time/C1.review_total_time,4) AS '抽检时长错误率'

FROM (
         SELECT V3.chk_user_id,DATE(V3.chk_date) AS chk_date,COUNT(V3.voice_id) AS chk_total,SUM(TIMEDIFF(end_time,start_time)) AS 'chk_total_time',SUM(edit_distance) AS edit_distance
FROM voice_chk V3
    INNER JOIN voice V1 ON V1.voice_id = V3.voice_id
WHERE 1
  AND V1.job_id = 1
  AND V1.start_time >= @V_TIME
  AND V3.chk_date BETWEEN @ST AND @ET
GROUP BY V3.chk_user_id,DATE(V3.chk_date)
    ) AS C3 --审核量
    LEFT JOIN (
SELECT V3.chk_user_id,DATE(V3.chk_date) AS chk_date,COUNT(V3.voice_id) AS review_total_r,SUM(TIMEDIFF(end_time,start_time)) AS 'review_total_r_time'
FROM voice_chk V3
    INNER JOIN voice V1 ON V1.voice_id = V3.voice_id
    INNER JOIN voice_review V4 ON V4.voice_id = V3.voice_id
WHERE 1
  AND V1.job_id = 1
  AND V4.review_result = 2
  AND V4.review_date IS NOT NULL
  AND V1.start_time >= @V_TIME
  AND V3.chk_date BETWEEN @ST AND @ET
GROUP BY V3.chk_user_id, DATE(V3.chk_date)
ORDER BY COUNT(V1.voice_id) DESC
    ) AS C2 ON C3.chk_user_id = C2.chk_user_id AND C2.chk_date=C3.chk_date #错误量
    LEFT JOIN (
    SELECT V2.chk_user_id,DATE(V2.chk_date) AS chk_date,COUNT(V4.voice_id) AS review_total
    FROM voice_review V4
    INNER JOIN voice_chk V2 ON V2.voice_id = V4.voice_id
    WHERE 1
    AND V4.review_date IS NOT NULL
    AND V2.chk_date BETWEEN @ST AND @ET
    GROUP BY V2.chk_user_id,DATE(V2.chk_date)
    ) AS C1 ON C1.chk_user_id = C3.chk_user_id AND C1.chk_date=C3.chk_date #复核量
    LEFT JOIN (
    SELECT V3.chk_user_id,DATE(V3.chk_date) AS chk_date,COUNT(V3.voice_id) AS dif_count
    FROM voice_chk V3
    INNER JOIN voice_idt V2 ON V2.voice_id = V3.voice_id
    WHERE 1
    AND V3.chk_result = 1
    AND V3.chk_date BETWEEN @ST AND @ET
    #AND V2.idt_text <> V2.chk_text
    AND V2.idt_date >= @V_TIME
    AND V2.idt_text <> REPLACE(V3.chk_text,"#","")
    GROUP BY V3.chk_user_id,DATE(V3.chk_date)
    ) AS C4 ON C4.chk_user_id = C3.chk_user_id AND C4.chk_date=C3.chk_date #审核无修改
    LEFT JOIN (
    SELECT V3.chk_user_id,DATE(V3.chk_date) AS chk_date,COUNT(V3.voice_id) AS about_count,SUM(TIMEDIFF(end_time,start_time)) AS 'about_time'
    FROM voice_chk V3
    INNER JOIN voice V1 ON V1.voice_id = V3.voice_id
    WHERE 1
    AND V1.job_id = 1
    AND V3.chk_result <> 1
    AND V3.chk_date BETWEEN @ST AND @ET
    AND V1.start_time >= @V_TIME
    GROUP BY V3.chk_user_id,DATE(V3.chk_date)
    ) AS C5 ON C5.chk_user_id = C3.chk_user_id AND C5.chk_date=C3.chk_date  --丢弃量

    LEFT JOIN `user` AS U1 ON U1.user_id = C3.chk_user_id
WHERE 1
  AND U1.tag = @TAG
ORDER BY chk_user_id ASC,chk_date ASC;