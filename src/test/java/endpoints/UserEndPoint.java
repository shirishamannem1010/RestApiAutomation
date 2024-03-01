package endpoints;

import static io.restassured.RestAssured.given;

import payloads.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoint {
//	 public static Response createUser(User payload) {
//	        return given()
//	                .contentType(ContentType.JSON)
//	                .accept(ContentType.JSON)
//	                .body(payload)
//	                .when()
//	                .post(URLs.post_url);
//	    }
//
//	    public static Response readUser(String userName) {
//	        return given()
//	                .pathParam("username", userName)
//	                .when()
//	                .get(URLs.get_url);
//	    }
//
//	    public static Response updateUser(String userName, User payload) {
//	        return given()
//	                .contentType(ContentType.JSON)
//	                .accept(ContentType.JSON)
//	                .pathParam("username", userName)
//	                .body(payload)
//	                .when()
//	                .put(URLs.update_url);
//	    }
//
//	    public static Response deleteUser(String userName) {
//	        return given()
//	                .pathParam("username", userName)
//	                .when()
//	                .delete(URLs.delete_url);
//	    }
}
