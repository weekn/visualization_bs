package com.nfjd.service.broadband;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfjd.mapper.BroadbandMapper;
import com.nfjd.model.CustomerModel;
import com.nfjd.model.DataTablePageCtrlModel;
import com.nfjd.model.LocationModel;
import com.nfjd.model.MapValueModel;

import com.nfjd.tools.ProvinceMapperTool;

@Service
public class BbCustomerService {
	
	@Autowired
	private BroadbandMapper mapper;
	
	public List<MapValueModel> getProfileGender(String province){
		List<MapValueModel> mv_list=mapper.getProfileGender(ProvinceMapperTool.getProvinceId(province));
		for (MapValueModel mm:mv_list){
			mm.setName(dealGenderName(mm.getName()));
		}
        return mv_list;
    }
	
	public List<MapValueModel> getProfileAge(String province){
		List<MapValueModel> mv_list=mapper.getProfileAge(ProvinceMapperTool.getProvinceId(province));
		for (MapValueModel mm:mv_list){
			mm.setName(dealAgeName(mm.getName()));
		}
        return mv_list;
    }
	
	public DataTablePageCtrlModel getCustomers(DataTablePageCtrlModel datatablePageCtrl,String province) {
		int start=datatablePageCtrl.getStart();
		int num=datatablePageCtrl.getLength();
		List<Object> tm=mapper.getCustomers(null,start, num);
		int sum=mapper.geCountCustomers(null);
	
		datatablePageCtrl.setData(dealCustomers(tm));
		datatablePageCtrl.setRecordsTotal(sum);
		return datatablePageCtrl;
		
	}
	
	
	
	private List<Object> dealCustomers(List<Object> tm_list){
		for(Object tm:tm_list){
			((CustomerModel) tm).setGender(dealGenderName(((CustomerModel) tm).getGender()));
			((CustomerModel) tm).setAge(dealAgeName(((CustomerModel) tm).getAge()));
			((CustomerModel) tm).setIs_high_value(dealHighCustomer(((CustomerModel) tm).getIs_high_value()));
		}
		return tm_list;
	}
	
	
	private String dealHighCustomer(String name) {
		if(name.equals("1")) {
			return "高价值用户";
		}else {
			return "非高价值用户";
		}
	}
	
 	private String dealAgeName(String name){
		String res = null;
		switch(name){
			case "0":
				res="小年轻";
				break;
			case "1":
				res="青年";
				break;
			case "2":
				res="中青年";
				break;
			case "3":
				res="中年";
				break;
			case "4":
				res="中老年";
				break;
			case "5":
				res="老年";
				break;
		}
		return res;
	}
	private String dealGenderName(String name){
		String res = null;
		if(name.equals("2")){
			res="男";
		}else if(name.equals("1")){
			res="女";
		}else{
			res="未知";
		}
		return res;
	}
	
	



}

