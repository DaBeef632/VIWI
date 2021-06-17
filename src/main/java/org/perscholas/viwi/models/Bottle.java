package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Bottle")
@Table(name = "bottle")
public class Bottle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bottleId")
    private long bottleId;

    @Column(name = "bottle_name")
    @NonNull
    private String bottleName;

    @ManyToOne
    @JoinColumn(
            name = "wine_type_id",
            referencedColumnName = "wine_type_id",
            foreignKey = @ForeignKey(
                    name = "wine_type_id_fk"
            )
    )
    private WineType winetype;

    @Column(name = "label")
    private String label;

    @Column(name = "volume")
    private float volume;

    @ManyToOne
    @JoinColumn(
            name = "winery_id",
            referencedColumnName = "winery_id",
            foreignKey = @ForeignKey(
                    name = "winery_id_fk"
            )
    )
    private Winery winery;

    @Column(name = "year_produced")
    @NonNull
    private int yearProduced;

    @Column(name = "image")
    private int picture;

    @Column(name = "alcohol_percentage")
    @NonNull
    private float alcoholPercentage;

    @Column(name = "current_price")
    @NonNull
    private float currentPrice;
}
