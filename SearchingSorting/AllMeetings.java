// Time Complexity : O(n)
// Space Complexity : O(1)

//Problem : Check weather a person could attend all the meetings or not.
import java.util.ArrayList; 
import java.util.Comparator; 
import java.util.Collections; 

class Interval {

	int start;
	int end;

	Interval() { 
		this.start = 0; 
		this.end = 0;
	}

	Interval(int s, int e) {
		this.start = s; 
		this.end = e; 
	}
}

public class AllMeetings {

	public static boolean check(ArrayList<Interval> list) {
		
		if(list == null || list.isEmpty())
			return true;

		// lets sort is here
		Collections.sort(list, new Comparator<Interval>(){
        	public int compare(Interval i1, Interval i2){
            	return i1.start-i2.start;
        	}
   		});
		
		for(int i = 1; i < list.size(); i++) { // check current with previous
			if(list.get(i).start < list.get(i - 1).end) 
				return false;
		}
		return true;
	}

	public static void main(String[] argv) {

		ArrayList<Interval> list = new ArrayList<>();
		list.add(new Interval(2,3));
		list.add(new Interval(5,10));
		list.add(new Interval(12,23));
		list.add(new Interval(13,15));
		list.add(new Interval(15,17));
		list.add(new Interval(24,30));

		System.out.println(check(list));
	}
}
