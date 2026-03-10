package controller;

import app.SimpleBankingApp;
import model.User;

public class UserController {

	public static void loadUserData() {
		// structure of each record: username (email address), password, first_name, last_name, mobile_number
		User aUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
		SimpleBankingApp.users.add(aUser);

		aUser = new User("james.cameron@gmail.com", "angel", "James", "Cameron", "07777654321");
		SimpleBankingApp.users.add(aUser);

		aUser = new User("julia.roberts@gmail.com", "change_me", "Julia", "roberts", "07770123456");
		SimpleBankingApp.users.add(aUser);
	}

	public static void printAllUsers() {
		System.out.println("There are: " + SimpleBankingApp.users.size() + " users in the system.");
		System.out.println(String.format("%-25s| %-15s| %-15s| %-15s| %-15s",
				"username", "password", "first_name", "last_name", "mobile_number"));
		System.out.println("-------------------------------------------------------------------------------------------");

		for (int i = 0; i < SimpleBankingApp.users.size(); i++) {
			System.out.println(SimpleBankingApp.users.get(i).toString());
		}

		System.out.println();
	}
	
	public static User findUserByUsername(String username) {
		if (username == null) {
			return null;
		}
		
		for (int i = 0; i < SimpleBankingApp.users.size(); i++) {
			User currentUser = SimpleBankingApp.users.get(i);
			
			if (currentUser.getUsername().equals(username)) {
				return currentUser;
			}
		}
		
		return null;
	}
}