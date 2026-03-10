package tests;

import app.SimpleBankingApp;
import controller.AccountController;
import controller.UserController;
import model.User;
import utils.TestUtils;

public class SimpleBankingAppTest {

	public static void resetAndLoadData() {
		SimpleBankingApp.users.clear();
		SimpleBankingApp.accounts.clear();
		SimpleBankingApp.transactions.clear();

		UserController.loadUserData();
		AccountController.loadAccountData();
	}

	public static void testLoadData() {
		SimpleBankingApp.users.clear();
		SimpleBankingApp.accounts.clear();
		SimpleBankingApp.transactions.clear();

		UserController.loadUserData();

		if (SimpleBankingApp.users.size() == 3)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadUserData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadUserData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

		AccountController.loadAccountData();

		if (SimpleBankingApp.accounts.size() == 4)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testLoadData: loadAccountData: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testLoadData: loadAccountData: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
	}

	public static void testDeposits() {
		resetAndLoadData();

		double balanceBefore = AccountController.getBalance("5495-1234");
		double depositAmount = 50.21;

		AccountController.addTransaction("5495-1234", depositAmount);
		double balanceAfter = AccountController.getBalance("5495-1234");

		assert balanceBefore + depositAmount == balanceAfter;
		if (balanceBefore + depositAmount == balanceAfter)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testDeposits: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testDeposits: TC1 FAILED XXX: balanceBefore + depositAmount != balanceAfter");
			System.out.format("testDeposits: balanceBefore = %.2f ; depositAmount = %.2f ; balanceAfter = %.2f %s\n",
					balanceBefore, depositAmount, balanceAfter, TestUtils.TEXT_COLOR_RESET);
		}

		AccountController.addTransaction("5495-1234", -depositAmount);
	}

	public static void testWithdrawals() {
		resetAndLoadData();

		double balanceBefore = AccountController.getBalance("5495-1234");
		double withdrawalAmount = 20.00;

		AccountController.addTransaction("5495-1234", -withdrawalAmount);
		double balanceAfter = AccountController.getBalance("5495-1234");

		assert balanceBefore - withdrawalAmount == balanceAfter;
		if (balanceBefore - withdrawalAmount == balanceAfter)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testWithdrawals: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "testWithdrawals: TC1 FAILED XXX: balanceBefore - withdrawalAmount != balanceAfter");
			System.out.format("testWithdrawals: balanceBefore = %.2f ; withdrawalAmount = %.2f ; balanceAfter = %.2f %s\n",
					balanceBefore, withdrawalAmount, balanceAfter, TestUtils.TEXT_COLOR_RESET);
		}

		AccountController.addTransaction("5495-1234", withdrawalAmount);
	}

	// Feature 1 test
	public static void testRejectInvalidTransaction() {
		resetAndLoadData();

		int transactionCountBefore = SimpleBankingApp.transactions.size();
		boolean result = AccountController.addTransaction("9999-1111", 21.00);
		int transactionCountAfter = SimpleBankingApp.transactions.size();

		if (!result && transactionCountBefore == transactionCountAfter)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testRejectInvalidTransaction: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testRejectInvalidTransaction: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);
	}

	// Feature 2 test
	public static void testGetAccountsCountForUser() {
		resetAndLoadData();

		int mikeCount = AccountController.getAccountsCountForUser("mike");
		int davidCount = AccountController.getAccountsCountForUser("David.McDonald@gmail.com");

		if (mikeCount == 3)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testGetAccountsCountForUser: TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testGetAccountsCountForUser: TC1 FAILED" + TestUtils.TEXT_COLOR_RESET);

		if (davidCount == 1)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "testGetAccountsCountForUser: TC2 passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "testGetAccountsCountForUser: TC2 FAILED" + TestUtils.TEXT_COLOR_RESET);
	}
	
	// Feature 3 Test
	public static void testFindUserByUsername() {
		resetAndLoadData();
		
		User foundUser = UserController.findUserByUsername("mike");
		User missingUser = UserController.findUserByUsername("not_exist_user");
		
		if (foundUser != null)
			TestUtils.printTestPassed("testFindUserByUsername: TC1");
		else
			TestUtils.printTestFailed("testFindUserByUsername: TC1");
		
		if (foundUser != null && "mike".equals(foundUser.getUsername()))
			TestUtils.printTestPassed("testFindUserByUsername: TC2");
		else
			TestUtils.printTestFailed("testFindUserByUsername: TC2");
		
		if (missingUser == null)
			TestUtils.printTestPassed("testFindUserByUsername: TC3");
		else
			TestUtils.printTestFailed("testFindUserByUsername: TC3");
	}

	public static void main(String[] args) {
		testLoadData();
		testDeposits();
		testWithdrawals();
		testRejectInvalidTransaction();
		testGetAccountsCountForUser();
		testFindUserByUsername();
	}
}