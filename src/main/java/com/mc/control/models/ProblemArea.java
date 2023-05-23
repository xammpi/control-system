package com.mc.control.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "problem_area",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "problem_area_number"}))
public class ProblemArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable = false)
    private Long id;
    @Column(name = "name",
            nullable = false)
    private String name;
    @Column(name = "problem_area_number")
    private int problemAreaNumber;
    @ManyToMany(mappedBy = "reporterProblemAreas")
    private Set<Reporter> reporterProblemAreas = new HashSet<>();
    @Embedded
    private Address address;

}
