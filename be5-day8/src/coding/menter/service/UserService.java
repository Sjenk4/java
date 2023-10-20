package coding.menter.service;

import java.util.ArrayList;

import coding.menter.data.Course;
import coding.menter.data.Menter;
import coding.menter.data.User;
import coding.menter.db.Database;

public class UserService {

	public void registerNewUser(User user) {
		User users = new User();
		int i;
		for (i = 0; i < Database.USERS_DB.size(); i++) {
			if (Database.USERS_DB.get(i).getId().equals(user.getId())) {
				System.out.println("User is exists");
				break;
			}
		}
		if (i == Database.USERS_DB.size()) {
			Database.USERS_DB.add(users);
			System.out.println("Register successfully");
		}
	}

	public User login(String id, String password) {
		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (Database.USERS_DB.get(i).getId().equals(id)
					&& Database.USERS_DB.get(i).getPassword().equals(password)) {
				return Database.USERS_DB.get(i);
			}
			if (Database.USERS_DB.get(i).getId().equals(id) && Database.USERS_DB.get(i).getFailedCount() == 3) {
				System.out.println("Your account has been locked");
				return null;
			}
			if (Database.USERS_DB.get(i).getId().equals(id)) {
				int getFailedCount = Database.USERS_DB.get(i).getFailedCount() + 1;
				Database.USERS_DB.get(i).setFailedCount(getFailedCount);
				System.out.println("Id or password is wrong");
				return null;
			}
		}
		System.out.println("Account does not exist");
		return null;
	}

	public void showRegisterCoursesToUser(User user) {
		if (user.getRegisteredCourses() == null) {
			System.out.println("You have not registered for any courses yet");
		}
		if (user.getRegisteredCourses() != null) {
			for (int i = 0; i < user.getRegisteredCourses().size(); i++) {
				System.out.println("==============================================");
				System.out.println("Name course: " + user.getRegisteredCourses().get(i).getName());
				System.out
						.println("Mentor: " + user.getRegisteredCourses().get(i).getTeachingMentors().get(i).getName());
				System.out.println("Begin: " + user.getRegisteredCourses().get(i).getBegin());
				System.out.println("End: " + user.getRegisteredCourses().get(i).getEnd());
				System.out.println("Fee: " + user.getRegisteredCourses().get(i).getFee());
				System.out.println("==============================================");
			}
		}
	}

	public void registerNewCourse(int idCourse, User user) {
		ArrayList<Course> registeredCourses = new ArrayList<Course>();
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			if (Database.COURSES_DB.get(i).getId() == idCourse) {
				registeredCourses.add(Database.COURSES_DB.get(i));
				user.setRegisteredCourses(registeredCourses);
			}
		}
	}

}
