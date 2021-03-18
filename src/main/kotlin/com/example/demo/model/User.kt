package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GeneratedType
import javax.persistence.Id
import javax.validation.constaraints.NotBlank

@Entity
data class User (
    @Id @GenaratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @get: NotBlank
    val name: String = "",

    @get: NotBlank
    val email: String = ""
)
