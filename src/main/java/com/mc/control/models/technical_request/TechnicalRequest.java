package com.mc.control.models.technical_request;

import com.mc.control.models.Department;
import com.mc.control.models.Employee;
import com.mc.control.models.common.AbstractRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "technical_request")
@Getter
@Setter
@NoArgsConstructor
public class TechnicalRequest extends AbstractRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_execution")
    @Temporal(TemporalType.DATE)
    private Date execution;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    private Employee employee;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    private Department department;
    @Column(name = "comment",
            length = 2000)
    private String comment;

}
