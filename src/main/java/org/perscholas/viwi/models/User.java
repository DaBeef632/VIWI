package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "User")
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
    private String name;
    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name ="dob")
    @NonNull
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
