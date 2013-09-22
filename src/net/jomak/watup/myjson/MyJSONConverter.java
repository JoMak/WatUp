package net.jomak.watup.myjson;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import net.jomak.watup.json.JSONConverter;
import net.jomak.watup.json.JSONParser;

public class MyJSONConverter extends JSONConverter{
	// Tags used for logger
	private final static String TAG 	  = "MyJSONConverter";
	private final static String LOG_ERROR = "ERROR";
	// API CONSTANTS
	private final static String API_URL= "http://api.uwaterloo.ca/public/v1/";
	private final static String API_KEY= "?key=5da0755914d374550f518b31db2ef490";
	private final static String API_SERVICE = "&service=";
	private final static String API_HEADER =API_URL+API_KEY+API_SERVICE;
	private final static String API_OUTPUT_STYLE = "json";
	// Common tags used to access Waterloo Open API
	private final static String TAG_RESPONSE = "response";
	private final static String TAG_COURSE_DATA = "data";
	private final static String TAG_COURSE_RESULT = "result";
	public MyJSONConverter(){
		super();
	}
	@Override
	protected String buildQuery(String... args) {
		// args[0] = the service
		// args[1] = the query
		return API_HEADER+args[0]+"&q="+args[1]+"&output="+API_OUTPUT_STYLE;
	}
	@Override
	protected ArrayList<JSONObject> query(String queryLink) {
		try{
			// Creating JSON Parser instance
			JSONParser jParser = new JSONParser();
			// getting JSON string from URL
			JSONObject json = jParser.getJSONFromUrl(queryLink);
			JSONObject response = json.getJSONObject(TAG_RESPONSE);
			JSONObject data = response.getJSONObject(TAG_COURSE_DATA);
			JSONArray result = data.getJSONArray(TAG_COURSE_RESULT);
			
			ArrayList<JSONObject> resultObjects = new ArrayList<JSONObject>();
			for (int i=0; i<result.length(); i++){
				resultObjects.add(result.getJSONObject(i));
			}
			return resultObjects;

		} catch (JSONException e) {
			Log.e(TAG+":"+LOG_ERROR, "JSON Error. Error parsing data. "+e.toString());
			e.printStackTrace();
			return null;
		}
	}
	
}
