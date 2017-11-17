package com.nfjd.controller.broadband;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nfjd.model.DataTablePageCtrlModel;
import com.nfjd.model.MapValueModel;
import com.nfjd.service.broadband.BbCustomerService;


@RestController
public class BbCustomerController {
	@Autowired
    private BbCustomerService service;
	
	@RequestMapping(value = "/bbcustomer/{province}/profile/age",method = RequestMethod.GET)//每个地区的热度
	public List<MapValueModel> getProfileAge(@PathVariable String province){
        return service.getProfileAge(province);       
    }
	
	@RequestMapping(value = "/bbcustomer/{province}/profile/gender",method = RequestMethod.GET)//每个地区的热度
	public List<MapValueModel> getProfileGender(@PathVariable String province){
        return service.getProfileGender(province);       
    }
	
	@RequestMapping(value = "/bbcustomer/{province}/customers",method = RequestMethod.GET)//每个地区的热度
	public DataTablePageCtrlModel getTourist(@PathVariable String province,DataTablePageCtrlModel datatablePageCtrl){
		
        return service.getCustomers(datatablePageCtrl,province);       
    }
	
}
