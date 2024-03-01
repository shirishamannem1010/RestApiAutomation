package endpoints;

import payloads.ReqResPayload;
import payloads.ReqResRegisterPayload;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReqResEndPoints {
	public static Response registerUser(ReqResRegisterPayload user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
            .when()
                .post(URLs.reqres_register_url);
    }

    public static Response loginUser(ReqResRegisterPayload user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
            .when()
                .post(URLs.reqres_login_url);
    }

	  public static Response createUser(ReqResPayload reqres) {
	        return given()
	                .baseUri(URLs.reqres_base_url)
	                .basePath("/api/users")
	                .header("Content-Type", "application/json")
	                .body(reqres)
	                .when()
	                .post();
	    }
	  public static Response getSingleUser() {
	        return given()
	                .baseUri(URLs.reqres_base_url)
	                .get(URLs.reqres_get_singleuser_url);
	    }
	  public static Response updateUser(int userId, ReqResPayload reqres) {
	        return given()
	                .baseUri(URLs.reqres_base_url)
	                .basePath("/api/users/" + userId)
	                .header("Content-Type", "application/json")
	                .body(reqres)
	                .when()
	                .put();
	    }

	    public static Response deleteUser(int userId) {
	        return given()
	                .baseUri(URLs.reqres_base_url)
	                .basePath("/api/users/" + userId)
	                .when()
	                .delete();
	    }

	
}
