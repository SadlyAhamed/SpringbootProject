package com.tonmoy.Curier_app.Controller;

import com.tonmoy.Curier_app.Model.ParcelDetails;
import com.tonmoy.Curier_app.Model.RecipientDetails;
import com.tonmoy.Curier_app.Model.SenderDetails;
import com.tonmoy.Curier_app.Repository.SenderDetailsRepository;
import com.tonmoy.Curier_app.service.ParcelDetailsService;
import com.tonmoy.Curier_app.service.RecipientDetailsService;
import com.tonmoy.Curier_app.service.SenderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParcelDetailsController {

    @Autowired
    private ParcelDetailsService parcelDetailsService;

    @Autowired
    private SenderDetailsService senderDetailsService;

    @Autowired
    SenderDetailsRepository senderDetailsRepository;

    @Autowired
    private RecipientDetailsService recipientDetailsService;

    public int sId=0;

    @RequestMapping("/all_parcelDetails/{sender_id}/{recipent_id}/{precel_id}")
    public String allParcel(
            @PathVariable(value = "sender_id") int senderId,
            @PathVariable(value = "recipent_id") int recipentId,
            @PathVariable(value = "precel_id") int precelId,
            Model m){
        sId=senderId;
        SenderDetails sd = senderDetailsService.findSenderDetailsById(senderId);
        RecipientDetails rd = recipientDetailsService.findRecipientDetailsById(recipentId);
        ParcelDetails pd = parcelDetailsService.findParcelDetailsById(precelId);
        m.addAttribute("sd",sd);
        m.addAttribute("rd",rd);
        m.addAttribute("pd",pd);
        return "all_parcelDetails";
    }
}
