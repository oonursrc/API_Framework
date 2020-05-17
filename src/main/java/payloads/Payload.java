package payloads;



public class Payload {

	public static String getAddPlaceBody() {

		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -22.383494,\r\n" + "    \"lng\": 44.427362\r\n"
				+ "  },\r\n" + "  \"accuracy\": 100,\r\n" + "  \"name\": \"onur house\",\r\n"
				+ "  \"phone_number\": \"12345678\",\r\n" + "  \"address\": \"istanbul\",\r\n" + "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://onur.com\",\r\n"
				+ "  \"language\": \"Turkish\"\r\n" + "}";

	}
	
	public static String getUpdatePlaceBody(String place_id,String newaddress) {

		return "{\r\n" + 
				"\"place_id\":\""+place_id+"\",\r\n" + 
				"\"address\":\""+newaddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}";

	}
	
	
	public static String getDeletePlaceBody(String place_Id) {
		return "{\r\n\"place_id\":\""+place_Id+"\"\r\n}";
		
	}
	

	public static String getbaseURL() {

		return "https://rahulshettyacademy.com";
	}
	
	public static String getbaseURLLibraryAPI() {

		return "http://216.10.245.166";
	}

	public static String get_addResources() {
		return "/maps/api/place/add/json";

	}
	
	public static String get_updateResources() {
		return "/maps/api/place/update/json";

	}

	public static String get_getResources() {
		return "/maps/api/place/get/json";
	}

	public static String get_deleteResources() {
		return "/maps/api/place/delete/json";
	}

	public static String get_paramKey() {
		return "key";
	}
	
	public static String get_place_idKey() {
		return "place_id";
	}

	public static String get_paramValue() {
		return "qaclick123";
	}

	public static String get_headerType() {
		return "Content-Type";
	}

	public static String get_headerValue() {
		return "application/json";
	}

	public static Integer get_successStatusCode() {
		return 200;
	}
	
	
	
	public static String coursePrice() {

		return "{   \"dashboard\":{\r\n" + 
				"      \"purchaseAmount\":910,\r\n" + 
				"      \"website\":\"rahulshettyacademy.com\"\r\n" + 
				"   \r\n" + 
				"},\r\n" + 
				"   \"courses\":[      {\r\n" + 
				"         \"title\":\"Selenium Python\",\r\n" + 
				"         \"price\":50,\r\n" + 
				"         \"copies\":6\r\n" + 
				"      \r\n" + 
				"},\r\n" + 
				"      {\r\n" + 
				"         \"title\":\"Cypress\",\r\n" + 
				"         \"price\":40,\r\n" + 
				"         \"copies\":4\r\n" + 
				"      \r\n" + 
				"},\r\n" + 
				"      {\r\n" + 
				"         \"title\":\"RPA\",\r\n" + 
				"         \"price\":45,\r\n" + 
				"         \"copies\":10\r\n" + 
				"      \r\n" + 
				"}\r\n" + 
				"   \r\n" + 
				"]\r\n" + 
				"}";
	}
	
	
	public static String addBook(String isbn, String aisle) {

		return "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String addBookResource() {

		return "Library/AddBook.php";
	}
	

}
