package net.jomak.watup.dataobjects;

import java.util.ArrayList;

public class Course {
	
	private String id;
	private String deptAcronym;
	private String number;
	private String building;
	private String room;
	private String startTime;
	private String endTime;
	private String days;
	private String title;
	private String section;
	private String instructor;
	private String term;
	private String description;
	// More variables used for course info
	private boolean hasLec;
	private boolean hasLab;
	private boolean hasTst;
	private boolean hasTut;
	private boolean hasPrj;
	private String credits;
	private boolean hasDistEd;
	private boolean hasStj;
	private boolean onlyStj;
	private boolean hasRen;
	private boolean onlyRen;
	private boolean hasCgr;
	private boolean onlyCgr;
	private String type;
	private boolean needsDeptConsent;
	private boolean needsInstrConsent;
	private boolean availFall;
	private boolean availWinter;
	private boolean availSpring;
	private String prereqDesc;
	private String antireqDesc;
	private String corsslistDesc;
	private String coreqDesc;
	private String noteDesc;
	private String url;
	private ArrayList<String> prerequisites;
	/**
	 * Constructor used for {@link net.jomak.watup.datagrabber.DataGrabber#getCourseSearch(String)}
	 */
	public Course(String deptAcronym, String number, String title, String description) {
		super();
		this.deptAcronym = deptAcronym;
		this.number = number;
		this.title = title;
		this.description = description;
	}
	/**
	 * Constructor used for {@link net.jomak.watup.datagrabber.DataGrabber#getCourseInfo(String)}
	 */
	public Course(String id, String deptAcronym, String number, String title,
			String description, boolean hasLec, boolean hasLab, boolean hasTst,
			boolean hasTut, boolean hasPrj, String credits, boolean hasDistEd,
			boolean hasStj, boolean onlyStj, boolean hasRen, boolean onlyRen,
			boolean hasCgr, boolean onlyCgr, String type,
			boolean needsDeptConsent, boolean needsInstrConsent,
			boolean availFall, boolean availWinter, boolean availSpring,
			String prereqDesc, String antireqDesc, String corsslistDesc,
			String coreqDesc, String noteDesc, String url) {
		super();
		this.id = id;
		this.deptAcronym = deptAcronym;
		this.number = number;
		this.title = title;
		this.description = description;
		this.hasLec = hasLec;
		this.hasLab = hasLab;
		this.hasTst = hasTst;
		this.hasTut = hasTut;
		this.hasPrj = hasPrj;
		this.credits = credits;
		this.hasDistEd = hasDistEd;
		this.hasStj = hasStj;
		this.onlyStj = onlyStj;
		this.hasRen = hasRen;
		this.onlyRen = onlyRen;
		this.hasCgr = hasCgr;
		this.onlyCgr = onlyCgr;
		this.type = type;
		this.needsDeptConsent = needsDeptConsent;
		this.needsInstrConsent = needsInstrConsent;
		this.availFall = availFall;
		this.availWinter = availWinter;
		this.availSpring = availSpring;
		this.prereqDesc = prereqDesc;
		this.antireqDesc = antireqDesc;
		this.corsslistDesc = corsslistDesc;
		this.coreqDesc = coreqDesc;
		this.noteDesc = noteDesc;
		this.url = url;
	}
	/**
	 * Constructor used for {@link net.jomak.watup.datagrabber.DataGrabber#getCoursePrerequisites(String)}
	 */
	public Course(String deptAcronym, String title, String number, ArrayList<String> prerequisites, String type) {
		super();
		this.deptAcronym = deptAcronym;
		this.title = title;
		this.number = number;
		this.prerequisites = prerequisites;
		this.type = type;
	}
	/**
	 * Constructor used for {@link net.jomak.watup.datagrabber.DataGrabber#getCourseFromRoom(String)}
	 */
	public Course(String id, String deptAcronym, String number,
			String building, String room, String startTime, String endTime,
			String days, String title, String section, String instructor,
			String term) {
		super();
		this.id = id;
		this.deptAcronym = deptAcronym;
		this.number = number;
		this.building = building;
		this.room = room;
		this.startTime = startTime;
		this.endTime = endTime;
		this.days = days;
		this.title = title;
		this.section = section;
		this.instructor = instructor;
		this.term = term;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptAcronym() {
		return deptAcronym;
	}
	public void setDeptAcronym(String deptAcronym) {
		this.deptAcronym = deptAcronym;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
