package com.springboot.test.bean;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Users {
	Long id;
	String name;
	String username;
	String email;
	String phone;
	String website;
	List<Users> listOfUser = new ArrayList<Users>();

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(Long id, String name, String username, String email,
			String phone, String website) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.website = website;
	}

	// "address": {
	// "street": "Kulas Light",
	// "suite": "Apt. 556",
	// "city": "Gwenborough",
	// "zipcode": "92998-3874",
	// "geo": {
	// "lat": "-37.3159",
	// "lng": "81.1496"
	// }
	// },'
	// "company": {
	// "name": "Romaguera-Crona",
	// "catchPhrase": "Multi-layered client-server neural-net",
	// "bs": "harness real-time e-markets"
	// }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Users> getUsers() {
		return listOfUser;
	}

	public Users getUserByID(Long id) {
		Users obj = new Users();
		for (int i = 0;i <= listOfUser.size(); i++) {
			obj = listOfUser.get(i);
			if (obj.getId() == id) {
				break;
			}
		}
		return obj;
	}

	public Users(String url) {
		JSONArray jsonArray = new JSONArray();
		JSONParser parser = new JSONParser();

		try {
			jsonArray = (JSONArray) parser.parse(IOUtils.toString(new URL(url),
					Charset.forName("UTF-8")));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(jsonArray);
		// listOfUser = jsonArray.stream().collect(jsonObject -> new Users())
		// .collect(Collectors.toList());
		Iterator<JSONObject> iterator = jsonArray.iterator();
		Users userObj = null;
		while (iterator.hasNext()) {
			JSONObject jsonChildObject = iterator.next();

			try {
				userObj = new Users((Long) jsonChildObject.get("id"),
						(String) jsonChildObject.get("name"),
						(String) jsonChildObject.get("username"),
						(String) jsonChildObject.get("email"),
						(String) jsonChildObject.get("phone"),
						(String) jsonChildObject.get("website"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			listOfUser.add(userObj);
		}
		return;
	}
}
