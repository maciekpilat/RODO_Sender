/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.rodo2.Controller;

import org.pilat.rodo2.Model.UserModel;
import org.pilat.rodo2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;


/**
 *
 * @author Pilat
 */
@Controller
public class InfoPageController {
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/informacja")
    public String getInfoPage(@RequestParam("userId") String userId, Model model) {
        model.addAttribute("userId", userId);
        return "infoPage";
    }
    
    @GetMapping("/accept")
    public String acceptPage(@RequestParam("userId") String userId) {
        UserModel user = userRepository.getOne(userId);
        user.setUserAccept(true);
        Date date = new Date();
        user.setAcceptDate(date);
        userRepository.save(user);       
        return "acceptPage";
    }
    
    @GetMapping("/decline")
    public String declinePage(@RequestParam("userId") String userId) {
        userRepository.deleteById(userId);
        return "declinePage";
    }
    
}
