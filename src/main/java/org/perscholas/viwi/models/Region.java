package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Region")
@Table
public class Region {

    @Id
    @Column(name = "region_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long regionId;

    @Column(name = "region_name")
    @NonNull
    private String regionName;

    @Column(name = "country_id")
    @NonNull
    private long countryId;
}
