package com.nfjd.service.traveller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfjd.mapper.TouristMapper;
import com.nfjd.mapper.UserMapper;
import com.nfjd.model.MapValueModel;
import com.nfjd.model.UserModel;

@Service
public class HotService {
	@Autowired
	private TouristMapper mapper;
	
	public List<MapValueModel> getSpotsRegionHot(){
		List<MapValueModel> mv_list=mapper.getSpotsRegionHot();
		for (MapValueModel mm:mv_list){
			mm.setName(dealRegionName(mm.getName()));
		}
        return mv_list;
    }
	
	public List<MapValueModel> getSpotsHot(int num){
		List<MapValueModel> mv_list=mapper.getSpotsHot(num);
		for (MapValueModel mm:mv_list){
			mm.setName(dealRegionName(mm.getName()));
		}
        return mv_list;
    }
	
	private String dealRegionName(String name){
		String res;
		switch(name){
			case "阿坝":
				res="阿坝藏族羌族自治州";
				break;
			case "甘孜":
				res="甘孜藏族自治州";
				break;
			case "凉山":
				res="凉山彝族自治州";
				break;
			default:
				res=name+"市";
				break;
		}
		return res;
	}

//	[{"name":"乐山","value":2310.0},
//	 {"name":"内江","value":1195.0},
//	 {"name":"凉山","value":132.0},
//	 {"name":"南充","value":11835.0},
//	 {"name":"宜宾","value":3024.0},
//	 {"name":"巴中","value":1397.0},
//	 {"name":"广元","value":2287.0},
//	 {"name":"广安","value":879.0},
//	 {"name":"德阳","value":1976.0},
//	 {"name":"成都","value":13403.0},
//	 {"name":"攀枝花","value":97.0},
//	 {"name":"泸州","value":7368.0},
//	 {"name":"甘孜","value":432.0},
//	 {"name":"眉山","value":2110.0},
//	 {"name":"绵阳","value":444.0},
//	 {"name":"资阳","value":142.0},
//	 {"name":"达州","value":1675.0},
//	 {"name":"遂宁","value":2296.0},
//	 {"name":"阿坝","value":667.0},
//	 {"name":"雅安","value":1262.0}]
}

