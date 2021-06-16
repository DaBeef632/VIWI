package org.perscholas.viwi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name= "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public User(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
