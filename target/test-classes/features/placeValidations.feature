Feature: Validating Place APIs

# scenario outline for reading parameters
@AddPlace @Regression	
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>"  "<address>"
	When User calls "AddPlaceAPI" with "POST" HTTP request
	Then The API call is success whith status code 200
	And "status" in response body is "OK"
	And Verify place_Id created maps to "<name>" using "GetPlaceAPI"
	

Examples:
	|name		|	language	|	address		|
	|AAhouse	|	English		|	xyz Center	|
#	|BBhouse	|	Spanish		|	abc Tower	|

@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working
	Given Delete Payload
	When User calls "DeletePlaceAPI" with "POST" HTTP request
	Then The API call is success whith status code 200
	And "status" in response body is "OK"
