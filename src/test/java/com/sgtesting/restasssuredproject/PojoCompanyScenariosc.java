package com.sgtesting.restasssuredproject;

public class PojoCompanyScenariosc {

	private String name;
	
	private String team_size;
	private String start_date;
	private String end_date;
	private String description;
	private String company_id;
	
	public PojoCompanyScenariosc() {
		super();
	}
	public PojoCompanyScenariosc(String name, String team_size, String start_date, String end_date, String description,
			String company_id) {
		super();
		this.name = name;
		this.team_size = team_size;
		this.start_date = start_date;
		this.end_date = end_date;
		this.description = description;
		this.company_id = company_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam_size() {
		return team_size;
	}

	public void setTeam_size(String team_size) {
		this.team_size = team_size;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	
}
