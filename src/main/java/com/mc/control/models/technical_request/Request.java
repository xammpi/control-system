package com.mc.control.models.technical_request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "request")
@Getter
@Setter
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_created")
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
    @OneToOne
    private State state;
    @NotBlank(message = "Укажите Фамилию и Имя")
    private String name;
    @NotBlank(message = "Укажите контактный телефон")
    private String phone;
    @NotBlank(message = "Опишите проблему")
    @Column(length = 2000)
    private String message;
    @Transient
    private String dateSort;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Employee employee;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @NotBlank(message = "Выберите магазин из списка")
    private Shop shop;
    @ManyToOne
    private Problem problem;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Department department;
    private String comment;

    public Request(@NotBlank(message = "Выберите магазин из списка") Shop shop) {
        this.shop = shop;
    }

}
