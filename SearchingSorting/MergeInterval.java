// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.*;

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

public class MergeInterval {

	public static ArrayList<Interval> merge(ArrayList<Interval> list) {
		
		if(list == null || list.isEmpty())
			return list;

		ArrayList<Interval> merge = new ArrayList<Interval>();

		Interval temp = list.get(0);
		int preStart = temp.start;
		int preEnd = temp.end;

		for(int i = 1; i <  list.size(); i++) {

			int currentStart = list.get(i).start;
			int currentEnd = list.get(i).end;

			if(currentStart <= preEnd) 
				preEnd = Math.max(currentEnd, preEnd);
			else {
				Interval newInterval = new Interval(preStart, preEnd);
				preStart = currentStart;
				preEnd = currentEnd;
				merge.add(newInterval);
			}
		}
		Interval newInterval = new Interval(preStart, preEnd);

		return merge;

	}

	public static void main(String[] argv) {

		ArrayList<Interval> list = new ArrayList<>();
		list.add(new Interval(2,3));
		list.add(new Interval(13,15));
		list.add(new Interval(24,30));
		list.add(new Interval(5,10));
		list.add(new Interval(15,17));
		list.add(new Interval(12,23));

		Collections.sort(list, new Comparator<Interval>(){
        	public int compare(Interval i1, Interval i2){
            	return i1.start-i2.start;
        	}
   		});

		merge(list);
	}
	
}