package com.cxb.shop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

public interface AaShopCarMapper {

	public List<Map> getshopcar(RowBounds bounds,Integer userid);
	public Integer getCount(Integer userid);
}
