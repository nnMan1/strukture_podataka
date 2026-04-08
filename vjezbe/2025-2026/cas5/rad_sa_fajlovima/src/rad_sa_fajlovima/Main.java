package rad_sa_fajlovima;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		SurveyFactory sf = new SurveyFactory();
		List<Survey> surveys = sf.fromCSV("electoral_surveys.csv");
				
		
	}

}
