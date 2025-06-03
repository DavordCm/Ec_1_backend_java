package com.instituto.Evaluacion_Continua1.infraestructure.adapters.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alumno")
public class StudentData {

    @Id
    @Column(length = 40)
    private String uid;

    @Column(name = "nro_documento", length = 30)
    private String documentNumber;

    @Column(name = "nombres", length = 60)
    private String name;

    @Column(name = "apellidos", length = 60)
    private String lastName;

    @Column(name = "telefono", length = 30)
    private String phone;

    @Column(name = "correo", length = 60)
    private String email;

    @Column(name = "foto", length = 100)
    private String photo;

    @Column(name = "activo")
    private int active;


}
