import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RaceResults {
	int raceCode;
	Map<String, TimeDuration> raceResults;
	
	public RaceResults(int raceCode) {
		this.raceCode = raceCode; 
		this.raceResults = new Map();
	}
	
	public void onNewResult(String tagNumber, TimeDuration resultTime) {
		this.raceResults.put(tagNumber,resultTime);
	}
	
	public void printResults() {
		Object sortedMap = this.sortByValue((Map<K, V>) this.raceResults);
		//we could just iterate over the key values of the map, but I think it's (a less friendly) but a better approach to iterate thanks to an iterator over a map in Java
		Iterator<Map.Entry<String, TimeDuration>> iterator = sortedMap.entrySet().iterator();
	    while (iterator.hasNext()) {
	        Map.Entry<String, TimeDuration> entry = iterator.next();
	        System.out.println(entry.getKey() + ":" + entry.getValue());
	    }	}
	
	
	
	// I chose to use an function I found because I had not enough time to spend writing a new function to sort maps
	 public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {

	        List<Map.Entry<K, V>> list =
	                new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());

	        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
	            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
	                return (o1.getValue()).compareTo(o2.getValue());
	            }
	        });

	        Map<K, V> result = new LinkedHashMap<K, V>();
	        for (Map.Entry<K, V> entry : list) {
	            result.put(entry.getKey(), entry.getValue());
	        }

	        return result;

	    }
}
