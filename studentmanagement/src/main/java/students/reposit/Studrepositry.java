package students.reposit;

import org.springframework.data.jpa.repository.JpaRepository;

import students.model.Student;


public interface Studrepositry extends JpaRepository<Student, Long> {

}
