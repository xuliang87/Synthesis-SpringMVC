package aa.mine.service;

import org.springframework.stereotype.Service;

import aa.mine.model.Course;

@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}
