package students.service.implemnt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import students.model.Student;
import students.reposit.Studrepositry;
import students.service.Studentservice;

@Service
public class Serviceimplement implements Studentservice {
	
	@Autowired
	Studrepositry strepo;

	
	
	//get all student data
	@Override
	public List<Student> getAllstudents() {
		
		return strepo.findAll();
	}

	

	// update student data
	
	@Override
	public Optional<Student> update(Student stu1) {
	
	if(strepo.existsById(stu1.getId()))
	{
		return Optional.of(strepo.save(stu1));
	}
	else
		return Optional.empty();
	}
	
	
	// get particular student data

	@Override
	public Optional<Student> getonedata(Long id) {
		return strepo.findById(id);
		
	}
	
	//create new student data
	@Override
	public Student create1(Student stu) {
		
		return strepo.save(stu);
	}


	
	//delete student data by id

	@Override
	public String delete(Long id) {
		
		if(strepo.existsById(id))
		{
			strepo.deleteById(id);
			return id+" deleted successfully ";
		}
		 else
		 {
			 return id+" not in the exist student data.";
		 }
		
	}

	

	

	

	

	

	

}
