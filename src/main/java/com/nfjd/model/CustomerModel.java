package com.nfjd.model;

import java.util.Random;

public class CustomerModel {
	private String name;
	
	public CustomerModel(){
		Random random = new Random();
		String [] names={"john","weekn","mike","tom"};
		String [] phones={"1380266986","1380266986","1342266986","1380567986"};
		String [] attributions={"天河","越秀","荔湾","番禺"};
		String [] locations={"白云山","龙头山","井冈山","火炉山"};
		String [] sexs={"男","女"};
		this.name =names[random.nextInt(4)];
		this.phone=phones[random.nextInt(4)];
		this.attribution=attributions[random.nextInt(4)];
		this.location=locations[random.nextInt(4)];
		this.sex=sexs[random.nextInt(2)];
		this.age=random.nextInt(60);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAttribution() {
		return attribution;
	}
	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}
	private String phone;
	private String sex;
	private String location;
	private String attribution;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
