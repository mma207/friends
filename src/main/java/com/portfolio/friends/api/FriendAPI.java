package com.portfolio.friends.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.friends.dto.FriendDTO;
import com.portfolio.friends.service.FriendService;

@RestController
@RequestMapping("/friends")
@CrossOrigin
public class FriendAPI {
	
	@Autowired
	FriendService friendService; 
	
	@GetMapping("")
	public ResponseEntity<List<FriendDTO>> getAllFriends(){
		return new ResponseEntity<List<FriendDTO>>(friendService.findAllFriends(), HttpStatus.OK);
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<FriendDTO> getFriend(@PathVariable Long id) throws Exception{
		return new ResponseEntity<FriendDTO>(friendService.findFriendById(id), HttpStatus.OK);
	} 
	
	@PostMapping("")
	public ResponseEntity<FriendDTO> addFriend(@RequestBody FriendDTO friendDTO) throws Exception{
		return new ResponseEntity<FriendDTO>(friendService.addFriend(friendDTO), HttpStatus.CREATED);
	}
	
	@PutMapping("")
	public ResponseEntity<FriendDTO> updateFriend(@RequestBody FriendDTO friendDTO) throws Exception{
		return new ResponseEntity<FriendDTO>(friendService.updateFriend(friendDTO), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<FriendDTO> deleteFriend(@PathVariable Long id) throws Exception{
		return new ResponseEntity<FriendDTO>(friendService.deleteFriend(id), HttpStatus.OK); 
	}

}

