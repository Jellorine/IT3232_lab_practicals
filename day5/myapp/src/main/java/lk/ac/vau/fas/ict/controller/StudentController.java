package lk.ac.vau.fas.ict.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lk.ac.vau.fas.ict.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	Student s1 = new Student("2020ICT06","C.L.Jellorine",23,"IT",3.77);
	Student s2 = new Student("2020ICT49","Minindu Thiranjaya",25,"IT",3.67);
	Student s3 = new Student("2020ICT07","Udara Kavishka",24,"IT",3.75);
	Student s4 = new Student("2020ICT91","Dilmy Perera",25,"IT",3.45);
	
	List<Student> students = new ArrayList<Student>();
	private Map<String, Student> mstudents = new HashMap<String, Student>();
	
	public StudentController() {
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		mstudents.put(s1.getRegNo(), s1);
		mstudents.put(s2.getRegNo(), s2);
		mstudents.put(s3.getRegNo(), s3);
		mstudents.put(s4.getRegNo(), s4);
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
	
	@GetMapping("student/all")
	public Map<String,Student> StudentDet() {
		return mstudents;
	}
	
	//return multiple student
	@GetMapping("all_students")
	public List<Student> AllStudentDetails() {
		
		return students;
	}
	
	
	//find a student from the list by regNO
	@GetMapping("/student/{regNo}")
	public Student GetStudentByRegNO(@PathVariable("regNo") String regNo) {
		/*
		for(Student st: students) {
			if (st.getRegNo().equals(regNo)){
					return st;
			}
		}
		return null;
		*/
		return mstudents.get(regNo);
	}
	
	//add a student
	@PostMapping("/addstudent")
	public String AddStudent(@RequestBody Student student) {
		mstudents.put(student.getRegNo(), student);
		return "New student added";
		
	}
	
	@DeleteMapping("delete_stu/{regno}")
	public String DeleteStudent(@PathVariable("regno") String regno) {
		if(mstudents.get(regno) != null) {
			mstudents.remove(regno);
			return "Student deleted successfully";
		}
		return "Student not found";
	}
	
	@PutMapping("up_stu/{regno}")
	public String UpdateStudent(@PathVariable("regno") String regno, @RequestBody Student stu) {
		if(mstudents.get(regno) != null) {
			mstudents.put(stu.getRegNo(), stu);
			return "Student details updated";
		}
		return "Student not found";
	}
	//find the students whose age is between 20 and 23
	//sort the students by their GPA
	//create CRUD operations for students

}
