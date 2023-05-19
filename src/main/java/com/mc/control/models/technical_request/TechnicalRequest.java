package com.mc.control.models.technical_request;

import com.mc.control.models.common.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "technical_request")
@Getter
@Setter
@NoArgsConstructor
public class TechnicalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_created"
            , nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreated = Calendar.getInstance().getTime();
    @Column(name = "date_execution")
    @Temporal(TemporalType.DATE)
    private Date execution;
    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Column(name = "date_close")
    @Temporal(TemporalType.DATE)
    private Date dateClose;
    @OneToOne(fetch = FetchType.LAZY)
    private State state;
    @NotBlank(message = "Укажите Фамилию и Имя")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private User user;
    @NotBlank(message = "Опишите проблему")
    @Column(name = "description",
            length = 2000,
            nullable = false)
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Employee employee;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @NotBlank(message = "Выберите магазин из списка")
    private ProblemArea problemArea;
    @ManyToOne
    private Problem problem;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Department department;
    @Column(name = "comment",
            length = 2000)
    private String comment;

}
