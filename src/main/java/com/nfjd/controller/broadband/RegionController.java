package com.nfjd.controller.broadband;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nfjd.model.LocationModel;
import com.nfjd.model.MapValueModel;
import com.nfjd.service.broadband.RegionService;
import com.nfjd.service.traveller.HotService;

@RestController
public class RegionController {
	@Autowired
    private RegionService service;
	
	@RequestMapping(value = "/bbcustomer/{province}/region/hot",method = RequestMethod.GET)//每个地区的热度
	public List<MapValueModel> getBroadbandRegionHot(@PathVariable String province){
        return service.getBroadbandRegionHot(province);       
    }
	@RequestMapping(value = "/bbcustomer/{province}/{city}/customers_location",method = RequestMethod.GET)//每个地区的热度
	public List<LocationModel> getBroadbandLocation(@PathVariable String province,@PathVariable String city){
        return service.getCustomersLocation(province, city) ;
    }
	
}
