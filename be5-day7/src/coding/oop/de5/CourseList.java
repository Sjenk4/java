package coding.oop.de5;

public class CourseList {
	Course[] courseList;

	public void initDataCourse() {
		Course courseBe5 = new Course("BE5", "Dung", "10/9/2023", "10/3/2024", 1000 );
		Course courseMaths = new Course("Maths", "Dung", "9/6/2023", "6/9/2023", 1500);
		Course courseMaths2 = new Course("Maths", "Trung", "9/6/2023", "6/9/2023", 1500);
		Course courseBe51 = new Course("BE5", "Lam", "10/9/2023", "10/3/2024", 1000);
		Course courseLiterature = new Course("Literature", "Lam", "7/7/2023", "7/7/2024", 700);
		Course courseEnglish = new Course("English", "Quan", "10/8/2023", "20/4/2024", 900);
		Course[] courseList = { courseBe5, courseMaths, courseMaths2, courseBe51, courseLiterature, courseEnglish};
		this.courseList = courseList;

	}
	
	public void showCourseNameTeacher(String nameCourse) {
		
		for (int index = 0; index < courseList.length; index++) {
			if( courseList[index].nameCourse.equals(nameCourse) ) {
				System.out.print(" " + courseList[index].nameTeacher);
			}
		}
		System.out.println();
	}
	
	public void showCourseUserSelect (String nameCourse) {
		for(int index = 0; index < courseList.length; index++) {
			if( courseList[index].nameCourse.equals(nameCourse) ) {
				System.out.println("Name course: " + nameCourse);
				System.out.print("Menter: ");
				showCourseNameTeacher(nameCourse);
				System.out.println("Begin: " + courseList[index].begin);
				System.out.println("End: " + courseList[index].end);
				System.out.println("Fee: " + courseList[index].fee + " USD");
				break;
			}
		}
	}
	
	public Course userCourseSelect(int selectRegister, String nameCourse) {
		if( selectRegister == 1 ) {
			System.out.println("===========================");
			System.out.println("You register success course");
			System.out.println("===========================");
			for (int index = 0; index < courseList.length; index++) {
				if (courseList[index].nameCourse.equals(nameCourse)) {
					return this.courseList[index];
				}
			}
		}
		return null;
	}

}


