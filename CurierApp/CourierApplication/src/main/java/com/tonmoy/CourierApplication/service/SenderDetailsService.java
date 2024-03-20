package com.tonmoy.CourierApplication.service;

import com.tonmoy.CourierApplication.model.SenderDetails;
import com.tonmoy.CourierApplication.repository.SenderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenderDetailsService {


    //Call SenderDetailsRepository Class
    @Autowired
    private SenderDetailsRepository repo;





    //this method for save Sender Details
    public SenderDetails saveSenderDetails(SenderDetails s){

        return repo.save(s);
    }





    //this method for delete a Sender Details
    public void deleteSenderDetails(int id){

        repo.deleteById(id);
    }







    //this method for get all Sender Details list
    public List<SenderDetails> getAllSenderDetails(){

        return repo.findAll();
    }








    //this method for get Sender Details by id
    public SenderDetails findSenderDetailsById(int id){

        return repo.findById(id).get();
    }
}
