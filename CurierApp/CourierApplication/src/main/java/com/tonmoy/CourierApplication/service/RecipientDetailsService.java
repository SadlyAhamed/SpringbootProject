package com.tonmoy.CourierApplication.service;

import com.tonmoy.CourierApplication.model.RecipientDetails;
import com.tonmoy.CourierApplication.repository.RecipientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipientDetailsService {


    @Autowired
    private RecipientDetailsRepository repo;




    //this method for save receiver Details
    public RecipientDetails saveRecipientDetails(RecipientDetails s) {
        return repo.save(s);
    }




    //this method for delete a receiver Details
    public void deleteRecipientDetails(int id) {
        repo.deleteById(id);
    }





    //this method for get all receiver Details list
    public List<RecipientDetails> getAllRecipientDetails() {
        return repo.findAll();
    }






    //this method for get receiver Details by id
    public RecipientDetails findRecipientDetailsById(int id) {
        return repo.findById(id).get();
    }



}
