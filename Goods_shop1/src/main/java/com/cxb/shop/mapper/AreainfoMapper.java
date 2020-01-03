package com.cxb.shop.mapper;

import com.cxb.shop.pojo.Areainfo;
import com.cxb.shop.pojo.AreainfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreainfoMapper {
    int countByExample(AreainfoExample example);

    int deleteByExample(AreainfoExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Areainfo record);

    int insertSelective(Areainfo record);

    List<Areainfo> selectByExample(AreainfoExample example);

    Areainfo selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Areainfo record, @Param("example") AreainfoExample example);

    int updateByExample(@Param("record") Areainfo record, @Param("example") AreainfoExample example);

    int updateByPrimaryKeySelective(Areainfo record);

    int updateByPrimaryKey(Areainfo record);
}