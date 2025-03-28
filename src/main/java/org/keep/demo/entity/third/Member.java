package org.keep.demo.entity.third;

import lombok.*;

/**
 * @note 会员信息表
 * @createdDate 2025/03/28
 */
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private Long phoneNumber;

    /**
     * 年龄
     */
    private Byte age;

    /**
     * 学历
     */
    private String education;

    /**
     * 婚姻状态
     */
    private Boolean marriage;

    /**
     * 兴趣爱好
     */
    private String hobbies;

    /**
     * 技能
     */
    private String skill;
}