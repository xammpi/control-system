package com.mc.control.models.common;

import com.mc.control.models.technical_request.TechnicalRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "employee",
        uniqueConstraints = @UniqueConstraint(columnNames = {"first_name", "last_name", "phone"}))
@Getter
@Setter
public class Employee extends AbstractUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Position> positions;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Department departments;
    @OneToMany(mappedBy = "employee",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<TechnicalRequest> technicalRequests;

    protected Employee(AbstractUserBuilder<?, ?> b) {
        super(b);
    }

    public void addPositionToEmployee(Position position) {
        if (Objects.isNull(positions)) {
            positions = new ArrayList<>();
        }
        positions.add(position);
    }

    public void addRequestToEmployee(TechnicalRequest technicalRequest) {
        if (Objects.isNull(technicalRequests)) {
            technicalRequests = new ArrayList<>();
        }
        technicalRequests.add(technicalRequest);
    }

}
