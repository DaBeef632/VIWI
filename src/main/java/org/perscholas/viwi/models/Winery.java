package org.perscholas.viwi.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Winery")
@Table
public class Winery {
    @Id
    @Column(name = "winery_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Long wineryId;

    private String wineryName;
    private String details;
    private String region_id;
}
