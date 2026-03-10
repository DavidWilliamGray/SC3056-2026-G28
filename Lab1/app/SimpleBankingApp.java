package app;

import java.util.Vector;

import controller.AccountController;
import controller.UserController;
import model.Account;
import model.Transaction;
import model.User;

public class SimpleBankingApp {

	public static Vector<User> users = new Vector<User>();
	public static Vector<Account> accounts = new Vector<Account>();
	public static Vector<Transaction> transactions = new Vector<Transaction>();

	public static void main(String[] args) {

		UserController.loadUserData();
		// let's print them all to see if they have been loaded (populated) properly
		UserController.printAllUsers();

		AccountController.loadAccountData();
		// let's print them all to see if they have been loaded (populated) properly
		System.out.println("Accounts: initial state, after loading...");
		AccountController.printAllAccounts();

		// let's do some activities on the populated accounts, add transactions, etc.
		// Deposit: adding a transaction with a positive value
		// Withdraw: adding a transaction with a negative value
		AccountController.addTransaction("5495-1234", -50.21);
		System.out.println("Account: after the 1st addTransaction function call...");
		AccountController.printAllAccounts();

		// and some more activities on the accounts
		AccountController.addTransaction("5495-1234", 520.00);
		AccountController.addTransaction("9999-1111", 21.00); // it seems this account does not exist in the loaded (populated) data,
															 // but the addTransaction does not do that check, need to improve that function in future

		// let's print the accounts and their balance to see if the above transaction have impacted their balances
		System.out.println("Account: after the 2nd/3rd addTransaction function calls...");
		AccountController.printAllAccounts();
	}
}
