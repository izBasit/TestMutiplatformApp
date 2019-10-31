package com.careem.core

expect fun platformName(): String

fun createAppScreenMessage(): String {
    return "${platformName()} rocks!!"
}


internal fun helloCoroutine() {
    println("Hello Coroutines!")
}
