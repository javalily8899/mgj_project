package com.cxb.shop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

public interface AaGoodsinfoMapper {

	public List<Map> getGoodsInfo(RowBounds bounds);
}
