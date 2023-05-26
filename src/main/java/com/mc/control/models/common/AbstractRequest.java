package com.mc.control.models.common;

import com.mc.control.models.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Calendar;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractRequest {

    @Column(name = "date_created"
            , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreated = Calendar.getInstance().getTime();
    @Column(name = "date_completion")
    @Temporal(TemporalType.DATE)
    private Date dateCompletion;
    @OneToOne(fetch = FetchType.LAZY)
    private State state;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    private Reporter reporter;
    @Column(name = "description",
            length = 2000,
            nullable = false)
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    private ProblemArea problemArea;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    private Problem problem;

}
