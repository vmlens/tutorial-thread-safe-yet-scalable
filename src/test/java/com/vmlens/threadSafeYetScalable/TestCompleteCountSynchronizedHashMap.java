package com.vmlens.threadSafeYetScalable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vmlens.api.AllInterleavings;

public class TestCompleteCountSynchronizedHashMap {

	@Test
	public void test() throws InterruptedException {

		try (AllInterleavings allInterleavings = 
				new AllInterleavings("TestCompleteCountSynchronizedHashMap");) {
			while (allInterleavings.hasNext()) {
				CityToCount cityToCount = new CityToCountUsingSynchronizedHashMap();
				Thread first = new Thread(() -> {
					cityToCount.move("Springfield", "South Park");
				});
				first.start();
				assertEquals(2 * CityToCount.POPULATION_COUNT, 
						cityToCount.completeCount());
				first.join();

			}
		}
	}

}
