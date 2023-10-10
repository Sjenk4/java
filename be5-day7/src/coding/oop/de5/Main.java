package coding.oop.de5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static final String SHOW_LOGIN = "1";
	static final String SHOW_REGISTER = "2";
	static final int SHOW_YOUR_COURSES = 0;
	static final int SHOW_COURSE_BE5 = 1;
	static final int SHOW_COURSE_MATHS = 2;
	static final int SHOW_COURSE_LITERATURE = 3;
	static final int SHOW_COURSE_ENGLISH = 4;
	static final int REGISTER_COURSE = 1;
	static final int NO_REGISETER = 2;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		ArrayList<Account> accountUser = new ArrayList<Account>();
		AccountUsers accountUsers = new AccountUsers(accountUser);
		Account selectAccount = null;
		boolean checkDueAccount = false;
		int countErrors = 0;
		ArrayList<Course> courseUserSelect = new ArrayList<Course>();
		CourseUserSelect courseUserSelects = new CourseUserSelect(courseUserSelect);

		CourseList courseList = new CourseList();
		courseList.initDataCourse();

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

				selectAccount = accountUsers.findAccount(selectIDAccount, selectPassword);

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
					int selectCourse = 0;
					int selectRegister;
					Course selectCourseRegister;
					System.out.println("--------------");
					System.out.println("WELCOME : " + selectAccount.name);
					do {
						System.out.println("Invite you to choose our courses");

						do {
							showCourseList();
							Course DuplicateCourses = null;
							selectCourse = input.nextInt();
							String userSelectCourse = null;

							switch (selectCourse) {
							case SHOW_YOUR_COURSES:	
								if(courseUserSelect.size() == 0) {
									System.out.println("You do not choose any course");
									break;
								}
								String nameYourSelectCoures;
								for (int index = 0; index < courseUserSelect.size(); index++) {
									System.out.println("Course " + (index +1) + ": ");
									nameYourSelectCoures = courseUserSelect.get(index).nameCourse;
									courseList.showCourseUserSelect(nameYourSelectCoures);
									System.out.println();
								}
								break;

							case SHOW_COURSE_BE5:
								userSelectCourse = "BE5";
								break;

							case SHOW_COURSE_MATHS:
								userSelectCourse = "Maths";
								break;

							case SHOW_COURSE_LITERATURE:
								userSelectCourse = "Literature";
								break;

							case SHOW_COURSE_ENGLISH:
								userSelectCourse = "English";
								break;

							default:
								System.out.println("Please choose our course only");
								break;
							}
							
							if (selectCourse == 0) {
								System.out.println("GOOD BYE !!");
								break;
							}
							if (courseUserSelect.size() > 0) {
								DuplicateCourses = courseUserSelects.findDuplicateCourses(userSelectCourse);
							}
							if (DuplicateCourses != null) {
								System.out.println("Your select duplicate courses");
								break;
							}

							courseList.showCourseUserSelect(userSelectCourse);

							showSelectCourse();
							selectRegister = input.nextInt();
							selectCourseRegister = courseList.userCourseSelect(selectRegister, userSelectCourse);

							if (selectCourseRegister != null) {
								courseList.showCourseUserSelect(userSelectCourse);
								courseUserSelect.add(selectCourseRegister);
								System.out.println();
							}

						} while (selectCourse < 0 || selectCourse > 4);

					} while (selectCourse != 0);
				}

				break;
			case SHOW_REGISTER:

				System.out.println("Please enter id account : ");
				String inputIDAccount = input.nextLine();
				
				if(accountUser.size() > 0) {
				checkDueAccount = accountUsers.findAccountDuplicate(inputIDAccount);
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
		System.out.print("1.Course: BE5 - Menter: ");
		courseList.showCourseNameTeacher("BE5");
		System.out.print("2.Course: Maths - Menter: ");
		courseList.showCourseNameTeacher("Maths");
		System.out.print("3.Course: Literature - Menter: ");
		courseList.showCourseNameTeacher("Literature");
		System.out.print("4.Course: English - Menter: ");
		courseList.showCourseNameTeacher("English");
		System.out.println("========================");
	}

	public static void showSelectCourse() {
		System.out.println("=============");
		System.out.println("1. Register");
		System.out.println("2. No");
		System.out.println("=============");

	}
}
