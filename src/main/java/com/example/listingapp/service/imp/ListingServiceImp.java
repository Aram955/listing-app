package com.example.listingapp.service.imp;

import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
import com.example.listingapp.repository.ListingRepository;
import com.example.listingapp.repository.UserRepository;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListingServiceImp implements ListingService {

    private final ListingRepository listingRepository;
    private final UserRepository userRepository;

    @Override
    public List<Listing> listingsAll() {
        return listingRepository.findAll();
    }

    @Override
    public List<Listing> allListingByUserByEmail(String email) {
        Optional<User> userByMail= userRepository.findUserByEmail(email);
        if (!userByMail.isEmpty()){
            return listingRepository.findListingByUser(userByMail.get());
        }
        return null;
    }

    @Override
    public List<Listing> allListingByCategoryById(int id) {
        return listingRepository.findListingByCategory_Id(id);
    }

    @Override
    public Listing addListing(Listing listing) {
        return listingRepository.save(listing);
    }

    @Override
    public ResponseEntity<Listing> updateListing(int id, Listing listing) {
        Optional<Listing> listingByUpdate = listingRepository.findById(id);
        if (listingByUpdate.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Listing listingDB = listingByUpdate.get();
        listingDB.setTitle(listing.getTitle());
        listingDB.setDescription(listing.getDescription());
        listingDB.setPrice(listing.getPrice());
        listingDB.setCategory(listing.getCategory());
        listingDB.setUser(listing.getUser());
        return ResponseEntity.ok().body(listingRepository.save(listingDB));
    }

    @Override
    public ResponseEntity<Listing> deleteListing(int id) {
        Optional<Listing> listingById = listingRepository.findById(id);
        if (listingById.isPresent()){
            return  ResponseEntity.notFound().build();
        }
        listingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
