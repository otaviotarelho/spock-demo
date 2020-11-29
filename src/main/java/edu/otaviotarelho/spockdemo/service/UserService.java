package edu.otaviotarelho.spockdemo.service;

import edu.otaviotarelho.spockdemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    public String getUserHash(Long id){

        return null;
    }

}
