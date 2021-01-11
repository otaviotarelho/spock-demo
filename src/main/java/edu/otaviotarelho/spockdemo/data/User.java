package edu.otaviotarelho.spockdemo.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    private Long id;

    private String name;

    private String externalId;

    private String email;

    private String password;

}
