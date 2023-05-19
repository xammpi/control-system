package com.mc.control.models.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@NoArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "block_number")
    private int blockNumber;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private City cities;

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", blockNumber=" + blockNumber +
                ", cities=" + cities +
                '}';
    }
}
