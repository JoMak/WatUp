package net.jomak.watup.datagrabber;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import net.jomak.watup.dataobjects.Course;
import net.jomak.watup.myjson.MyJSONConverter;

public class DataGrabber {
	// LOG CONSTANTS
	private final static String TAG = "DataGrabber";

	// Service Query Tags
	private final static String TAG_SERVICE_COURSE_SEARCH = "CourseSearch";
	private final static String TAG_SERVICE_COURSE_INFO = "CourseInfo";
	private final static String TAG_SERVICE_COURSE_PREREQUISITES = "Prequisites";
	private final static String TAG_SERVICE_COURSE_FROM_ROOM = "CourseFromRoom";
	// COURSE CONSTANTS (CourseFromRoom)
	private final static String TAG_COURSE_ID = "ID";
	private final static String TAG_COURSE_DEPT_ACRONYM = "DeptAcronym";
	private final static String TAG_COURSE_NUMBER = "Number";
	private final static String TAG_COURSE_BUILDING = "Building";
	private final static String TAG_COURSE_ROOM = "Room";
	private final static String TAG_COURSE_START_TIME = "StartTime";
	private final static String TAG_COURSE_END_TIME = "EndTime";
	private final static String TAG_COURSE_DAYS = "Days";
	private final static String TAG_COURSE_TITLE = "Title";
	private final static String TAG_COURSE_SECTION = "Section";
	private final static String TAG_COURSE_INSTRUCTOR = "Instructor";
	private final static String TAG_COURSE_TERM = "Term";
	private final static String TAG_COURSE_DESCRIPTION = "Description";
	private final static String TAG_COURSE_PREREQUISITES = "Prerequisites";

	public DataGrabber(){}
	/** Courses **/
	/**
	 * Query the Waterloo Open API for a list of courses given a course name
	 * and/or course number.
	 * @param query The query string (Course Name and/or Course Number. Ex. PHYS 101, PHYS).
	 * @return The course object that is returned.
	 */
	public ArrayList<Course> getCourseSearch(String query) {
		MyJSONConverter converter = new MyJSONConverter();
		converter.buildQueryLink(TAG_SERVICE_COURSE_SEARCH, query);
		JSONArray resultCourses = (JSONArray) converter.query();
		ArrayList<Course> queryResults = null;
		try {
			queryResults = new ArrayList<Course>();
			for (int i=0;i<resultCourses.length();i++){
				JSONObject queryObject = resultCourses.getJSONObject(i);
				queryResults.add(
						new Course(
								queryObject.getString(TAG_COURSE_DEPT_ACRONYM), 
								queryObject.getString(TAG_COURSE_NUMBER), 
								queryObject.getString(TAG_COURSE_TITLE), 
								queryObject.getString(TAG_COURSE_DESCRIPTION)));
			}
		} catch (JSONException e) {
			Log.e(TAG + ":getCourseSearch",
					"JSON Error. Error parsing JSON structure.");
			e.printStackTrace();
		}
		return queryResults;
	}
	
	/**
	 * Query the Waterloo Open API for a list of courses given a course name
	 * and/or course number.
	 * @param query The query string (Course Name and/or Course Number. Ex. PHYS 101, PHYS).
	 * @return The course object that is returned.
	 */
	public ArrayList<Course> getCourseInfo(String query) {
		MyJSONConverter converter = new MyJSONConverter();
		converter.buildQueryLink(TAG_SERVICE_COURSE_INFO, query);
		JSONArray resultCourses = (JSONArray) converter.query();
		ArrayList<Course> queryResults = null;
		try {
			queryResults = new ArrayList<Course>();
			for (int i=0;i<resultCourses.length();i++){
				JSONObject queryObject = resultCourses.getJSONObject(i);
				queryResults.add(
						new Course(
								queryObject.getString(TAG_COURSE_DEPT_ACRONYM), 
								queryObject.getString(TAG_COURSE_NUMBER), 
								queryObject.getString(TAG_COURSE_TITLE), 
								queryObject.getString(TAG_COURSE_DESCRIPTION)));
			}

		} catch (JSONException e) {
			Log.e(TAG + ":getCourseInfo",
					"JSON Error. Error parsing JSON structure.");
			e.printStackTrace();
		}
		return queryResults;
	}
	/**
	 * Query the Waterloo Open API for a list of courses given the full course name.
	 * @param query The query string (Full course name. Ex. PHYS 101).
	 * @return The course object that is returned.
	 */
	public ArrayList<Course> getCoursePrerequisites(String query) {
		MyJSONConverter converter = new MyJSONConverter();
		converter.buildQueryLink(TAG_SERVICE_COURSE_PREREQUISITES, query);
		JSONArray resultCourses = (JSONArray) converter.query();
		ArrayList<Course> queryResults = null;
		try {
			queryResults = new ArrayList<Course>();
			for (int i=0;i<resultCourses.length();i++){
				JSONObject queryObject = resultCourses.getJSONObject(i);
				JSONArray prerequisites = queryObject.getJSONArray(TAG_COURSE_PREREQUISITES);
				queryResults.add(
						new Course(
								queryObject.getString(TAG_COURSE_DEPT_ACRONYM),
								queryObject.getString(TAG_COURSE_TITLE), 
								queryObject.getString(TAG_COURSE_NUMBER),
								
								queryObject.getString(TAG_COURSE_DESCRIPTION)));
			}

		} catch (JSONException e) {
			Log.e(TAG + ":getCoursePrerequisites",
					"JSON Error. Error parsing JSON structure.");
			e.printStackTrace();
		}
		return queryResults;
	}
	
	/**
	 * Query the Waterloo Open API for a course given a building name/room
	 * number combination.
	 * @param query The query string (Building Name and Room Number, ex. DC1350).
	 * @return The course object that is returned.
	 */
	public Course getCourseFromRoom(String query) {
		MyJSONConverter converter = new MyJSONConverter();
		converter.buildQueryLink(TAG_SERVICE_COURSE_FROM_ROOM, query);
		System.out.println(converter.queryLink);
		JSONObject queryObject = ((ArrayList<JSONObject>) converter.query())
				.get(0);
		Course queryResult = null;
		try {
			queryResult = new Course(queryObject.getString(TAG_COURSE_ID),
					queryObject.getString(TAG_COURSE_DEPT_ACRONYM),
					queryObject.getString(TAG_COURSE_NUMBER),
					queryObject.getString(TAG_COURSE_BUILDING),
					queryObject.getString(TAG_COURSE_ROOM),
					queryObject.getString(TAG_COURSE_START_TIME),
					queryObject.getString(TAG_COURSE_END_TIME),
					queryObject.getString(TAG_COURSE_DAYS),
					queryObject.getString(TAG_COURSE_TITLE),
					queryObject.getString(TAG_COURSE_SECTION),
					queryObject.getString(TAG_COURSE_INSTRUCTOR),
					queryObject.getString(TAG_COURSE_TERM));
		} catch (JSONException e) {
			Log.e(TAG + ":getCourseFromRoom",
					"JSON Error. Error parsing JSON structure.");
			e.printStackTrace();
		}
		return queryResult;
	}
}
