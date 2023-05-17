package com.mc.control.models.technical_request;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Position> positions;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Department departments;
    @OneToMany(mappedBy = "employee",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Request> requests;

    public void addPositionToEmployee(Position position) {
        if (Objects.isNull(positions)) {
            positions = new ArrayList<>();
        }
        positions.add(position);
    }

    public void addRequestToEmployee(Request request) {
        if (Objects.isNull(requests)) {
            requests = new ArrayList<>();
        }
        requests.add(request);
    }

}
