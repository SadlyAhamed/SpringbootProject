package com.tonmoy.CourierApplication.service;


import com.tonmoy.CourierApplication.model.ParcelDetails;
import com.tonmoy.CourierApplication.repository.ParcelDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelDetailsService {


    @Autowired
    private ParcelDetailsRepository repo;




    //this method for save parcel Details
    public ParcelDetails saveParcelDetails(ParcelDetails s){
        return repo.save(s);
    }



    //this method for delete parcel Details
    public void deleteParcelDetails(int id){
        repo.deleteById(id);
    }



    //this method for get all parcel Details
    public List<ParcelDetails> getAllParcelDetails(){
        return repo.findAll();
    }




    //this method for get parcel Details
    public ParcelDetails findParcelDetailsById(int id){
        return repo.findById(id).get();
    }
}
