package org.keep.demo.mapper.speech;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.keep.demo.entity.speech.ErrorRecord;
import org.keep.demo.entity.speech.ErrorRecordExample;

public interface ErrorRecordMapper {
    long countByExample(ErrorRecordExample example);

    int deleteByExample(ErrorRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ErrorRecord row);

    int insertSelective(ErrorRecord row);

    List<ErrorRecord> selectByExampleWithBLOBsWithRowbounds(ErrorRecordExample example, RowBounds rowBounds);

    List<ErrorRecord> selectByExampleWithBLOBs(ErrorRecordExample example);

    List<ErrorRecord> selectByExampleWithRowbounds(ErrorRecordExample example, RowBounds rowBounds);

    List<ErrorRecord> selectByExample(ErrorRecordExample example);

    ErrorRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") ErrorRecord row, @Param("example") ErrorRecordExample example);

    int updateByExampleWithBLOBs(@Param("row") ErrorRecord row, @Param("example") ErrorRecordExample example);

    int updateByExample(@Param("row") ErrorRecord row, @Param("example") ErrorRecordExample example);

    int updateByPrimaryKeySelective(ErrorRecord row);

    int updateByPrimaryKeyWithBLOBs(ErrorRecord row);

    int updateByPrimaryKey(ErrorRecord row);
}