package edu.otaviotarelho.spockdemo.service


import edu.otaviotarelho.spockdemo.data.User
import edu.otaviotarelho.spockdemo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UserServiceTest extends Specification {

    @Autowired
    UserService userService

    UserRepository repository = Mock()

    def "Should calculate user hash based on id, name, email, and external-id"(){
        given:
            def user1 = new User().setId(1).setName("Otavio").setEmail("teste@teste.com").setExternalId("ba2695-867e-4011-8a1d-c0eb83682485").build()

        when:
            def hash = userService.getUserHash(id)

        then:
            hash == expectedHash

        where:
            id | user  | expectedHash
            1  | user1 | "1f7ec2a9123f06118952d1b5d419b026"
    }
}
