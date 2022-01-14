package ie.gmit.dip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AgeCheckerTest {
	public static InsuranceProgram insProg;

	@BeforeAll // The method with this annotation should be executed before all @Test,
	// @ParameterizedTest, @RepeatedTest, @TestFactory methods in this current class
	static void setUpAll() {
		System.out.println("BeforeAll running...");
		insProg = new InsuranceProgram();
	}

	// Annotations are used to identify methods, here the annotation identifies the
	// method as a test method
	@Test // This test checks if age variables used in ageChecker are set correctly
	public void Age() {
		int age = 35;
		insProg.setAge(age);
		assertEquals(insProg.getAge(), age);
	}

	@Test // Can be used to ensure user input is numeric and not written
	void validValues() {
		int a = 5;
		String b = "five";
		assertNotSame(a, b);
	}

	@Test // This exception method will throw an error if a calculation error occurs
			// during run-time
	public void ExceptionA() {
		assertThrows(ArithmeticException.class, () -> {
			int i = 1 / 0;
		});
	}

	@Disabled // Test currently disabled
	@Test // To be used to test sale calculations when 20% off insurance sale is on for a
			// particular age group
	void calculationForSale() {
		Assertions.assertEquals(80, ((100 / 5) * 4));
	}

	@AfterAll // The method with this annotation is executed after all @Test,
	// @ParameterizedTest, @RepeatedTest, @TestFactory methods in this current class
	// have executed
	static void tearDownAll() {
		System.out.println("AfterAll executing...");
	}
}
