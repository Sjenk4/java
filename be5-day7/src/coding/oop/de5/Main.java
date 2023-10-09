package coding.oop.de5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final String SHOW_LOGIN = "1";
	static final String SHOW_REGISTER = "2";

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		AccountUsers accountUsers = new AccountUsers();
		ArrayList<Account> accountUser = new ArrayList<Account>();
		Account selectAccount = null;
		boolean checkDueAccount = false;
		int countErrors = 0;

		/*
		 * CourseList courseList = new CourseList(); courseList.initDataCourse();
		 */

		do {
			showMain();
			String selectUser = input.nextLine();

			switch (selectUser) {
			case SHOW_LOGIN:

				System.out.println("Please enter id account : ");
				String selectIDAccount = input.nextLine();
				System.out.println("Please enter password : ");
				String selectPassword = input.nextLine();

				if (accountUser.size() == 0) {
					System.out.println("Please create an account");
					break;
				}

				for (int index = 0; index < accountUser.size(); index++) {
					if (accountUser.get(index).idAccount.equals(selectIDAccount)
							&& accountUser.get(index).password.equals(selectPassword)) {
						selectAccount = accountUser.get(index);
					}
				}

				if (selectAccount == null) {
					System.out.println("User account or password incorrect");
					countErrors += 1;

					if (countErrors == 3) {
						accountUsers.deleteAccount(selectIDAccount);
						countErrors = 0;
					}
					break;
				}

				if (selectAccount != null) {
					System.out.println("=============");
					System.out.println("WELCOME : " + selectAccount.name);
					System.out.println("Invite you to choose our courses");
					showCourseList();
				}

				break;
			case SHOW_REGISTER:

				System.out.println("Please enter id account : ");
				String inputIDAccount = input.nextLine();

				for (int index = 0; index < accountUser.size(); index++) {

					if (accountUser.get(index).idAccount.equals(inputIDAccount)) {
						checkDueAccount = true;
						break;
					}
				}

				if (checkDueAccount == true) {
					System.out.println("Account already exists");
					break;
				}

				System.out.println("Please enter password : ");
				String inputPassword = input.nextLine();
				System.out.println("Please enter name: ");
				String inputName = input.nextLine();

				Account account = new Account(inputIDAccount, inputPassword, inputName);
				accountUser.add(account);

				break;
			default:
				System.out.println("Please only choose our function");
			}

		} while (selectAccount == null);

	}

	public static void showMain() {
		System.out.println("=============");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("=============");
	}

	public static void showCourseList() {

		CourseList courseList = new CourseList();
		courseList.initDataCourse();

		System.out.println("========================");
		System.out.println("0.Your Courses");
		System.out.print("1.Course: BE5 - Teacher: ");
		courseList.showCourseNameTeacher("BE5");
		System.out.print("2.Maths - Teacher: ");
		courseList.showCourseNameTeacher("Maths");
		System.out.print("3.Literature - Teacher: ");
		courseList.showCourseNameTeacher("Literature");
		System.out.print("4.English - Teacher: ");
		courseList.showCourseNameTeacher("English");
		System.out.println("========================");
	}
}
