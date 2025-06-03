package com.instituto.Evaluacion_Continua1.infraestructure.adapters.Student;


import com.instituto.Evaluacion_Continua1.domain.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {


    Student toDomain(StudentData entity);

    StudentData toEntity(Student domain);

}
