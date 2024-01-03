package com.example.phoneBook.controller;


import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.phoneBook.components.Contacts;

@RestController
public class Services {
	@Autowired
	private Contacts contact_;
	@GetMapping("/**")
	public String mainMethod() {
		return "try path {/fetchContact}";
	}
	@GetMapping("/fetchContact")
	public HashMap<String,String> fetchMethod(){
		return contact_.getList();
	}
	@GetMapping("/fetchContact/{name}")
	public ResponseEntity<String> fetchByNameMethod(@PathVariable String name){
		if(contact_.getList().containsKey(name)) {
			String info = contact_.getList().get(name);
			return ResponseEntity.ok("Contact found:"+info);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
			}
		
	}
	@PostMapping("/addContact")
	public HashMap<String,String> postMethod(@RequestBody HashMap<String,String> hmap){
		  for (Map.Entry<String, String> entry : hmap.entrySet()) {
	            String phoneNumber = entry.getKey();
	            String contactInfo = entry.getValue();
	            contact_.addContact(phoneNumber, contactInfo);
	        }
		  return contact_.getList();  
	}
	@PutMapping("/updateContact/{name}")
	public ResponseEntity<String> updateMethod(@PathVariable String name, @RequestBody String phoneNumber){
		if(contact_.getList().containsKey(name)) {
			contact_.addContact(name, phoneNumber);
			return ResponseEntity.ok("Contact updated successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cant find the contact with given name");
	}
	@DeleteMapping("deleteContact/{name}")
	public ResponseEntity<String> deleteMethod(@PathVariable String name, @RequestBody String phoneNumber){
		if(contact_.getList().containsKey(name)) {
			contact_.deleteKey(name);
			return ResponseEntity.ok("Contact Deleted Successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cant find the contact with the given name");
		}
	}
	
	
}
