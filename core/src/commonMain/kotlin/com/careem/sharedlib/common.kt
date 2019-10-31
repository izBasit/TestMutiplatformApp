package com.careem.sharedlib

expect fun platformName(): String

fun createAppScreenMessage(): String {
    return "${platformName()} rocks!!"
}


internal suspend fun helloCoroutine() {
    println("Hello Coroutines!")
}
