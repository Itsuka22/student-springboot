package com.handoyo.Student.model

import java.util.*
data class Student (
    var id: String = UUID.randomUUID().toString(),
    var student: String
    )