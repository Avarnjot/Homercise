package com.example.homercise_demo

data class UserModel(var firstName: String ?= null,
                     var gender: String ?= null,
                     var age: Int?= null,
                     val height: Double? = null,
                     val weight: Double? = null)
