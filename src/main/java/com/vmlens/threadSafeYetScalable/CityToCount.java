package com.vmlens.threadSafeYetScalable;

public interface CityToCount {

	static final String[] ALL_CITIES = new String[] {  "Springfield" , "South Park"  };
	static final int POPULATION_COUNT = 1000000;
	
	void move( String from, String to );
	int count(String name);
	int completeCount();
	
}
