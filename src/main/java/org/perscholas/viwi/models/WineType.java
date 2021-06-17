package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Wine_Type")
@Table(name = "wine_types")
public class WineType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wineTypeId")
    private long wineTypeId;

    @Column(name = "type_of_wine_name")
    @NonNull
    private String wineTypeName;
}
