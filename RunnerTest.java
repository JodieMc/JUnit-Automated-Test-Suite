package ie.gmit.dip;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.platform.suite.api.SelectClasses;

//Set up a test suite to combine and then run numerous test cases as a single unit
@RunWith(JUnitPlatform.class)
@SelectClasses({ ageCheckerTest.class, accidentCheckerTest.class })
class RunnerTest {

}
