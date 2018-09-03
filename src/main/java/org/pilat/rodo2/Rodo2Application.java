package org.pilat.rodo2;

import org.pilat.rodo2.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.pilat.rodo2.Repository.UserRepository;

@SpringBootApplication
public class Rodo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Rodo2Application.class, args);

    }
}
