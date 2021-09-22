package com.example.listingapp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="listing")

public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
   private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;



}
