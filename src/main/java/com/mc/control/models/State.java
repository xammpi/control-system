package com.mc.control.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "state",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "value"}))
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable = false)
    private Long id;
    @Column(name = "name",
            columnDefinition = "TEXT",
            nullable = false)
    private String name;
    @Column(name = "value",
            nullable = false)
    private int value;

}
