package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Winery")
@Table(name = "winery")
public class Winery {
    @Id
    @Column(name = "winery_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Long wineryId;

    private String wineryName;
    private String details;

    @ManyToOne
    @JoinColumn(
            name = "region_id",
            referencedColumnName = "region_id",
            foreignKey = @ForeignKey(
                    name = "region_id_fk"
            )
    )
    private Region region;

    @OneToMany(
            mappedBy = "winery",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Bottle> bottles = new ArrayList<>();


}
