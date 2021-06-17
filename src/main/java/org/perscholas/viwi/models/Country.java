package org.perscholas.viwi.models;

import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Country {
    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long countryId;

    @Column(name = "country_name")
    @NonNull
    private String countryName;
}
