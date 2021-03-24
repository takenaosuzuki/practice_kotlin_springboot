package com.example.demo.repository

import com.example.demo.model.User
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface UserRepository: JpaRepository<User, Long>