package ie.gmit.dip;

import java.util.Scanner;

/*Program to calculate the cost of insurance based on basic fee plus user input details
 * for age and accident history
 */
public class InsuranceProgram {

	private int basicInsurance = 500;// Basic charge for insurance
	private int age; // Variable to store age
	private int surchargeAge = 100; // Surcharge to be applied if aged under 25 years
	private int accidentNumber; // Variable to store number of accidents

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		InsuranceProgram insProg = new InsuranceProgram();

		System.out.print("Get your insurance quote...Enter your age: ");
		insProg.age = input.nextInt();
		insProg.ageChecker(insProg.age);

		System.out.print("\nHow many accidents have you had the past 5 years? Enter a number from 0-6: ");
		insProg.accidentNumber = input.nextInt();
		insProg.accidentChecker(insProg.accidentNumber);

		input.close();
	}// Input Streams are resources that should be closed

	// Method to check if a surcharge needs to be added based on age entered by user
	public void ageChecker(int age) {

		if (age < 17) {
			throw new ArithmeticException("Access denied - You must be at least 17 years old to get a quote.");
		} else if (this.age >= 17 && this.age < 25) {
			basicInsurance += surchargeAge;
			System.out.println("Additional age surcharge: " + "€" + surchargeAge);
		} else {
			System.out.println("No additional age surcharge");
		}
	}

	// Method to check if a surcharge needs to be added based on number of accidents
	// entered by user
	public void accidentChecker(int accidentNumber) {

		if (this.accidentNumber == 0) {
			basicInsurance += accidentNumber;
			System.out.println("No accident surcharge");
			System.out.println("Total amount to pay: " + "€" + basicInsurance);
		} else if (this.accidentNumber == 1) {
			System.out.println("Previous accident surcharge: " + "€" + 50 + " \nTotal amount to pay: " + "€"
					+ (basicInsurance + 50));
		} else if (this.accidentNumber == 2) {
			System.out.println("Previous accident surcharge: " + "€" + 125 + " \nTotal amount to pay: " + "€"
					+ (basicInsurance + 125));
		} else if (this.accidentNumber == 3) {
			System.out.println("Previous accident surcharge: " + "€" + 225 + " \nTotal amount to pay: " + "€"
					+ (basicInsurance + 225));
		} else if (this.accidentNumber == 4) {
			System.out.println("Previous accident surcharge: " + "€" + 375 + " \nTotal amount to pay: " + "€"
					+ (basicInsurance + 375));
		} else if (this.accidentNumber == 5) {
			System.out.println("Previous accident surcharge: " + "€" + 575 + " \nTotal amount to pay: " + "€"
					+ (basicInsurance + 575));
		} else if (accidentNumber >= 6)
			System.out.println("Exceeded maximum permitted accidents...no insurance available");

	}

	// Getters and setters for age used in test ageCheckerTest
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
