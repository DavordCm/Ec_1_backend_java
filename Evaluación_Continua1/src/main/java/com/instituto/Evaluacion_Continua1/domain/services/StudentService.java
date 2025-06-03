package com.instituto.Evaluacion_Continua1.domain.services;

import com.instituto.Evaluacion_Continua1.domain.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> findAll();
    Student findById(String uid);
    Student save(Student student);
    Student update(Student student);
    void delete(String uid);

}
