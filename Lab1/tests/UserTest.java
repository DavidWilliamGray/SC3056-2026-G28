package tests;

import model.User;
import utils.TestUtils;

public class UserTest {
	public static void main(String[] args) {
		testUserConstructor();
		// TODO 5 - Calling for Assertions
		testUserConstructorUsingAssert();
	}
	public static void testUserConstructor() {
		/* Old manual testing
        User testUser = new User("mike", "my_password", "Mike", "Smith", "07771234567");
        System.out.println(testUser);
        */

        // Automated Testing
        // 1-Setup
        String test_username = "mike";
        String test_password = "my_password";
        String test_first_name = "Mike";
        String test_last_name = "Smith";
        String test_mobile_number = "07771234567";


        //2-Exercise
        User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);

        //3-Verify
        System.out.println("Starting the assertions of the test method testUserConstructor");
        
        /* Old Manual Testing
        if (testUser.getUsername() == test_username)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-Failed" + TestUtils.TEXT_COLOR_RESET);
        if (testUser.getPassword() == test_password)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword-Failed" + TestUtils.TEXT_COLOR_RESET);
        if (testUser.getFirst_name() == test_first_name)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getFirst_name-Failed" + TestUtils.TEXT_COLOR_RESET);
        if (testUser.getLast_name() == test_last_name)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getLast_name-Failed" + TestUtils.TEXT_COLOR_RESET);
        if (testUser.getMobile_number() == test_mobile_number)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobile_number-Failed" + TestUtils.TEXT_COLOR_RESET);
         */
        // TODO 3 - New refactored method using TestUtils
        if (test_username.equals(testUser.getUsername()))
            TestUtils.printTestPassed("TC1-getUsername");
        else
            TestUtils.printTestFailed("TC1-getUsername");
        if (test_password.equals(testUser.getPassword()))
            TestUtils.printTestPassed("TC2-getPassword");
        else
            TestUtils.printTestFailed("TC2-getPassword");
        if (test_first_name.equals(testUser.getFirst_name()))
            TestUtils.printTestPassed("TC3-getFirst_name");
        else
            TestUtils.printTestFailed("TC3-getFirst_name");
        if (test_last_name.equals(testUser.getLast_name()))
            TestUtils.printTestPassed("TC4-getLast_name");
        else
            TestUtils.printTestFailed("TC4-getLast_name");
        if (test_mobile_number.equals(testUser.getMobile_number()))
            TestUtils.printTestPassed("TC5-getMobile_number");
        else
            TestUtils.printTestFailed("TC5-getMobile_number");
        /* TODO4 - Intentional false positive due to wrong assertion
        if (test_last_name.equals(testUser.getMobile_number()))
            TestUtils.printTestPassed("TC4-getLast_name");
        else
            TestUtils.printTestFailed("TC4-getLast_name");
        if (test_mobile_number.equals(testUser.getLast_name()))
            TestUtils.printTestPassed("TC5-getMobile_number");
        else
            TestUtils.printTestFailed("TC5-getMobile_number");
        */
        
        /* TODO4 - Intentionally wrong comparison for replication (== compares references)
        if (testUser.getUsername() == test_username)
            TestUtils.printTestPassed("TC1-getUsername");
        else
            TestUtils.printTestFailed("TC1-getUsername");

        if (testUser.getPassword() == test_password)
            TestUtils.printTestPassed("TC2-getPassword");
        else
            TestUtils.printTestFailed("TC2-getPassword");

        if (testUser.getFirst_name() == test_first_name)
            TestUtils.printTestPassed("TC3-getFirst_name");
        else
            TestUtils.printTestFailed("TC3-getFirst_name");

        if (testUser.getLast_name() == test_last_name)
            TestUtils.printTestPassed("TC4-getLast_name");
        else
            TestUtils.printTestFailed("TC4-getLast_name");

        if (testUser.getMobile_number() == test_mobile_number)
            TestUtils.printTestPassed("TC5-getMobile_number");
        else
            TestUtils.printTestFailed("TC5-getMobile_number");
       */
	}
	// TODO 5 - Development of Assertions
	public static void testUserConstructorUsingAssert() {
		// 1-Setup
		String test_username = "mike";
		String test_password = "my_password";
		String test_first_name = "Mike";
		String test_last_name = "Smith";
		String test_mobile_number = "07771234567";

		// 2-Exercise
		User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);

		// 3-Verify using Java assert
		System.out.println("Starting the assertions of the test method testUserConstructorUsingAssert");

		assert test_username.equals(testUser.getUsername()) : "TC1-getUsername failed";
		assert test_password.equals(testUser.getPassword()) : "TC2-getPassword failed";
		assert test_first_name.equals(testUser.getFirst_name()) : "TC3-getFirst_name failed";
		assert test_last_name.equals(testUser.getLast_name()) : "TC4-getLast_name failed";
		assert test_mobile_number.equals(testUser.getMobile_number()) : "TC5-getMobile_number failed";

		System.out.println("All assert test cases passed");
	}
}
