/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.rodo2;

/**
 *
 * @author Pilat
 */
public interface EmailSender {
    void sendEmail(String to, String subject, String content);    
}
