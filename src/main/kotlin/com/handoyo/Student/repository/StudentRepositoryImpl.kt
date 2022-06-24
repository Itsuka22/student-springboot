package com.handoyo.Student.repository

import com.handoyo.Student.database.DatabaseComponent
import com.handoyo.Student.model.Student
import com.mongodb.client.MongoCollection
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.litote.kmongo.setValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class StudentRepositoryImpl: StudentRepository{

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun userCollection(): MongoCollection<Student> =
        databaseComponent.database.getDatabase("student").getCollection()

    override fun getUserByName(name: String): Student? {
        return userCollection().findOne(Student::student eq name)
    }

    override fun getUsers(): List<Student> {
        return userCollection().find().toList()
    }

    override fun addUser(name: String): List<Student> {
        val newUser = Student(student = name)
        val insert = userCollection().insertOne(newUser)
        return if (insert.wasAcknowledged()) {
            getUsers()
        } else {
            throw IllegalStateException("insert gagal")
        }
    }

    override fun deleteStudentbyName(name: String): DeleteResult {
        return userCollection().deleteOne(Student::id eq name)
    }

    override fun updateStudentbyName(name: String, update: String): UpdateResult {
        return userCollection().updateOne(Student::id eq name, setValue(Student::student, update))
    }


}