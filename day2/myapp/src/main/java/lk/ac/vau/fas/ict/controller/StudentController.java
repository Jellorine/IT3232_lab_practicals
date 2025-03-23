package lk.ac.vau.fas.ict.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class StudentController {
	
	@GetMapping("student")
	public String Student() {
		return "Name: Jello\nCourse: IT\nRegistration No: 2020/ICT/06";
	}

}
