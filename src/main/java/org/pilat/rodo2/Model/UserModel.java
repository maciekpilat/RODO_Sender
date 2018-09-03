/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.rodo2.Model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.pilat.rodo2.service.MyGenerator;


/**
 *
 * @author Pilat
 */
@Table
@Entity
public class UserModel {

@GeneratedValue(generator = MyGenerator.generatorName)
@GenericGenerator(name = MyGenerator.generatorName, strategy = "org.pilat.rodo2.service.MyGenerator")
@Id
    private String userId;
    private String userEmail;
    private boolean userAccept;
    private Date acceptDate;

    public UserModel() {
    }

    public UserModel(String userEmail, boolean userAccept, Date acceptDate) {
        this.userEmail = userEmail;
        this.userAccept = userAccept;
        this.acceptDate = acceptDate;
    }
    
    

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the userAccept
     */
    public boolean isUserAccept() {
        return userAccept;
    }

    /**
     * @param userAccept the userAccept to set
     */
    public void setUserAccept(boolean userAccept) {
        this.userAccept = userAccept;
    }

    /**
     * @return the acceptDate
     */
    public Date getAcceptDate() {
        return acceptDate;
    }

    /**
     * @param acceptDate the acceptDate to set
     */
    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    
}
