package com.instituto.Evaluacion_Continua1.infraestructure.entries;

import com.instituto.Evaluacion_Continua1.domain.model.Student;
import com.instituto.Evaluacion_Continua1.domain.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instituto/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
//obtener
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }
//obtener
    @GetMapping("/{uid}")
    public Student getStudentById(@PathVariable("uid") String uid) {
        return studentService.findById(uid);
    }
//crear
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(studentService.save(student));
    }
//actualizar
    @PutMapping("/{uid}")
    public ResponseEntity<Student> updateStudent(@PathVariable("uid") String uid, @RequestBody Student student) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(studentService.update(student));
    }
//eliminar
    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("uid") String uid) {
        studentService.delete(uid);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
