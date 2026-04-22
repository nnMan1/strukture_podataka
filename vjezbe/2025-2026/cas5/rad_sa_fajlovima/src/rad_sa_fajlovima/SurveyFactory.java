package rad_sa_fajlovima;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SurveyFactory {
	
	private LocalDate parseDate(String date) {
		String[] numbers = date.split("-");
		int year = Integer.parseInt(numbers[0]);
		int month = Integer.parseInt(numbers[1]);
		int day = Integer.parseInt(numbers[2]);
		return LocalDate.of(year, month, day);
	}
	
	List<Survey> fromCSV(String path) throws Exception {
		BufferedReader is = new BufferedReader(
				  new InputStreamReader(
				   new FileInputStream("electoral_surveys.csv"), "ASCII"));
		
		List<Survey> surveys = new LinkedList<Survey>();
		
		String line = is.readLine();
		
		while((line = is.readLine()) != null) { //null znaci kraj fajla
			surveys.add(parseSurvey(line));
		}
		
		return surveys;		
	}
	
	Survey parseSurvey(String lineCSV) throws Exception {
		String[] words = lineCSV.split(",");
		String name = words[0];
		
		LocalDate start_date = parseDate(words[1]);
		LocalDate end_date = parseDate(words[2]);
		int num_respondents = Integer.parseInt(words[3]);
		String country = words[4];
		SurveyType type = SurveyType.valueOf(words[5].toUpperCase());
		double undecided = Double.parseDouble(words[6]);
		List<Result> results = new LinkedList<Result>();
		
		String[] results_string = words[7].substring(0, words[7].length()-1).split(";");
		for(String result:results_string) {
			result = result.substring(2, result.length()-1);
			String[] result_words = result.split(":");
			String party = result_words[0];
			double percentage = Double.parseDouble(result_words[1].strip());
			
			results.add(new Result(party, percentage));
		}
		
		Survey survey = new Survey(name, start_date, end_date, num_respondents, country, type, undecided, results);
		
		return survey;		
	}
}
