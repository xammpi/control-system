package com.mc.control.models;

import com.mc.control.models.common.UserInfo;
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
@Table(name = "reporter", uniqueConstraints = @UniqueConstraint(columnNames = {"first_name", "last_name"}))
public class Reporter extends UserInfo {

    @Id
    @Column(name = "user_id")
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "reporter_problem_area",
            joinColumns = @JoinColumn(name = "reporter_id"),
            inverseJoinColumns = @JoinColumn(name = "problem_are_id"))
    private Set<ProblemArea> reporterProblemAreas = new HashSet<>();
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "reporter_departmen",
            joinColumns = @JoinColumn(name = "reporter_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Set<Department> reporterDepartments = new HashSet<>();

}
