package resources;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	
	private static final String String = null;


	public String buildBaseURI() {
		
		String baseURI= payloads.Payload.getbaseURL();
		
		return baseURI;
	}
	
	
	public AddPlace addPlacePayload(String name, String language, String address) {
		
		AddPlace addplace = new AddPlace();

		addplace.setAccuracy(50);
		addplace.setAddress(address);
		addplace.setLanguage(language);
		addplace.setPhone_number("12345");
		addplace.setWebsite("www.abc.com");
		addplace.setName(name);

		List<String> myList = new ArrayList<String>();
		myList.add("shoe");
		myList.add("shop");

		addplace.setTypes(myList);

		Location location = new Location();
		location.setLat(3.456);
		location.setLng(5.123);

		addplace.setLocation(location);
		
		return addplace;
		
	}
	
	
	public String deletePlacePayload(String place_Id) {
		return "{\r\n    \"place_id\":\""+place_Id+"\"\r\n}";
	}
	
	
	
	

}
