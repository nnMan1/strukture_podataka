package rad_sa_fajlovima;
import java.security.KeyStore.Entry;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class SurveysStatistics {
	
    private List<Survey> surveys;

    public SurveysStatistics(Stream<Survey> surveys) {
        this.surveys = surveys.toList();
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public Double getMeanNumRespondentsSurveyConsultantandDate(String consultant, LocalDate dateMax) {
    	
    	return surveys.stream()
    		   .filter(s -> s.getName().equals(consultant))
    		   .filter(s -> s.getEndDate().isBefore(dateMax))
    		   .mapToInt(s -> s.getNumberRespondents())
    		   .average()
    		   .orElse(0.0);
    
    }

    public Survey getSurveyMostRespondentsPerDay(SurveyType type) {
        return surveys.stream()
                .filter(s -> s.getType() == type)
                .max(Comparator.comparing(Survey::getRatioRespondentsPerDay))
                .orElseThrow(NoSuchElementException::new);
    }


    public List<String> getMostFrequentPartiesSorted(Integer n) {
    	
    	return surveys.stream()
				.flatMap(a -> a.getResults().stream())
				.map(a -> a.getParty())
                .collect(Collectors.groupingBy(p -> p))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (long) e.getValue().size()))
                .entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Long> >() {
					@Override
					public int compare(java.util.Map.Entry<String, Long> o1,
							java.util.Map.Entry<String, Long> o2) {
						return o1.getValue().compareTo(o2.getValue());
					}
				}.reversed())
                .limit(n)
                .map(e -> e.getKey())
                .toList();  
    	
//    	 return surveys.stream()
//				.flatMap(a -> a.getResults().stream())
//				.map(a -> a.getParty())
//                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
//                .entrySet().stream()
//                .sorted(new Comparator<Map.Entry<String, Long> >() {
//					@Override
//					public int compare(java.util.Map.Entry<String, Long> o1,
//							java.util.Map.Entry<String, Long> o2) {
//						return o1.getValue().compareTo(o2.getValue());
//					}
//				}.reversed())
//                .limit(n)
//                .map(e -> e.getKey())
//                .toList();   			
    			    			
    	
//        return surveys.stream()
//                .flatMap(s -> s.getResults().stream())
//                .map(Result::getParty)
//                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
//                .entrySet().stream()
//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                .limit(n)
//                .map(Map.Entry::getKey)
//                .toList();
    }

    public SortedMap<String, Boolean> getSurpassRespondentsByCountry(Integer threshold) {
    	
//    	return surveys.stream()
//    					   .collect(Collectors.groupingBy(Survey::getCountry))
//    					   .entrySet().stream()
//    					   .collect(Collectors.toMap(
//    							   Map.Entry::getKey, 
//    							   e -> e.getValue().stream().allMatch(s -> s.getNumberRespondents() > threshold),
//    							   (a, b) -> a,
//    							   TreeMap::new));
    	
        return surveys.stream()
                .collect(Collectors.groupingBy(
                        Survey::getCountry,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .allMatch(s -> s.getNumberRespondents() > threshold)
                        )
                ));
    }

    // 5 (WITH LOOPS)
    public Map<String, SortedSet<String>> getCountriesPerParty_HigherPercentage(Double threshold) {

        Map<String, SortedSet<String>> result = new HashMap<>();

        for (Survey s : surveys) {
            for (Result r : s.getResults()) {

                if (r.getPercentage() > threshold) {
                    result.putIfAbsent(r.getParty(), new TreeSet<>());
                    result.get(r.getParty()).add(s.getCountry());
                }
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return surveys.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SurveysStatistics other)) return false;
        return surveys.equals(other.surveys);
    }
}