package com.example.phoneBook.components;

import java.util.HashMap;

import org.springframework.stereotype.Component;
@Component
public class FetchAllContacts implements Contacts{
	
	private HashMap<String,String> hmap;
	public FetchAllContacts(){
		hmap = new HashMap<>();
			hmap.put("Siddartha","8367652891");
			hmap.put("ashok","9849843260");
			hmap.put("redddy","9087654321");
	}
	public HashMap<String,String> getList(){
		return hmap;
	}
	public HashMap<String,String> addContact(String name,String number){
		hmap.put(name, number)	;
		return hmap;
	}
	public void deleteKey(String name) {
		hmap.remove(name);
	}
}
