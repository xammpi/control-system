package com.mc.control.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department",
        uniqueConstraints = @UniqueConstraint(name = "department_name", columnNames = {"name"}))
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable = false)
    private Long id;
    @Column(name = "name",
            nullable = false)
    private String name;
    @ManyToMany(mappedBy = "reporterDepartments")
    private Set<Reporter> reporters = new HashSet<>();
    @ManyToMany(mappedBy = "departmentsProblem")
    private Set<Problem> departmentProblems = new HashSet<>();

}
