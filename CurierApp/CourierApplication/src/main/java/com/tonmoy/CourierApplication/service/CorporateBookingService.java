package com.tonmoy.CourierApplication.service;

import com.tonmoy.CourierApplication.model.CorporateBooking;
import com.tonmoy.CourierApplication.repository.CorporateBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporateBookingService {



    //call CorporateBookingRepository Class
    @Autowired
    CorporateBookingRepository repo;



    public void saveCb(CorporateBooking cb){
        repo.save(cb);
    }



    public void deleteCB(int ccId){
        repo.deleteById(ccId);
    }




    public List<CorporateBooking> getAllCB(){
        return repo.findAll();
    }




    public CorporateBooking findCBById(int cbId){
        return repo.findById(cbId).get();
    }



}