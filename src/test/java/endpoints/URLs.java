package endpoints;

public class URLs {


	    public static String booking_base_url = "https://restful-booker.herokuapp.com";

	    public static String auth_post_url= booking_base_url + "/auth";
	    public static String booking_post_url = booking_base_url + "/booking";
	    public static String booking_get_url = booking_base_url + "/booking/{id}";
	    public static String booking_update_url = booking_base_url + "/booking/{id}";
	    public static String booking_delete_url = booking_base_url + "/booking/{id}";
	    
	    //ResRes.in
	    
	     public static String reqres_base_url="https://reqres.in/";
	     public static String reqres_get_singleuser_url=reqres_base_url+"api/users?page=2";
	     public static String reqres_register_url=reqres_base_url+"api/register";
	     public static String reqres_login_url=reqres_base_url+"api/login";
	     
	    
	    
	    public static String breakingBad_base_url = "https://drangovski.github.io";
	    public static String breakingBad_get_url = breakingBad_base_url + "/api/characters/{id}";
	    public static String breakingBad_create_url = breakingBad_base_url + "/api/characters/";

}
