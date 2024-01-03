package com.example.phoneBook.components;

import java.util.HashMap;

public interface Contacts {
	public HashMap<String,String> getList();
	public HashMap<String,String> addContact(String name,String number);
	public void deleteKey(String name);
}
