package ie.gmit.dip;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class accidentCheckerTest {
	public static InsuranceProgram insProg;

	@BeforeEach // The method with this annotation should be executed before each @Test,
				// @ParameterizedTest, @RepeatedTest, @TestFactory methods in this current class
	// This will instantiate the InsuranceProgram class and create a local instance
	// to access all the methods in the InsuranceProgram class
	void setUpEach() {
		insProg = new InsuranceProgram();
		System.out.println("BeforeEach running...");
	}

	// @ParameterizedTest //Parameterized tests allow tests to be run numerous times
	// with different arguments
	// This test checks if the expected accident number for each part of the if-else
	// statement matches the actual number
	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 2, 3, 4, 5, 6 })
	void testWithValueSource(int accidentNumber) {
		assertTrue(accidentNumber > -1 && accidentNumber < 7);
	}

	@Test // If a string is null a null pointer exception is thrown
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS) // This test will fail if its execution time exceeds a certain
														// duration
	public void ExceptionTest() {
		assertThrows(NullPointerException.class, () -> {
			String strTest = null;
			if (strTest == null) {
				throw new NullPointerException("Strings cannot be null");
			}
		});
	}

	@AfterEach // The method with this annotation should be executed after each @Test,
	// @ParameterizedTest, @RepeatedTest, @TestFactory methods in this current class
	void tearDownEach() {
		System.out.println("AfterEach executing...");
	}
}
