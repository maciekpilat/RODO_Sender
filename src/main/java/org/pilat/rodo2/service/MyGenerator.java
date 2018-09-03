/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pilat.rodo2.service;

import java.io.Serializable;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author Pilat
 */
public class MyGenerator implements IdentifierGenerator {

    public static final String generatorName = "myGenerator";

    // metoda generuje pseudo-losowe id by zapobiec przypadkowego zgadnięciu go przez osoby niepowołane.
    // znajomość id mogłaby pozwolić na generowanie lsowoych wywołać do api przyjmującego akceptacje / odmowy
    // +873 jest przypadkowym numerem, który zapobiega wygenerowaniu id o numerze np.: 1. 
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        return UUID.randomUUID().toString().replace("-", "");
    }
}