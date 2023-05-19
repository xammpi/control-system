package com.mc.control.models.common;

import com.mc.control.models.technical_request.TechnicalRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
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
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private User user;
    @OneToMany(mappedBy = "problemArea",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<TechnicalRequest> technicalRequests;
    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Address address;

}
