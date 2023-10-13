package coding.menter.service;

import java.util.ArrayList;

import coding.menter.data.Course;
import coding.menter.data.User;
import coding.menter.db.Database;

public class UserService {

	public void registerNewUser(String id, String password, String name) {
		User user = new User(id, password, name);
		int i;
		for (i = 0; i < Database.USERS_DB.size(); i++) {
			if (Database.USERS_DB.get(i).getId().equals(id)) {
				System.out.println("User is exists");
				break;
			}
		}
		if (i == Database.USERS_DB.size()) {
			Database.USERS_DB.add(user);
			System.out.println("Register successfully");
		}
	}

	public boolean login(String id, String password) {
		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (Database.USERS_DB.get(i).getId().equals(id) && Database.USERS_DB.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (Database.USERS_DB.get(i).getId().equals(id) && Database.USERS_DB.get(i).getFailedCount() == 3) {
				System.out.println("Your account has been locked");
				return false;
			}
			if (Database.USERS_DB.get(i).getId().equals(id)) {
				int getFailedCount = Database.USERS_DB.get(i).getFailedCount() + 1;
				Database.USERS_DB.get(i).setFailedCount(getFailedCount);
				System.out.println("Id or password is wrong");
				return false;
			}
		}

		return false;
	}

	public void showRegisterCoursesToUser(User user, int userChoosesCourse) {
		ArrayList<Course> registeredCourses = new  ArrayList<Course>();
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			if(userChoosesCourse ==  Database.COURSES_DB.get(i).getId()) {
				for (int j = 0; j < Database.USERS_DB.size(); j++) {
					if(Database.USERS_DB.get(j).getId().equals(user)) {
						registeredCourses.add(Database.COURSES_DB.get(j));
						break;
					}
				}
			}
		}
	}

	public void registerNewCourse(int idCourse, String idUser) {
		ArrayList<Course> registeredCourses = new  ArrayList<Course>();
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			if(idCourse ==  Database.COURSES_DB.get(i).getId()) {
				for (int j = 0; j < Database.USERS_DB.size(); j++) {
					if(Database.USERS_DB.get(j).getId().equals(idUser)) {
						registeredCourses.add(Database.COURSES_DB.get(j));
						break;
					}
				}
			}
		}
	}

}
