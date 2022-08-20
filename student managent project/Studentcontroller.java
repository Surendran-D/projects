package students.controll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import students.model.Student;
import students.service.Studentservice;

@Controller
public class Studentcontroller {
	
	@Autowired
	Studentservice studservice;
	
//	@GetMapping("students") // thymeleaf used to get all the student data
//	public ModelAndView listofstudents()
//	{
//		ModelAndView mv=new ModelAndView("students");
//		mv.addObject("studentslist", studservice.getAllstudents());
//		return mv;	
//	}
	
	
	
	
	@RequestMapping("addstudent")
	public ResponseEntity<Student> addstudent(@RequestBody Student stud)
	{
		//ModelAndView mv=new ModelAndView("");
		Student st=studservice.create1(stud);
		
		return new ResponseEntity<>(st,HttpStatus.OK);
		
		
	}
	
	

	//{} this symbol indicates get id from given input and send to pathvariable
	@GetMapping("getonestudent/{id}")
	public ResponseEntity<Student> getonestudent(@PathVariable("id") Long id2)
	{
		Optional <Student> getonestud=studservice.getonedata(id2);
		if(getonestud.isPresent())
		{
			return new ResponseEntity<>(getonestud.get(),HttpStatus.OK);
		}
		else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PutMapping("update")
	public ResponseEntity<String> updatestudent(@RequestBody Student updatestud)
	{
		Optional<Student> upstu=studservice.update(updatestud);
		if(upstu.isEmpty())
		{
			return new ResponseEntity<>("The student details not registered ",HttpStatus.NOT_FOUND);
		}
		else
		return new ResponseEntity<>("The student details updated successfully",HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("getallstudent")
	public ResponseEntity<List> getallstudent()
	{
		List <Student> lst=studservice.getAllstudents();
		return new ResponseEntity<>(lst,HttpStatus.OK);
		
	}
	
	@GetMapping("delete/{id}")
	public ResponseEntity<String> deletestudent(@PathVariable ("id") Long id1)
	{
		String del=studservice.delete(id1);
		return new ResponseEntity<>(del,HttpStatus.OK);
		
		
		
		
	}
	

}
