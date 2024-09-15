package edu.mum.cs.cs425.e.registrar.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false, unique = true)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private Double cgpa;

    @Column(nullable = false)
    private LocalDate dateOfEnrollment;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InternationalStatus isInternational;
}

