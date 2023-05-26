package com.mc.control.models.common;

import com.mc.control.models.technical_request.TechnicalRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "problem",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@NoArgsConstructor
@Getter
@Setter
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Department department;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "problem",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<TechnicalRequest> technicalRequest;

}
