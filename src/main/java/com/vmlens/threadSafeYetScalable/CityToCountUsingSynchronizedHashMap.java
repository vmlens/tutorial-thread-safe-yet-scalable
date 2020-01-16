package com.vmlens.threadSafeYetScalable;

import java.util.HashMap;

public class CityToCountUsingSynchronizedHashMap implements CityToCount {
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	private Object lock = new Object();
	public CityToCountUsingSynchronizedHashMap() {
		for (String city : ALL_CITIES) {
			map.put(city, POPULATION_COUNT);
		}
	}
	public void move(String from, String to) {
		synchronized (lock) {
			map.compute(from, (key, value) -> {

				if (value == null) {
					return POPULATION_COUNT - 1;
				}

				return value - 1;
			});
			map.compute(to, (key, value) -> {

				if (value == null) {
					return POPULATION_COUNT + 1;
				}

				return value + 1;
			});
		}

	}
	public int count(String name) {
		synchronized (lock) {
			return map.get(name);
		}
	}
	public int completeCount() {
		synchronized (lock) {
			int completeCount = 0;
			for (Integer value : map.values()) {
				completeCount += value;
			}
			return completeCount;
		}
	}

}
