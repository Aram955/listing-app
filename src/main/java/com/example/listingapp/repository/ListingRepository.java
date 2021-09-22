package com.example.listingapp.repository;

import com.example.listingapp.model.Listing;
import com.example.listingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Integer> {


      //List<Listing> listingByUser(String email);
      List<Listing>  findByUserEmail(String email);
    List<Listing> findListingByUser(User user);

      //List<Listing>  ListingByCategory(int id);
        //List<Listing>  findByCategoryOrderById(int id);
      List<Listing>  findListingByCategory_Id(int id);
}
