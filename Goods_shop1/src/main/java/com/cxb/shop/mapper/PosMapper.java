package com.cxb.shop.mapper;

import com.cxb.shop.pojo.Pos;
import com.cxb.shop.pojo.PosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PosMapper {
    int countByExample(PosExample example);

    int deleteByExample(PosExample example);

    int deleteByPrimaryKey(Integer poaid);

    int insert(Pos record);

    int insertSelective(Pos record);

    List<Pos> selectByExample(PosExample example);

    Pos selectByPrimaryKey(Integer poaid);

    int updateByExampleSelective(@Param("record") Pos record, @Param("example") PosExample example);

    int updateByExample(@Param("record") Pos record, @Param("example") PosExample example);

    int updateByPrimaryKeySelective(Pos record);

    int updateByPrimaryKey(Pos record);
}