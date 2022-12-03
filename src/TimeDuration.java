
public class TimeDuration implements Comparable<TimeDuration> {

	private static final Exception BadBadValueException = new Exception("Number of Seconds must be a positive integer");
	int hours;
	int minutes;
	int seconds; 
	int numberOfSeconds;
	
	//Constructor
	public TimeDuration(int numberOfSeconds) throws Exception {
		if(numberOfSeconds < 0) {
			throw BadBadValueException;
		
		}
		else {
			this.numberOfSeconds = numberOfSeconds; //usefull for later use
			this.seconds = numberOfSeconds % 60;
			int totalMinutes = numberOfSeconds / 60;
			this.minutes = totalMinutes % 60;
			this.hours = totalMinutes / 60; 
		}
		
	}


	@Override
	public String toString() {
		String string = new String();
		if(hours == 0 && minutes == 0 && seconds == 0) {
			return "0s";
		}
		else if(this.hours != 0) {
			string += hours + "h ";
		}
		string += minutes + "m ";
		string += seconds + "s ";
		return string;
	}
	
	
	public int getNumberOfSeconds() {
		return this.numberOfSeconds;
	}
	
	
	public static void main(String[] args) throws Exception {
		TimeDuration example = new TimeDuration(0);
		TimeDuration example1 = new TimeDuration(732);
		TimeDuration example2 = new TimeDuration(7242);
		
		System.out.println(example.toString());
		System.out.println(example1.toString());
		System.out.println(example2.toString());
	
	}


	@Override
	public int compareTo(TimeDuration time) {
		return (int)(this.numberOfSeconds - time.getNumberOfSeconds());
	}
}
