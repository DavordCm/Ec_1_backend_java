package com.instituto.Evaluacion_Continua1.domain.model;

import java.util.List;

public interface StudentRepository {

    List<Student> findAll();

    Student findById(String uid);

    Student save(Student student);

    Student update(Student student);

    void delete(String uid);

}
