package edu.otaviotarelho.spockdemo.repository;

import edu.otaviotarelho.spockdemo.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
