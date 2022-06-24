package com.handoyo.Student.service

import com.handoyo.Student.model.Student
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult

interface StudentService {
    fun getUserByName(name: String): Student?
    fun getUsers(): List<Student>
    fun addUser(user: Student): List<Student>
    fun getIds(): List<String>
    fun deleteStudent(name:String): DeleteResult
    fun updateStudent(user:String,update:String): UpdateResult


}