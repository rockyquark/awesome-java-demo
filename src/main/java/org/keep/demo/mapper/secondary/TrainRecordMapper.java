package org.keep.demo.mapper.secondary;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.keep.demo.entity.secondary.TrainRecord;
import org.keep.demo.entity.secondary.TrainRecordExample;

public interface TrainRecordMapper {
    long countByExample(TrainRecordExample example);

    int deleteByExample(TrainRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrainRecord row);

    int insertSelective(TrainRecord row);

    List<TrainRecord> selectByExample(TrainRecordExample example);

    TrainRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") TrainRecord row, @Param("example") TrainRecordExample example);

    int updateByExample(@Param("row") TrainRecord row, @Param("example") TrainRecordExample example);

    int updateByPrimaryKeySelective(TrainRecord row);

    int updateByPrimaryKey(TrainRecord row);
}