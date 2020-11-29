package edu.otaviotarelho.spockdemo.data;

import lombok.*;

import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    private Long id;

    private String name;

    private String externalId;

    private String email;

    private String password;

}
