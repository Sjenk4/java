package coding.menter.service;


import coding.menter.data.Course;
import coding.menter.data.Menter;
import coding.menter.db.Database;

public class CourseService {

	public void showAllCourse() {
		for (int index = 0; index < Database.COURSES_DB.size(); index++) {
			System.out.print((index + 1) + ": " + Database.COURSES_DB.get(index).getName());
			for (Menter mentor : Database.COURSES_DB.get(index).getTeachingMentors()) {
				System.out.print("-- mentor name:" + mentor.getName());
			}
			System.out.println();
		}
	}

	public void showCourseDetails(int id) {
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			if (Database.COURSES_DB.get(i).getId() == id) {
				System.out.println("-------------------------");
				System.out.println("Name: " + Database.COURSES_DB.get(i).getName());
				for (Menter mentor : Database.COURSES_DB.get(i).getTeachingMentors()) {
				System.out.print("Metor: " + mentor.getName());
				System.out.print(" ");
				}
				System.out.println();
				System.out.println("Begin: " + Database.COURSES_DB.get(i).getBegin());
				System.out.println("End: " + Database.COURSES_DB.get(i).getEnd());
				System.out.println("Fee: " + Database.COURSES_DB.get(i).getFee());
				System.out.println("-------------------------");
				break;
			}
		}
	}

	public void showMentorByCourse(int idCourse) {
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {
			if(Database.COURSES_DB.get(i).getId() == idCourse) {
				for (int second = 0; second < Database.COURSES_DB.get(i).getTeachingMentors().size(); second ++) {
					System.out.println("-------------------------");
					System.out.println("Name Mentor:" + Database.COURSES_DB.get(i).getTeachingMentors().get(second).getName());
					System.out.println("Email Mentor:" + Database.COURSES_DB.get(i).getTeachingMentors().get(second).getEmail());
					System.out.println("Phone Mentor:" + Database.COURSES_DB.get(i).getTeachingMentors().get(second).getPhone());
					System.out.println("-------------------------");
				}
			}
		}		
	}

}
