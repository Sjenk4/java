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

		boolean idUserSelect = false;
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
				idUserSelect = userService.login(idUserInput, passUserUnput);

				if (idUserSelect == true) {
					for (User user : Database.USERS_DB) {
						if (user.getId().equals(idUserInput)) {
							System.out.println("Hello " + user.getName());
							break;
						}
					}
					int userChoosesCourse = 0;
					do {
					System.out.println("0: Show my registered Courses");
					courseService.showAllCourse();
					userChoosesCourse = input.nextInt();
					courseService.showCourseDetails(userChoosesCourse);
					System.out.println("1. Register");
					System.out.println("2. No");
					System.out.println("3. ViewMentorDetails");
					int userInput = input.nextInt();
					switch (userInput) {
					case REGISTER_COURSE:
						userService.registerNewCourse(userChoosesCourse,idUserInput );
						System.out.println("You reguseter success course all info");
						break;
					case NO_REGISTER:
						
						break;
					case VIEW_MENTOR_DETAILS:
							
						break;
					default:
						break;
					}
					}while(userChoosesCourse != 0);
					
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
		} while (idUserSelect == false);

	}

}
