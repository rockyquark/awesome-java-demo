package org.keep.demo.mapper.third;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.keep.demo.entity.third.Member;
import org.keep.demo.entity.third.MemberExample;

public interface MemberMapper {
    long countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Member row);

    int insertSelective(Member row);

    List<Member> selectByExampleWithBLOBsWithRowbounds(MemberExample example, RowBounds rowBounds);

    List<Member> selectByExampleWithBLOBs(MemberExample example);

    List<Member> selectByExampleWithRowbounds(MemberExample example, RowBounds rowBounds);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Member row, @Param("example") MemberExample example);

    int updateByExampleWithBLOBs(@Param("row") Member row, @Param("example") MemberExample example);

    int updateByExample(@Param("row") Member row, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(Member row);

    int updateByPrimaryKeyWithBLOBs(Member row);

    int updateByPrimaryKey(Member row);
}