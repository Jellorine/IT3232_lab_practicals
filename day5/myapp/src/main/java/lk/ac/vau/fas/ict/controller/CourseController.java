package lk.ac.vau.fas.ict.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lk.ac.vau.fas.ict.model.Course;

@RestController
@RequestMapping("/course")
public class CourseController extends CRUDcontroller<String, Course>{
	public CourseController(){
		Course ecom = new Course("IT3232","E commerce",2);
		Course webservice = new Course("IT2234","Web services and technologies",4);
		Course webapplication = new Course("CSC3132", "Web Application Development", 3);
		
		getMap().put(ecom.getCourseID(),ecom);
		getMap().put(webservice.getCourseID(),webservice);
		getMap().put(webapplication.getCourseID(),webapplication);
		
		
	}
}
