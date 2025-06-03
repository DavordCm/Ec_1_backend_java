package com.instituto.Evaluacion_Continua1.infraestructure.adapters.Student;

import com.instituto.Evaluacion_Continua1.domain.model.Student;
import com.instituto.Evaluacion_Continua1.domain.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentAdapter implements StudentRepository {

    private final StudentDataRepository studentDataRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentAdapter(StudentDataRepository studentDataRepository, StudentMapper studentMapper) {
        this.studentDataRepository = studentDataRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> findAll() {
        return studentDataRepository.findAll()
                .stream()
                .filter(studentData -> studentData.getActive() != 0)
                .map(studentMapper::toDomain)
                .toList();
    }

    @Override
    public Student findById(String uid) {
        Optional<StudentData> studentData = studentDataRepository.findById(uid);
        return studentData
                .filter(data -> data.getActive() == 1)
                .map(studentMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Student save(Student student) {
        StudentData saved = studentDataRepository.save(studentMapper.toEntity(student));
        return studentMapper.toDomain(saved);
    }

    @Override
    public Student update(Student student) {
        Optional<StudentData> existing = studentDataRepository.findById(student.uid());
        if (existing.isPresent()) {
            StudentData updated = studentMapper.toEntity(student);
            return studentMapper.toDomain(studentDataRepository.save(updated));
        }
        return null;
    }

    @Override
    public void delete(String uid) {
        Optional<StudentData> student = studentDataRepository.findById(uid);
        student.ifPresent(data -> {
            data.setActive(0);
            studentDataRepository.save(data);
        });
    }
}
