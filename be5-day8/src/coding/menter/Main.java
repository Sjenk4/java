package coding.menter;

import java.util.Scanner;

import coding.menter.data.User;
import coding.menter.db.Database;
import coding.menter.service.CourseService;
import coding.menter.service.UserService;

public class Main {

	static final String LOGIN_ACCOUNT = "1";
	static final String REGISTER_ACCOUNT = "2";
	static final int REGISTER_COURSE = 1;
	static final int NO_REGISTER = 2;
	static final int VIEW_MENTOR_DETAILS = 3;

	public static void main(String[] args) {
		CourseService courseService = new CourseService();
		UserService userService = new UserService();
		Database.initDB();
		Scanner input = new Scanner(System.in);

		User idUserLogin = null;
		do {
			System.out.println("-----------");
			System.out.println("1.Login");
			System.out.println("2.Register");
			System.out.println("-----------");
			String userSelect = input.nextLine();

			switch (userSelect) {
			case LOGIN_ACCOUNT:
				System.out.println("your id");
				String idUserInput = input.nextLine();
				System.out.println("your password");
				String passUserUnput = input.nextLine();
				idUserLogin = userService.login(idUserInput, passUserUnput);

				if (idUserLogin != null) {
					System.out.println("Hello " + idUserLogin.getName());
					int userChoosesCourse = 0;
					do {
						showAllCoursesAndUserRegisteredCourses();
						userChoosesCourse = input.nextInt();
						if (userChoosesCourse == 0) {
							userService.showRegisterCoursesToUser(idUserLogin);
							break;
						}
						courseService.showCourseDetails(userChoosesCourse);
						System.out.println("1. Register");
						System.out.println("2. No");
						System.out.println("3. ViewMentorDetails");
						int userInput = input.nextInt();
						doRegisterCourseAndShowMentorByCourse(userInput, userChoosesCourse, idUserLogin);
					} while (userChoosesCourse != 0);
				}
				break;
			case REGISTER_ACCOUNT:
				System.out.println("input id");
				String id = input.nextLine();
				System.out.println("input password");
				String pass = input.nextLine();
				System.out.println("input name");
				String name = input.nextLine();

				userService.registerNewUser(id, pass, name);
				break;

			default:
				System.out.println("Please choose only 1 or 2");
				break;
			}
		} while (idUserLogin == null);

	}

	public static void doRegisterCourseAndShowMentorByCourse(int userInput, int userChoosesCourse, User idUserLogin) {
		CourseService courseService = new CourseService();
		UserService userService = new UserService();
		switch (userInput) {
		case REGISTER_COURSE:
			userService.registerNewCourse(userChoosesCourse, idUserLogin);
			System.out.println("You reguseter success course all info");
			break;
		case NO_REGISTER:

			break;
		case VIEW_MENTOR_DETAILS:
			courseService.showMentorByCourse(userChoosesCourse);
			break;
		default:
			System.out.println("Please choose only our selections");
			break;
		}
	}

	public static void showAllCoursesAndUserRegisteredCourses() {
		CourseService courseService = new CourseService();
		System.out.println("0: Show my registered Courses");
		courseService.showAllCourse();
	}
}
