package com.vmlens.threadSafeYetScalable;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;
@State(Scope.Benchmark)
public class CityToCountBenchmark {
	public CityToCount cityToCountUsingSynchronizedHashMap 
		= new CityToCountUsingSynchronizedHashMap();
	public CityToCount cityToCountUsingConcurrentHashMap 
		= new CityToCountUsingConcurrentHashMap();
	@Benchmark
	public void synchronizedHashMap() {
		String name = Thread.currentThread().getName();
		cityToCountUsingSynchronizedHashMap.move(name, name + "2");

	}
	@Benchmark
	public void concurrentHashMap() {
		String name = Thread.currentThread().getName();
		cityToCountUsingConcurrentHashMap.move(name, name + "2");

	}

}
