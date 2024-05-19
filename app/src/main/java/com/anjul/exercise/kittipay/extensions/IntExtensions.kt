package com.anjul.exercise.kittipay.extensions

// Extension function to convert minutes to a formatted string of hours and minutes
fun Int.toHoursAndMinutesString(): String {
    if (this == 0) return ""
    val hours = this / 60
    val minutes = this % 60
    return "${hours}h ${minutes}m"
}