package lk.ac.vau.fas.ict.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lk.ac.vau.fas.ict.model.Student;
@RestController
@RequestMapping("/app")
public class StudentController {
	
	Student s1 = new Student("2020ICT06","C.L.Jellorine",23,"IT",3.77);
	Student s2 = new Student("2020ICT49","Minindu Thiranjaya",25,"IT",3.67);
	Student s3 = new Student("2020ICT07","Udara Kavishka",24,"IT",3.75);
	Student s4 = new Student("2020ICT91","Dilmy Perera",25,"IT",3.45);
	
	List<Student> students = new ArrayList<Student>();
	
	public StudentController() {
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
	}
	
	@GetMapping("stu")
	public String Student() {
		return "Hello Spring Boot";
	}
	@GetMapping("/age/{ag}")
	public String MyAge(@PathVariable("ag") int age){
		return "My age is "+age;
	}
	
	//return a student
	@GetMapping("student")
	public Student StudentDetails() {
		return s1;
	}
	
	//return multiple student
	@GetMapping("all_students")
	public List<Student> AllStudentDetails() {
		
		return students;
	}
	
	
	//find a student from the list by regNO
	@GetMapping("/student/{regNo}")
	public Student GetStudentByRegNO(@PathVariable("regNo") String regNo) {
		for(Student st: students) {
			if (st.getRegNo().equals(regNo)){
					return st;
			}
		}
		return null;
	}
	
	//find the students whose age is between 20 and 23
	@GetMapping("/student/age_filter")
	public Student AgeFilter() {
		for(Student st: students) {
			if (st.getAge()>20 && st.getAge()<23){
					return st;
			}
		}
		return null;
	}
	//sort the students by their GPA
	//create CRUD operations for students

}
