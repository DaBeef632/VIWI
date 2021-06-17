package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Region")
@Table(name = "region")
public class Region {

    @Id
    @Column(name = "region_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long regionId;

    @Column(name = "region_name")
    @NonNull
    private String regionName;

    @ManyToOne
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "country_id",
            foreignKey = @ForeignKey(
                    name = "country_id_fk"
            )
    )
    private Country country;

    @OneToMany(
            mappedBy = "region",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Winery> wineries = new ArrayList<>();

}
