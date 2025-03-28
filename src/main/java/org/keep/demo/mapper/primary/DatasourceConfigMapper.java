package org.keep.demo.mapper.primary;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.keep.demo.entity.primary.DatasourceConfig;
import org.keep.demo.entity.primary.DatasourceConfigExample;

public interface DatasourceConfigMapper {
    long countByExample(DatasourceConfigExample example);

    int deleteByExample(DatasourceConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DatasourceConfig row);

    int insertSelective(DatasourceConfig row);

    List<DatasourceConfig> selectByExampleWithBLOBs(DatasourceConfigExample example);

    List<DatasourceConfig> selectByExample(DatasourceConfigExample example);

    DatasourceConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") DatasourceConfig row, @Param("example") DatasourceConfigExample example);

    int updateByExampleWithBLOBs(@Param("row") DatasourceConfig row, @Param("example") DatasourceConfigExample example);

    int updateByExample(@Param("row") DatasourceConfig row, @Param("example") DatasourceConfigExample example);

    int updateByPrimaryKeySelective(DatasourceConfig row);

    int updateByPrimaryKeyWithBLOBs(DatasourceConfig row);

    int updateByPrimaryKey(DatasourceConfig row);
}