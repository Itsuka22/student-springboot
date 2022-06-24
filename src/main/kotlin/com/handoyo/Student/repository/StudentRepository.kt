package com.handoyo.Student.repository

import com.handoyo.Student.model.Student
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult

interface StudentRepository {
    fun getUserByName(name: String): Student?
    fun getUsers(): List<Student>
    fun addUser(name: String): List<Student>
    fun deleteStudentbyName(name: String): DeleteResult
    fun updateStudentbyName (name: String, update:String ): UpdateResult
}