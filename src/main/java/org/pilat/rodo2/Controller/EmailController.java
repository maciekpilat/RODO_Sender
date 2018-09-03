/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.rodo2.Controller;

import org.pilat.rodo2.EmailSender;
import org.pilat.rodo2.Model.UserModel;
import org.pilat.rodo2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author Pilat
 */
@RestController
public class EmailController {

    @Autowired
    UserRepository userRepository;

    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailSender emailSender,
            TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @RequestMapping("/send")
    public String send() {

        for (UserModel u : userRepository.findAll()) {

            if (u.isUserAccept()) {
                break;
            } else {
                Context context = new Context();
                context.setVariable("header", "Mail informacyjny.");
                context.setVariable("title", "Informacja o administracji danymi osobowymi.");
                context.setVariable("description", "Kliknij w link który przeniesie cię do informacji o administratorze danych osobowych.");
                context.setVariable("information", "localhost:8080/information");
                context.setVariable("userId", u.getUserId());
                String body = templateEngine.process("template", context);

                emailSender.sendEmail(u.getUserEmail(), "RODO", body);
            }
        }
        return "Odpaliłem!";
    }
}
