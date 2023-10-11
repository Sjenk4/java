package coding.oop.de5;

import java.util.ArrayList;

public class CourseUserSelect {
	ArrayList<Course> courseUserSelect;

	public CourseUserSelect(ArrayList<Course> courseUserSelect) {
		super();
		this.courseUserSelect = courseUserSelect;
	}
	public Course findDuplicateCourses( String nameCourse) {
			for(int index = 0; index < courseUserSelect.size(); index++) {
				if( courseUserSelect.get(index).nameCourse.equals(nameCourse) ) {
					return this.courseUserSelect.get(index);
				}
			}
		return null;
	}
	
}
