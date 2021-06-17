package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Bottle")
@Table(name = "bottles")
public class Bottle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bottleId")
    private long bottleId;

    @Column(name = "bottle_name")
    @NonNull
    private String bottleName;

    @Column(name = "type_of_wine")
    @NonNull
    private long category_id;

    @Column(name = "label")
    private String label;

    @Column(name = "volume")
    private float volume;

    @Column(name = "producer_id")
    private long producerId;

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
