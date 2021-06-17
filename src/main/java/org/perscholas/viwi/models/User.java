package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "user")
@Table( name = "user",
        uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private long userId;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name ="dob")
    @NonNull
    private LocalDate dob;
    @Transient
    private Integer age;

    public User(String firstName, String lastName, String email, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;

    }

    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
