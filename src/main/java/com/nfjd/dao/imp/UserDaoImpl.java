package com.nfjd.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nfjd.model.UserModel;

@Service
public class UserDaoImpl  {
	
	@Autowired
    private UserDao userDao;
	@Autowired
    private MongoTemplate mongoTemplate;
    /**
     * 创建对象
     * @param user
     */
   
    
    public UserDaoImpl() {
	   
	}
	
    public void saveUser(UserModel user) {
    	System.out.println("------------------"+user.getAccount());
    	System.out.println(userDao);
    	//userDao.save(user);
    	mongoTemplate.save(user);
    }
	
	

    
 
   
   
}
