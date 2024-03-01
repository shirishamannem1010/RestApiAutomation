package endpoints;

import static io.restassured.RestAssured.given;

import payloads.Booking;
import payloads.BreakingBad;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BreakingBadEndPoints {

	public static Response createCharacter(BreakingBad breaking) {
        return given()
                .log().all()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(breaking)
                .when()
                .post(URLs.breakingBad_create_url);
    }

	 public static Response getCharactersById(int breakingId) {
	        return given()
	                .pathParam("id", breakingId)
	                .when()
	                .get(URLs.breakingBad_get_url);
	    }
	 
}
