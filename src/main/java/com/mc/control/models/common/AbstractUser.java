package com.mc.control.models.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
public class AbstractUser {

    @Column(name = "first_name",
            nullable = false)
    private String firstName;
    @Column(name = "last_name",
            nullable = false)
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "active",
            nullable = false)
    private boolean active;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    public AbstractUser() {
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                ", address=" + address +
                '}';
    }

}
