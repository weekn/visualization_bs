package com.nfjd.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nfjd.model.MapValueModel;
import com.nfjd.model.TouristModel;
public interface TouristMapper {
	List<MapValueModel>  getSpotsRegionHot();
	List<MapValueModel>  getSpotsHot(@Param(value="num")int num);
	List<MapValueModel>  getProfileGender();
	List<MapValueModel>  getProfileAge();
	
	List<Object>  getTourists(@Param(value="start")int start,@Param(value="num")int num);
	
}
