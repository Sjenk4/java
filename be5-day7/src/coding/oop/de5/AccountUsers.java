package coding.oop.de5;

import java.util.ArrayList;

public class AccountUsers {
	ArrayList<Account> accountUser;
	ArrayList<Account> accountUsers = new ArrayList<Account>();

	public AccountUsers(ArrayList<Account> accountUsers) {
		super();
		this.accountUsers = accountUsers;
	}

	public Account findAccount(String selectIDAccount, String selectPassword) {
		for (int index = 0; index < accountUsers.size(); index++) {
			if (accountUsers.get(index).idAccount.equals(selectIDAccount)
					&& accountUsers.get(index).password.equals(selectPassword)) {
				return this.accountUsers.get(index);
			}
		}
		return null;
	}

	public void deleteAccount(String selectIDAccount) {

		for (int count = 0; count < accountUsers.size(); count++) {
			if (accountUsers.get(count).idAccount.equals(selectIDAccount)) {
				accountUsers.remove(count);
				System.out.println("You have logged in incorrectly 3 times");
				System.out.println("Your account has been locked");
				System.out.println("Please create a new account again");
				break;
			}
		}
	}

	public boolean findAccountDuplicate(String inputIDAccount) {
		for (int index = 0; index < accountUsers.size(); index++) {
			if (accountUsers.get(index).idAccount.equals(inputIDAccount)) {
				return true;
			}
		}
		return false;
	}

}
