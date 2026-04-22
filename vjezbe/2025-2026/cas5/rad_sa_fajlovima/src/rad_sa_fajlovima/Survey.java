package rad_sa_fajlovima;

import java.time.LocalDate;
import java.util.List;
import java.time.temporal.ChronoUnit;

public class Survey implements Comparable<Survey> {
	private String name;
	private LocalDate start_date;
	private LocalDate end_date;
	private Integer number_respondents;
	private String country;
	private SurveyType type;
	private double perc_undecided; 
	private List<Result> results;
	private double rat_respond_per_day;
	
	public Survey(String name, LocalDate start_date, LocalDate end_date, int number_of_respondents, String country,
			SurveyType type, double perc_undecided, List<Result> results) throws Exception {
		super();
		
		if(end_date.compareTo(start_date) < 0) 
			throw new Exception("Start date must be before end date.");
		
		
		if(results.isEmpty()) 
			throw new Exception("List of results can not be empty.");
		
		if(number_of_respondents < 0)
			throw new Exception("Number of respondants must be larger than zero.");
		
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.number_respondents = number_of_respondents;
		this.country = country;
		this.type = type;
		this.perc_undecided = perc_undecided;
		this.results = results;
	}
	
    public Double getRatioRespondentsPerDay() {
        long days = ChronoUnit.DAYS.between(start_date, end_date) + 1;
        return number_respondents / (double) days;
    }

	public int getNumberRespondents() {
		return number_respondents;
	}

	public void setNumber_of_respondents(int number_of_respondents) {
		this.number_respondents = number_of_respondents;
	}

	public double getPerc_undecided() {
		return perc_undecided;
	}

	public void setPerc_undecided(double perc_undecided) {
		this.perc_undecided = perc_undecided;
	}

	public String getName() {
		return name;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public LocalDate getEndDate() {
		return end_date;
	}

	public String getCountry() {
		return country;
	}

	public SurveyType getType() {
		return type;
	}

	public List<Result> getResults() {
		return results;
	}

	public double getRat_respond_per_day() {
		return rat_respond_per_day;
	}
	
	public boolean equals(Survey s) {
		if(!start_date.equals(s.start_date)) return false;
		if(!end_date.equals(s.end_date)) return false;
		if(!name.equals(s.name)) return false;
		if(number_respondents != s.number_respondents) return false;
		return true;		
	}

	@Override
	public String toString() {
		return "Survey [name=" + name + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", number_of_respondents=" + number_respondents + ", country=" + country + ", type=" + type
				+ ", perc_undecided=" + perc_undecided + ", results=" + results + ", rat_respond_per_day="
				+ rat_respond_per_day + "]";
	}

	@Override
	public int compareTo(Survey o) {
		if(start_date.compareTo(o.start_date) != 0)
			return start_date.compareTo(o.start_date);
		
		if(end_date.compareTo(o.end_date) != 0)
			return end_date.compareTo(o.end_date);
		
		if(name.compareTo(o.name) != 0)
			return name.compareTo(o.name);
		
		return number_respondents.compareTo(o.number_respondents);
	}
	
	
	
}
