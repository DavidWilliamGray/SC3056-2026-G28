package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import app.SimpleBankingApp;
import model.Account;
import model.Transaction;

public class AccountController {

	public static void loadAccountData() {
		Account anAccount;

		try {
			anAccount = new Account("5495-1234", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
			SimpleBankingApp.accounts.add(anAccount);

			anAccount = new Account("5495-1239", "mike", "Standard", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"));
			SimpleBankingApp.accounts.add(anAccount);

			anAccount = new Account("5495-1291", "mike", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("21/07/2019"));
			SimpleBankingApp.accounts.add(anAccount);

			anAccount = new Account("5495-6789", "David.McDonald@gmail.com", "Saving", new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2019"));
			SimpleBankingApp.accounts.add(anAccount);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void printAllAccounts() {
		System.out.println("There are: " + SimpleBankingApp.accounts.size() + " accounts in the system.");
		System.out.println(String.format("%-10s| %-30s| %-10s| %-15s| %-15s",
				"Account #", "username_of_account_holder", "type", "opening_date", "Balance"));
		System.out.println("--------------------------------------------------------------------------------");

		for (int i = 0; i < SimpleBankingApp.accounts.size(); i++) {
			System.out.println(SimpleBankingApp.accounts.get(i).toString() + "| $" +
					getBalance(SimpleBankingApp.accounts.get(i).getAccount_number()));
		}

		System.out.println();
	}

	// Feature 1 helper
	public static boolean accountExists(String account_number) {
		for (int i = 0; i < SimpleBankingApp.accounts.size(); i++) {
			if (SimpleBankingApp.accounts.get(i).getAccount_number().equals(account_number)) {
				return true;
			}
		}
		return false;
	}

	// Feature 1 improvement
	public static boolean addTransaction(String account_number, double amount) {
		if (!accountExists(account_number)) {
			return false;
		}

		Transaction aTransaction = new Transaction(account_number, amount, Calendar.getInstance().getTime());
		SimpleBankingApp.transactions.add(aTransaction);
		return true;
	}

	public static double getBalance(String account_number) {
		double balance = 0;

		for (int i = 0; i < SimpleBankingApp.transactions.size(); i++) {
			if (SimpleBankingApp.transactions.get(i).getAccount_number().equals(account_number)) {
				balance = balance + SimpleBankingApp.transactions.get(i).getTransation_amount();
			}
		}

		return balance;
	}

	// Feature 2 new function
	public static int getAccountsCountForUser(String username) {
		int count = 0;

		for (int i = 0; i < SimpleBankingApp.accounts.size(); i++) {
			if (SimpleBankingApp.accounts.get(i).getUsername_of_account_holder().equals(username)) {
				count++;
			}
		}

		return count;
	}
}