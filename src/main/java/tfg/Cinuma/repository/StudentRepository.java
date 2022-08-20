package tfg.Cinuma.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import tfg.Cinuma.Modelo.Student;

/**
 * @author ragcrix
 */

// No need implementation, just one interface, and you have CRUD, thanks Spring Data!
public interface StudentRepository extends MongoRepository<Student, String> {

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpaDesc();

}
