package calculator;
import org.junit.jupiter.api.Assertions;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.*;

import junit.framework.Assert;
class CalculatorTest {

	@Test
		void shouldReturnZeroForAnyEmptyString() {
			Assertions.assertEquals(0 , calculator.add(""));
	}
	@Test
	void shouldReturnNumberForOneNumber() {
		Assertions.assertEquals(5 , calculator.add("5"));
		Assertions.assertEquals(4 , calculator.add("4"));
		Assertions.assertEquals(53 , calculator.add("53"));
		Assertions.assertEquals(585 , calculator.add("585"));
	}
	@Test
	void shouldReturnSumOfTwoNumbersSeparatedByCommas() {
		Assertions.assertEquals(3 , calculator.add("1,2"));
		Assertions.assertEquals(37 , calculator.add("11,26"));
		Assertions.assertEquals(400 , calculator.add("126,274"));
		Assertions.assertEquals(4 , calculator.add("1,3"));
	}
	@Test
	void shouldReturnSumOfNumbersSeparatedByCommasAndNewLines() {
		Assertions.assertEquals(6 , calculator.add("1,2\n3"));
		Assertions.assertEquals(15 , calculator.add("2,5\n8"));
	}
	
	@Test
	void shouldReturnSumOfNumbersSeparatedByCustomDelimiter() {
		Assertions.assertEquals(8 , calculator.add("//;\n1;3;4"));
	}
	@Test
	void shouldThrowExceptionForCommaNextToNewLine(){
		Assertions.assertEquals(0 , calculator.add("1,\n3,4"));
	}
	@Test
	void shouldThrowExceptionForNegatives() {
		try {
			calculator.add("-1,2");
		}
		catch (IllegalArgumentException e){
			Assertions.assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			calculator.add("2,-4,3,-5");
		}
		catch (IllegalArgumentException e){
			Assertions.assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
	}

}
