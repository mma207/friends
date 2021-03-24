package com.portfolio.friends.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.portfolio.friends.dto.FriendDTO;
import com.portfolio.friends.entity.Friend;
import com.portfolio.friends.repository.FriendRepository;

@Service
@Transactional
public class FriendService {
	@Autowired
	FriendRepository friendrepository; 
	
	private Friend friendFrom(FriendDTO friendDTO) {
		Friend friend = new Friend();
		friend.setId(friendDTO.getId());
		friend.setBirthday(friendDTO.getBirthday());
		friend.setEmail(friendDTO.getEmail());
		friend.setImageURL(friendDTO.getImageURL());
		friend.setName(friendDTO.getName());
		friend.setPhone(friendDTO.getPhone());
		return friend; 
	}
	
	private FriendDTO friendDTOFrom(Friend friend) {
		FriendDTO friendDTO = new FriendDTO();
		friendDTO.setId(friend.getId());
		friendDTO.setBirthday(friend.getBirthday());
		friendDTO.setEmail(friend.getEmail());
		friendDTO.setImageURL(friend.getImageURL());
		friendDTO.setName(friend.getName());
		friendDTO.setPhone(friend.getPhone());
		return friendDTO; 
	}
	
	
	public FriendDTO addFriend(FriendDTO friendDTO) throws Exception{
		Friend friend = friendFrom(friendDTO);
		return friendDTOFrom(friendrepository.save(friend)); 
	}

	public List<FriendDTO> findAllFriends(){
		List<FriendDTO> friendDTOs = new ArrayList<FriendDTO>();
		friendrepository.findAll().forEach(friend->friendDTOs.add(friendDTOFrom(friend)));
		return friendDTOs; 
	}
	
	public FriendDTO updateFriend(FriendDTO friendDTO) throws Exception{
		Friend friend = friendrepository.findById(friendDTO.getId()).orElseThrow(()->new Exception("Friend not found"));
		friend.setBirthday(friendDTO.getBirthday());
		friend.setEmail(friendDTO.getEmail());
		friend.setImageURL(friendDTO.getImageURL());
		friend.setName(friendDTO.getName());
		friend.setPhone(friendDTO.getPhone());
		return friendDTOFrom(friend); 
	}
	
	public FriendDTO deleteFriend(Long id) throws Exception{
		FriendDTO friendDTO = friendDTOFrom(friendrepository.findById(id).orElseThrow(()->new Exception("Friend not found")));
		friendrepository.deleteById(id);
		return friendDTO; 
	}

	public FriendDTO findFriendById(Long id) throws Exception {
		Friend friend = friendrepository.findById(id).orElseThrow(()->new Exception("Friend not found"));
		return friendDTOFrom(friend); 
	}
}
