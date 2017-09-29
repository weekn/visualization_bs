package com.nfjd.controller;


import java.sql.Array;

import javax.servlet.ServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nfjd.model.CustomerModel;
import com.nfjd.model.DataTablePageCtrlModel;
import com.nfjd.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
public class SyController {
	@RequestMapping(value = "/customers",method = RequestMethod.GET)
	public DataTablePageCtrlModel getUser(DataTablePageCtrlModel datatablePageCtrl){
		ObjectMapper objectMapper=new ObjectMapper();
		
		System.out.println(datatablePageCtrl.getLength()+"   "+datatablePageCtrl.getStart());
		
		CustomerModel[] cms={new CustomerModel(),new CustomerModel(), new CustomerModel(),new CustomerModel(),new CustomerModel(),
		                     new CustomerModel(),new CustomerModel(), new CustomerModel(),new CustomerModel(),new CustomerModel()};
		datatablePageCtrl.setData(cms);
		String str="err";
		try {
			str = objectMapper.writeValueAsString(cms);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		System.out.println(" str--------:    "+str);
        return datatablePageCtrl;
        
    }
    public String index(){
		 return "Welcome,";
    }
}

//关键字@RestController代表这个类是用Restful风格来访问的，如果是普通的WEB页面访问跳转时，我们通常会使用@Controller
//value = "/users/{username}" 代表访问的URL是"http://host:PORT/users/实际的用户名"
//method = RequestMethod.GET 代表这个HTTP请求必须是以GET方式访问
//consumes="application/json" 代表数据传输格式是json
//@PathVariable将某个动态参数放到URL请求路径中
//@RequestParam指定了请求参数名称
