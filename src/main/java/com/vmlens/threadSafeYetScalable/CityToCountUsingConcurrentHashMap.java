package com.vmlens.threadSafeYetScalable;

import java.util.concurrent.ConcurrentHashMap;

public class CityToCountUsingConcurrentHashMap implements CityToCount {
	private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
	public CityToCountUsingConcurrentHashMap() {
		for (String city : ALL_CITIES) {
			map.put(city, POPULATION_COUNT);
		}
	}
	public void move(String from, String to) {
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
	public int count(String name) {
		return map.get(name);
	}
	public int completeCount() {
		int completeCount = 0;
		for (Integer value : map.values()) {
			completeCount += value;
		}
		return completeCount;
	}
}
