package app;

import controller.AccountController;
import controller.UserController;

public class TODO12FeatureDemo {

	public static void main(String[] args) {
		SimpleBankingApp.users.clear();
		SimpleBankingApp.accounts.clear();
		SimpleBankingApp.transactions.clear();

		UserController.loadUserData();
		AccountController.loadAccountData();

		System.out.println("Feature 1 demo: valid account transaction accepted = " +
				AccountController.addTransaction("5495-1234", 10.00));

		System.out.println("Feature 1 demo: invalid account transaction accepted = " +
				AccountController.addTransaction("9999-1111", 21.00));

		System.out.println("Feature 2 demo: mike has " +
				AccountController.getAccountsCountForUser("mike") + " account(s)");

		System.out.println("Feature 2 demo: David.McDonald@gmail.com has " +
				AccountController.getAccountsCountForUser("David.McDonald@gmail.com") + " account(s)");
		System.out.println("Feature 3 demo: findUserByUsername(\"mike\") returned = " +
				(UserController.findUserByUsername("mike") != null
						? UserController.findUserByUsername("mike").getUsername()
						: "null"));

		System.out.println("Feature 3 demo: findUserByUsername(\"not_exist_user\") returned = " +
				(UserController.findUserByUsername("not_exist_user") != null
						? UserController.findUserByUsername("not_exist_user").getUsername()
						: "null"));
	}
}