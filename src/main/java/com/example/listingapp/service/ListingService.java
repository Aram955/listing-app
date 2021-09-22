package com.example.listingapp.service;

import com.example.listingapp.model.Listing;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ListingService {
    List<Listing> listingsAll();

    List<Listing> allListingByUserByEmail(String email);

    List<Listing> allListingByCategoryById(int id);

    Listing addListing(Listing listing);

    ResponseEntity<Listing> updateListing(int id, Listing listing);

    ResponseEntity<Listing> deleteListing(int id);
}
