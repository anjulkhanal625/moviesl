package com.anjul.exercise.kittipay.rest


open class BaseResponse<T>(
    var status: Int,
    var message: String,
    var data: T,
) {
    fun isSuccessful(): Boolean {
        return status == 200
    }


    fun isUserExists(userExists: Boolean): Boolean {
        if (status == 409) return userExists
        return false
    }

}
