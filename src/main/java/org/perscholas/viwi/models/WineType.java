package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Wine_Type")
@Table(name = "winetype")
public class WineType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wine_type_id")
    @NonNull
    private long wineTypeId;

    @Column(name = "type_of_wine_name")
    @NonNull
    private String wineTypeName;

    @OneToMany(
            mappedBy = "winetype",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Bottle> bottles = new ArrayList<>();
}
