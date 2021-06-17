package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Country")
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long countryId;

    @Column(name = "country_name")
    @NonNull
    private String countryName;

    @OneToMany(
            mappedBy = "country",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Region> regions = new ArrayList<>();
}
