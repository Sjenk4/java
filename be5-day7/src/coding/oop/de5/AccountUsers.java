package coding.oop.de5;

import java.util.ArrayList;

public class AccountUsers {
	ArrayList<Account> accountUser;
	
	public void deleteAccount(String selectIDAccount) {

		for(int count = 0 ; count < accountUser.size(); count++) {
			if(accountUser.get(count).idAccount.equals(selectIDAccount)) {
				accountUser.remove(count);
			}
	}
	}
}

