package predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

class Helper
{
	static Predicate<Integer> isOver30 = (x) -> x > 30;
	static Predicate<Integer> isOdd = (x) -> x % 2 == 1;
	static Predicate<Integer> isLarge = (x) -> x > 100;
	static Predicate<Integer> isSquare = (x) -> Math.sqrt(x) * Math.sqrt(x) == x;
}
public class PredicateDemo {
	
	public static BinaryOperator<Integer> accumulator = (a,b) -> (a+b);
	public static int INIT_SUM = 0;

	public static void main(String[] args) {
		List<Integer> scores = Arrays.asList(40, 45, 7, 105, 36, 144, 50, 6, 8, 9);
		System.out.println("Sum of over 30 = "  + sumAll(scores, Helper.isOver30));
		System.out.println("Sum of odd = "  + sumAll(scores, Helper.isOdd));
		System.out.println("Sum of large = "  + sumAll(scores, Helper.isLarge));
		System.out.println("Sum of squares = "  + sumAll(scores, Helper.isSquare));
		
		System.out.println("Sum of over 30 using streams = "  + sumAllUsingStreams(scores, Helper.isOver30, accumulator));

	}
	
	public static int sumAll(List<Integer> values, Predicate<Integer> p)
	{
		int sum = 0;
		for(int i : values)
		{
			if(p.test(i))
			{
				sum += i;
			}
		}
		return sum;
	}
	
	public static int sumAllUsingStreams(List<Integer> values, Predicate<Integer> p, BinaryOperator<Integer> adder)
	{
		return values.stream().filter(p).reduce(INIT_SUM, adder);
	}

}
