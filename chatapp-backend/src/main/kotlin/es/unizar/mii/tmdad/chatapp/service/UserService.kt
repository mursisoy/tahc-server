package es.unizar.mii.tmdad.chatapp.service

import org.springframework.stereotype.Service
import es.unizar.mii.tmdad.chatapp.dao.UserEntity
import es.unizar.mii.tmdad.chatapp.exception.UserNotFoundException
import es.unizar.mii.tmdad.chatapp.repository.UserRepository
import java.util.UUID

@Service
class UserService(
    private val userRepository: UserRepository,
//    private val channel: Channel
)  {
    fun register(user: UserEntity): UserEntity {
        // Insert the user
        return userRepository.save(user)
    }

    fun getAllUsers(): List<UserEntity>{
        return  userRepository.findAll()
    }

    fun loadUserByUsername(username: UUID): UserEntity{
        return userRepository.findByUsername(username) ?: throw UserNotFoundException("User nor found")
    }
    fun loadUserByEmail(email: String): UserEntity{
        return userRepository.findByEmail(email) ?: throw UserNotFoundException("User nor found")
    }

}