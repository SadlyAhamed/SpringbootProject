package com.tonmoy.Curier_app.service;


import com.tonmoy.Curier_app.Model.SenderDetails;
import com.tonmoy.Curier_app.Repository.SenderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenderDetailsService {

    @Autowired
    private SenderDetailsRepository repo;

    //this method for save sednderDetails
    public SenderDetails saveSenderDetails(SenderDetails s) {

        return repo.save(s);
    }

    //this method for delete a sednderDetails
    public void deleteSenderDetails(int id) {

        repo.deleteById(id);
    }

    //this method for get all sednderDetails list
    public List<SenderDetails> getAllSenderDetails() {

        return repo.findAll();
    }

    //this method for get sednderDetails by id
    public SenderDetails findSenderDetailsById(int id) {

        return repo.findById(id).get();
    }
}