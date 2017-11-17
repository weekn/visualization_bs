package com.nfjd.service.broadband;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfjd.mapper.BroadbandMapper;
import com.nfjd.mapper.TouristMapper;
import com.nfjd.mapper.UserMapper;
import com.nfjd.model.LocationModel;
import com.nfjd.model.MapValueModel;
import com.nfjd.model.UserModel;
import com.nfjd.tools.ProvinceMapperTool;

@Service
public class RegionService {
	public final static HashMap<String, String> citymap = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
	{    
	    put("lasa", "拉萨市");       
	}}; 
	@Autowired
	private BroadbandMapper mapper;
	
	public List<MapValueModel> getBroadbandRegionHot(String province){
		List<MapValueModel> mv_list=mapper.getRegionHot(ProvinceMapperTool.getProvinceId(province));
		for (MapValueModel mm:mv_list){
			mm.setName(dealRegionName(mm.getName()));
		}
        return mv_list;
    }
	
	public List<LocationModel> getCustomersLocation(String province,String city) {
		return mapper.getCustomersLocation("", citymap.get(city));
	}
	
	private String dealRegionName(String name){
		String res = null;
		name=name.split("-")[1];
		if(name.equals("拉萨")) {
			res="拉萨市";
		}else {
			res=name+"地区";
		}

		return res;
	}



}

