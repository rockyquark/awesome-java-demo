package org.keep.demo.mapper.speech;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.keep.demo.entity.speech.AudioTaskSchedule;
import org.keep.demo.entity.speech.AudioTaskScheduleExample;

public interface AudioTaskScheduleMapper {
    long countByExample(AudioTaskScheduleExample example);

    int deleteByExample(AudioTaskScheduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AudioTaskSchedule row);

    int insertSelective(AudioTaskSchedule row);

    List<AudioTaskSchedule> selectByExampleWithRowbounds(AudioTaskScheduleExample example, RowBounds rowBounds);

    List<AudioTaskSchedule> selectByExample(AudioTaskScheduleExample example);

    AudioTaskSchedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") AudioTaskSchedule row, @Param("example") AudioTaskScheduleExample example);

    int updateByExample(@Param("row") AudioTaskSchedule row, @Param("example") AudioTaskScheduleExample example);

    int updateByPrimaryKeySelective(AudioTaskSchedule row);

    int updateByPrimaryKey(AudioTaskSchedule row);
}