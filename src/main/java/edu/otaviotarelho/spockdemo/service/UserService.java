package edu.otaviotarelho.spockdemo.service;

import edu.otaviotarelho.spockdemo.data.User;
import edu.otaviotarelho.spockdemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public String getUserHash(User user) throws NoSuchAlgorithmException {
        String toHash = String.format("%s|%s|%s|%s", user.getId(), user.getName(), user.getEmail(), user.getExternalId());
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(toHash.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }

    public User save(User user){
        user.setId(1L);
        return repository.save(user);
    }

    public User getUser(User user) {
        if(user == null) {
            throw new IllegalArgumentException("Mensagem");
        }

        return user;
    }

}
