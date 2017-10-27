package com.nfjd.dao.imp;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nfjd.model.UserModel;

public interface UserDao extends MongoRepository<UserModel , Long>{
	public void saveUser(UserModel user);

}
