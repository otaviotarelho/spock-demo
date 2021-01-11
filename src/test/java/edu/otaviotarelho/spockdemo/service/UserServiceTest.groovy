package edu.otaviotarelho.spockdemo.service

import edu.otaviotarelho.spockdemo.SpockDemoApplication
import edu.otaviotarelho.spockdemo.data.User
import edu.otaviotarelho.spockdemo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = SpockDemoApplication.class)
class UserServiceTest extends Specification {

    @Autowired
    private UserService userService

    @Autowired
    private UserRepository repository

    def "Should calculate user hash based on #id, #user.name, #user.email, and #user.externalId"() {
        when:
        def hash = userService.getUserHash(user)

        then:
        hash == expectedHash

        where:
        id | user | expectedHash
        1  | User.builder().id(1L).name("Otavio").email("teste@teste.com").externalId("ba2695-867e-4011-8a1d-c0eb83682485").build() | "407b6125f954b3d8f05a121198309a10"
//      2  | User.builder().id(2L).name("Andre").email("teste2@teste.com").externalId("ba2695-867e-4011-8a1d-c0eb83682485").build() | "407b6125f954b3d8f05a121198309a10"
    }

    def "Should save use with hash"() {
        given:
        def user = User.builder().name("Otavio").email("teste@teste.com").externalId("ba2695-867e-4011-8a1d-c0eb83682485").build()

        and:
        repository.save(_ as User) >>> user

        when:
        def userReturnedFromDB = userService.save(user)

        then:
        userReturnedFromDB.id == user.id
    }

    def "Should throw exception using spock"(){
        given:
        def user = null as User

        when:
        userService.getUser(user)

        then:
        IllegalArgumentException ex = thrown()
        ex.message == "Mensagem"
    }

    def "Should not throw exception when getUser"(){
        given:
        def user = User.builder().name("Otavio").email("teste@teste.com").externalId("ba2695-867e-4011-8a1d-c0eb83682485").build()

        when:
        userService.getUser(user)

        then:
        notThrown IllegalArgumentException
    }

}