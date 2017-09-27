package com.nfjd.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SyController {
	@RequestMapping(value = "/users/{username}",method = RequestMethod.GET,consumes="application/json")
	public String getUser(@PathVariable String username, @RequestParam String pwd){
        return "Welcome,"+username;
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
