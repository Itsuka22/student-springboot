package com.handoyo.Student.controller

import com.handoyo.Student.BaseRespone
import com.handoyo.Student.model.Student
import com.handoyo.Student.service.StudentService
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("v1/product")
class StudentController {
    @Autowired
    private lateinit var studentService: StudentService

    @GetMapping("/{name}")
    fun getUser(@PathVariable(value = "name") userName: String): BaseRespone<Student> {
        return BaseRespone(
            status = true,
            messages = "Success",
            data = studentService.getUserByName(userName)
        )
    }

    @GetMapping
    fun getUsers(): BaseRespone<List<Student>> {
        return BaseRespone(
            status = true,
            messages = "Success",
            data = studentService.getUsers()
        )
    }

    @PostMapping
    fun addUser(
        @RequestBody user: Student
    ): BaseRespone<List<Student>> {
        return BaseRespone(
            status = true,
            messages = "Success",
            data = studentService.addUser(user)
        )
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable(value = "id") userName: String) :BaseRespone<DeleteResult>{
        return BaseRespone(
            status = true,
            messages = "Success",
            data = studentService.deleteStudent(userName)
        )
    }

    @RequestMapping(method = [RequestMethod.PUT], value = ["/update/{id}"])
    fun updateProduct(@PathVariable(value = "id") userName: String,
                      @RequestBody user: Student) :BaseRespone<UpdateResult>{
        val update: String = user.student
        println("$update")
        return BaseRespone(
            status = true,
            messages = "Success",
            data = studentService.updateStudent(userName,update)
        )
    }

}