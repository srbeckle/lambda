package src.streams;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {

	public static void main(String[] args) {
		List<Integer> scores = Arrays.asList(56, 68, 54, 98, 51, 30, 88, 44);
		System.out.println(scores.stream().filter((x)-> x > 60).findFirst());
		System.out.println(scores.stream().anyMatch((x)->x > 200));

	}

}
