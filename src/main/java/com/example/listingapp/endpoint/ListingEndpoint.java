package com.example.listingapp.endpoint;

import com.example.listingapp.model.Listing;
import com.example.listingapp.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ListingEndpoint {


    private final ListingService listingService;

    @GetMapping("/listings")
    public List<Listing> listings(){
        return listingService.listingsAll();
    }

    //@GetMapping("/listings/{email}")
    //public User  listingsByUser(@PathVariable ("email") String email) {
    @RequestMapping(value = "/listings/{email}", params = "email")
    public List<Listing>  listingsByUser(@RequestParam String email) {
       return listingService.allListingByUserByEmail(email);
    }



//    @GetMapping("/listings/{id}, method = RequestMethod.GET")
    @RequestMapping(value = "/listings/{id}", params = "id")
    public List<Listing> listingsByCategory(@RequestParam int id){
        return listingService.allListingByCategoryById(id);
    }



    @PostMapping("/listings")
    public Listing listing (@RequestBody Listing listing){
        return listingService.addListing(listing);
    }

    @PutMapping("/listings/{id}")
    private ResponseEntity<Listing> listingUpdateById(@PathVariable("id") int id, @RequestBody Listing listing){
      return listingService.updateListing(id, listing);
    }

    @DeleteMapping("/listings/{id}")
    private ResponseEntity<Listing> deleteById(@PathVariable ("id") int id){
        return listingService.deleteListing(id);
    }


}
