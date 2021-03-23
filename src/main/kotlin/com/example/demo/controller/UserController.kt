package com.example.demo.controller

import org.springframework.web.bind.annotation.RestController
import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class UserController{
    @GetMapping("/users")
    fun getUsers(): List<User> = UserRepository.findAll()

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable(value = "id") id: Long): ResponseEntity<User>{
        return UserRepository.findById(id).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/users")
    fun createUser(@Valid @RequestBody user: User): User =
        UserRepository.save(user)

//    @PutMapping
//    fun {
//
//    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable(value = "id") id: Long): ResponseEntity<Void>{
        return UserRepository.findById(id).map { user ->
            UserRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}