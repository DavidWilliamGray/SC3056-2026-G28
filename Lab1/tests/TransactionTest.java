package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Transaction;
import utils.TestUtils;

public class TransactionTest {
	public static void main(String[] args) {
		testTransactionConstructor();
	}

	public static void testTransactionConstructor() {
		// 1-Setup
		String test_account_number = "12345678";
		double test_transaction_amount = 500.78;
		String test_transaction_date_string = "03/06/2025";

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			Date test_transaction_date = sdf.parse(test_transaction_date_string);

			// 2-Exercise
			Transaction testTransaction = new Transaction(
				test_account_number,
				test_transaction_amount,
				test_transaction_date
			);

			// 3-Verify
			System.out.println("Starting the assertions of the test method testTransactionConstructor");

			if (test_account_number.equals(testTransaction.getAccount_number()))
				TestUtils.printTestPassed("TC1-getAccount_number");
			else
				TestUtils.printTestFailed("TC1-getAccount_number");

			if (test_transaction_amount == testTransaction.getTransation_amount())
				TestUtils.printTestPassed("TC2-getTransation_amount");
			else
				TestUtils.printTestFailed("TC2-getTransation_amount");

			if (test_transaction_date.equals(testTransaction.getTransaction_date()))
				TestUtils.printTestPassed("TC3-getTransaction_date");
			else
				TestUtils.printTestFailed("TC3-getTransaction_date");

		} catch (ParseException e) {
			System.out.println("Invalid date. Use format dd/MM/yyyy");
			e.printStackTrace();
		}
	}
}

/* TODO AI B - Creation of AI generated code for this section alongside minimal changes made to get it to function
// The package it attempted to use was model however I changed it to tests so that it could function 
package tests; 

import java.util.Date; 

import utils.TestUtils; 

// This line was added by me as it had forgotten to import the Transaction file
import model.Transaction;  

public class TransactionTest { 

  

    public static void main(String[] args) { 

        testTransactionConstructor(); 

    } 

  

    public static void testTransactionConstructor() { 

  

        // ========================= 

        // Setup 

        // ========================= 

        String expectedAccountNumber = "ACC123"; 

        double expectedAmount = 250.75; 

        Date expectedDate = new Date(); 

  

        // ========================= 

        // Exercise 

        // ========================= 

        Transaction transaction = new Transaction(expectedAccountNumber, expectedAmount, expectedDate); 

  

        String actualAccountNumber = transaction.getAccount_number(); 

        double actualAmount = transaction.getTransation_amount(); 

        Date actualDate = transaction.getTransaction_date(); 

  

        // ========================= 

        // Verify 

        // ========================= 

        if (expectedAccountNumber.equals(actualAccountNumber) && 

            expectedAmount == actualAmount && 

            expectedDate.equals(actualDate)) { 

  

            TestUtils.printTestPassed("testTransactionConstructor"); 

        } else { 

            TestUtils.printTestFailed("testTransactionConstructor"); 

        } 

    } 

}*/