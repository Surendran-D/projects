package students.service;

import java.util.List;
import java.util.Optional;

import students.model.Student;

public interface Studentservice {
	
	List<Student> getAllstudents();
	
	Optional<Student> getonedata(Long id);
	Optional<Student> update(Student stu1);
	Student create1(Student stu);
	String delete(Long id);


	

}
