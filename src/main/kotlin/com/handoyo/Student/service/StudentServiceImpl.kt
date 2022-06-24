package com.handoyo.Student.service

import com.handoyo.Student.model.Student
import com.handoyo.Student.repository.StudentRepository
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl : StudentService {

    @Autowired
    private lateinit var studentRepository: StudentRepository

    override fun getUserByName(name: String): Student? {
        return studentRepository.getUserByName(name)
    }

    override fun getUsers(): List<Student> {
        return studentRepository.getUsers()
    }

    override fun addUser(user: Student): List<Student> {
        return studentRepository.addUser(user.student)
    }

    override fun getIds(): List<String> {
        return studentRepository.getUsers().map { it.id }
    }

    override fun deleteStudent(name: String): DeleteResult {
        return studentRepository.deleteStudentbyName(name)
    }

    override fun updateStudent(user: String, update: String): UpdateResult {
        return studentRepository.updateStudentbyName(user,update)
    }

}