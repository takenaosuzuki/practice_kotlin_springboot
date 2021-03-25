package com.example.demo.controller

import org.springframework.web.bind.annotation.RestController
import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class UserController{

    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/users")
    fun getUsers(): List<User> = userRepository.findAll()

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable(value = "id") id: Long): ResponseEntity<User>{
        return userRepository.findById(id).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/users")
    fun createUser(@Valid @RequestBody user: User): User =
        userRepository.save(user)

//    @PutMapping
//    fun {
//
//    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable(value = "id") id: Long): ResponseEntity<Void>{
        return userRepository.findById(id).map { user ->
            userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}