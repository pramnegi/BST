/*
	METHOD 1 :
	Time Complexity : O(n)
	Space Complexity : O(n)
*/

/*
	METHOD 2 :
	Time Complexity : O(nlogn)
	Space Complexity : O(n)
*/

import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayList;
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

public class RoomsRequired {

	//[METHOD 1] : without using priority queue
	public static int rooms(ArrayList<Interval> list) {

		if(list == null || list.isEmpty())
			return 0;

		ArrayList<Integer> newList = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++) {
			newList.add(list.get(i).start);
			newList.add(-list.get(i).end);
		}
		
		Collections.sort(newList, new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				if(Math.abs(i1) - Math.abs(i2) != 0)
					return Math.abs(i1) - Math.abs(i2);
				return (i1 > i2 ? -1:  1);
			}
		});

   		int result = 0; // min room can't be less than 0
		int tempResult = 0;

		for(int i = 0; i < newList.size(); i++) {
			if(newList.get(i) >= 0) {
				++tempResult;
				result = Math.max(result, tempResult);
			}
			else
				--tempResult;
		}
		return result;
	}

	//[METHOD 2] :using priority queue.
	public static int roomsRequired(ArrayList<Interval> list) {
		
		if(list == null || list.isEmpty())
			return 0;

		int result = 0; // min room can't be less than 0

		Queue<Integer> finishingTime = new PriorityQueue<>();

		finishingTime.offer(list.get(0).end);
		for(int i = 1; i < list.size(); i++) {
			Interval current = list.get(i);

			if(finishingTime.peek() < current.start) {
				finishingTime.poll();
			} else {
				++result;
			}
			finishingTime.offer(current.end);
		}
		return result;

	}

	public static void main(String[] argv) {

		ArrayList<Interval> list = new ArrayList<>();
		list.add(new Interval(2,3));
		list.add(new Interval(15,19));
		list.add(new Interval(15,17));
		list.add(new Interval(5,10));
		list.add(new Interval(13,15));
		list.add(new Interval(12,23));
		list.add(new Interval(32,40));
		list.add(new Interval(12,15));
		list.add(new Interval(15,18));
		list.add(new Interval(42,50));
		list.add(new Interval(24,30));

		
		System.out.println(rooms(list));

		Collections.sort(list, new Comparator<Interval>(){
        	public int compare(Interval i1, Interval i2){
            	return i1.start-i2.start;
        	}
   		});

		System.out.println(roomsRequired(list));
	}
}
