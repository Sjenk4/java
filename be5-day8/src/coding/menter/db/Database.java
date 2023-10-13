package coding.menter.db;

import java.util.ArrayList;
import java.util.Date;

import coding.menter.data.Course;
import coding.menter.data.Menter;
import coding.menter.data.User;

public class Database {
	public static ArrayList<Menter> MENTORS_DB = new ArrayList<>();
	public static ArrayList<Course> COURSES_DB = new ArrayList<>();
	public static ArrayList<User> USERS_DB = new ArrayList<>();

	public static void initDB() {
		MENTORS_DB.add(new Menter(1, "Dung", "dung@gmail.com", "0909"));
		MENTORS_DB.add(new Menter(2, "Lam", "lam@gmail.com", "0202"));
		MENTORS_DB.add(new Menter(3, "Trung", "trung@gmail.com", "0923"));
		MENTORS_DB.add(new Menter(4, "Quan", "quan@gmail.com", "0987"));
		
		ArrayList<Menter> teachingMentors = new ArrayList<Menter>();
		teachingMentors.add(MENTORS_DB.get(0));
		COURSES_DB.add(new Course(1, "BE 5", teachingMentors, new Date(), new Date(), 3000));
		
		teachingMentors = new ArrayList<Menter>();
		teachingMentors.add(MENTORS_DB.get(0));
		teachingMentors.add(MENTORS_DB.get(1));
		COURSES_DB.add(new Course(2, "BE 2", teachingMentors, new Date(), new Date(), 2500));
		
		teachingMentors = new ArrayList<Menter>();
		teachingMentors.add(MENTORS_DB.get(1));
		teachingMentors.add(MENTORS_DB.get(3));
		COURSES_DB.add(new Course(3, "DATA 3", teachingMentors, new Date(), new Date(), 3500));
		
		teachingMentors = new ArrayList<Menter>();
		teachingMentors.add(MENTORS_DB.get(2));
		COURSES_DB.add(new Course(4, "DATA 6", teachingMentors, new Date(), new Date(), 2000));
	}
}
