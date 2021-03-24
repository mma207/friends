package com.portfolio.friends.repository;

import org.springframework.data.repository.CrudRepository;

import com.portfolio.friends.entity.Friend;

public interface FriendRepository extends CrudRepository<Friend, Long>{
	
	Friend findFriendById(Long id); 

}
