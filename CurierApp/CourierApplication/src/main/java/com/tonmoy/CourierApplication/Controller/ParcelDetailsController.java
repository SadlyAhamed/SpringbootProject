package com.tonmoy.CourierApplication.Controller;

import com.tonmoy.CourierApplication.model.ParcelDetails;
import com.tonmoy.CourierApplication.model.RecipientDetails;
import com.tonmoy.CourierApplication.model.SenderDetails;
import com.tonmoy.CourierApplication.repository.SenderDetailsRepository;
import com.tonmoy.CourierApplication.service.ParcelDetailsService;
import com.tonmoy.CourierApplication.service.RecipientDetailsService;
import com.tonmoy.CourierApplication.service.SenderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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






    @RequestMapping("/all_parcelDetails/{sender_id}/{recipent_id}/{precel_id}")
    public String allParcel(
            @PathVariable(value = "sender_id") int senderId,
            @PathVariable(value = "recipent_id") int recipentId,
            @PathVariable(value = "precel_id") int precelId,
            Model m){
        senderId=senderId;
        SenderDetails sd = senderDetailsService.findSenderDetailsById(senderId);
        RecipientDetails rd = recipientDetailsService.findRecipientDetailsById(recipentId);
        ParcelDetails pd = parcelDetailsService.findParcelDetailsById(precelId);
        m.addAttribute("sd",sd);
        m.addAttribute("rd",rd);
        m.addAttribute("pd",pd);
        return "all_parcelDetails";
    }






    @RequestMapping("/p_reg_form/{send_id}/{rec_id}")
    public String parcelAddForm(
            @PathVariable(value = "send_id") int senderId,
            @PathVariable(value = "rec_id") int recId,
            Model m){

        ParcelDetails pd = new ParcelDetails();
        pd.setSenderId(senderId);
        pd.setRecipientId(recId);
        m.addAttribute("parcelDetails", pd);
        m.addAttribute("title", "ParcelDetails Registration");
        return "parcel_reg_form";
    }






    @PostMapping(value = "/add_parcel")
    public String addNewParcel(@ModelAttribute("parcelDetails") ParcelDetails s, Model m ){
        ParcelDetails pd = parcelDetailsService.saveParcelDetails(s);



        SenderDetails senderDetails= senderDetailsRepository.findById(pd.getSenderId()).get();


        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(senderDetails.getEmail());
        message.setSubject("Confirm Registration");
        message.setFrom("info@emranhss.com");
        message.setText("Dear "+senderDetails.getSenderName());
        message.setText("To confirm your account, please click here :"
               + ""+s.getParcelTrakingNumber());




        return "redirect:/all_parcelDetails/"+pd.getSenderId()+"/"+pd.getRecipientId()+
                "/"+pd.getId();
    }






    @RequestMapping("/delete_parcel/{id}")
    public String deleteParcel(@PathVariable("id") Integer id){
        parcelDetailsService.deleteParcelDetails(id);
        return "redirect:/all_parcelDetails";
    }






    @PostMapping(value = "/update_parcel")
    public String parcelUpdateForm(@ModelAttribute("parcelDetails") ParcelDetails s, Model m){
        try {
            ParcelDetails pd = parcelDetailsService.findParcelDetailsById(s.getId());

            return "redirect:/all_parcelDetails/"+s.getSenderId()+"/"+s.getRecipientId()+
                    "/"+s.getId();
        }
        catch (Exception e){
            m.addAttribute("parcelDetails", s);
            e.printStackTrace();
        }

        m.addAttribute("parcelDetails", s);
        m.addAttribute("senderId", s.getSenderId());
        m.addAttribute("recpId", s.getRecipientId());
        m.addAttribute("perId", s.getId());

        return "/parcel_reg_form";
    }




}
