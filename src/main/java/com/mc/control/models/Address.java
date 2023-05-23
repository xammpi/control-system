package com.mc.control.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(name = "street_name")
    private String streetName;
    @Column
    private String city;
    @Column(name = "block_number")
    private int blockNumber;

}
