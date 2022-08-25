package org.data;

public class PetDetails {
	
public  static String petData( int id , String name, String status) {
	
	return "{\r\n" + 
			"  \"id\": "+id+",\r\n" + 
			"  \"category\": {\r\n" + 
			"    \"id\": 1,\r\n" + 
			"    \"name\": \"cat\"\r\n" + 
			"  },\r\n" + 
			"  \"name\": \""+name+"\",\r\n" + 
			"  \"photoUrls\": [\r\n" + 
			"    \"cat\"\r\n" + 
			"  ],\r\n" + 
			"  \"tags\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": 1,\r\n" + 
			"      \"name\": \"persian\"\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"status\": \""+status+"\"\r\n" + 
			"}";
	
}}
