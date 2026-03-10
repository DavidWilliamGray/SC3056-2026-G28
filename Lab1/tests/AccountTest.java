package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Account;
import utils.TestUtils;

public class AccountTest {
	public static void main(String[] args) {
		testAccountConstructor();
	}

	public static void testAccountConstructor() {
		// 1-Setup
		String test_account_number = "123456";
		String test_username_of_account_holder = "mike";
		String test_account_type = "Standard";
		String test_account_opening_date_string = "22/12/2000";

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			Date test_account_opening_date = sdf.parse(test_account_opening_date_string);

			// 2-Exercise
			Account testAccount = new Account(
				test_account_number,
				test_username_of_account_holder,
				test_account_type,
				test_account_opening_date
			);

			// 3-Verify
			System.out.println("Starting the assertions of the test method testAccountConstructor");

			if (test_account_number.equals(testAccount.getAccount_number()))
				TestUtils.printTestPassed("TC1-getAccount_number");
			else
				TestUtils.printTestFailed("TC1-getAccount_number");

			if (test_username_of_account_holder.equals(testAccount.getUsername_of_account_holder()))
				TestUtils.printTestPassed("TC2-getUsername_of_account_holder");
			else
				TestUtils.printTestFailed("TC2-getUsername_of_account_holder");

			if (test_account_type.equals(testAccount.getAccount_type()))
				TestUtils.printTestPassed("TC3-getAccount_type");
			else
				TestUtils.printTestFailed("TC3-getAccount_type");

			if (test_account_opening_date.equals(testAccount.getAccount_opening_date()))
				TestUtils.printTestPassed("TC4-getAccount_opening_date");
			else
				TestUtils.printTestFailed("TC4-getAccount_opening_date");

		} catch (ParseException e) {
			System.out.println("Invalid date format. Please use dd/MM/yyyy");
			e.printStackTrace();
		}
	}
}