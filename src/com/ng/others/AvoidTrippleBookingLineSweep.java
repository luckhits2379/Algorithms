package com.ng.others;

import java.util.Map;
import java.util.TreeMap;

public class AvoidTrippleBookingLineSweep {

//The algorithm operates by maintaining a sweep line and an event queue. 
//The event queue stores points of interest (events) that need to be processed in a sorted order. 
//Example: Avoid triple booking (leetcode 731) , number of max guests at a time etc

}

class MyCalendarTwo {

	Map<Integer, Integer> eventCount = null;

	public MyCalendarTwo() {

		eventCount = new TreeMap<Integer, Integer>();
	}

	public boolean book(int start, int end) {

		eventCount.put(start, eventCount.getOrDefault(start, 0) + 1);
		eventCount.put(end, eventCount.getOrDefault(end, 0) - 1);

		int booking = 0;

		for (Map.Entry<Integer, Integer> entry : eventCount.entrySet()) {

			booking += entry.getValue();

			if (booking > 2) {

				eventCount.put(start, eventCount.get(start) - 1);
				eventCount.put(end, eventCount.get(end) + 1);

				return false;
			}

		}

		return true;
	}
}
