package com.careem.sharedlib

import com.careem.sharedlib.MainScope
import kotlinx.coroutines.*
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import kotlin.coroutines.CoroutineContext

actual fun platformName(): String {
    return "iOS"
}

private class MainDispatcher: CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatch_get_main_queue()) { block.run() }
    }
}

internal class MainScope: CoroutineScope {
    private  val dispatcher = MainDispatcher()
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = dispatcher + job
}

fun showHelloCoroutine() {
    MainScope().launch {
        helloCoroutine()
    }
}
