package com.handoyo.Student

data class BaseRespone<T>(
    var status: Boolean = false,
    var messages: String = "",
    var data: T? = null
)
