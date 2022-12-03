import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class RaceResults {
	int raceCode;
	Map<String, TimeDuration> raceResults;
	
	public RaceResults(int raceCode) {
		this.raceCode = raceCode; 
		this.raceResults = new HashMap<String, TimeDuration>();
	}
	
	public void onNewResult(String tagNumber, TimeDuration resultTime) {
		this.raceResults.put(tagNumber,resultTime);
	}
	
	
	
	public void printResults() {
		Map<String, TimeDuration> sorted = sortByValue(this.raceResults);
		List keys = new ArrayList(sorted.keySet());
        for(String key : sorted.keySet()) {
        	if(key == keys.get(0)) {
        		System.out.println("#1 RFID tag : " + key + ", Result : " + this.raceResults.get(key));
        	}
        	System.out.println("RFID tag : " + key + ", Result : " + this.raceResults.get(key));
        }
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    } 
	
	
	
	public static void main(String[] args) throws Exception {
		RaceResults Race = new RaceResults(1);
		Race.onNewResult("1", new TimeDuration(1000));
		Race.onNewResult("2", new TimeDuration(800));
		Race.onNewResult("3", new TimeDuration(600));
		Race.onNewResult("4", new TimeDuration(400));
		Race.onNewResult("5", new TimeDuration(200));
		
		Race.printResults();
	
		// I think that this system is not accurate enough :
		// If there is draw between two competitors (< 1 second)
		// If a time is entered negative the code crashed (exception thrown) 
		
		
	}
	
}
