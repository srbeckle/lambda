package predicate.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

import predicate.PredicateDemo;

class Helper
{
	static Predicate<Integer> isOver30 = (x) -> x > 30;
	static Predicate<Integer> isOdd = (x) -> x % 2 == 1;
	static Predicate<Integer> isLarge = (x) -> x > 100;
	static Predicate<Integer> isSquare = (x) -> Math.sqrt(x) * Math.sqrt(x) == x;
}

public class UnitTests 
{
	List<Integer> scores = Arrays.asList(40, 45, 7, 105, 36, 144, 50, 6, 8, 9);
	
	@Test
	public void over30shouldBe420()
	{
		assertTrue("Sum of over 30 should be 420", PredicateDemo.sumAll(scores, Helper.isOver30) == 420);
	}
	
	@Test
	public void sumOfOdd()
	{
		assertTrue("Sum of odd should be 166", PredicateDemo.sumAll(scores, Helper.isOdd) == 166);
	}
	
	@Test
	public void sumOfSquares()
	{
		assertTrue("Sum of odd squares be 189", PredicateDemo.sumAll(scores, Helper.isSquare) == 189);
	}

}
