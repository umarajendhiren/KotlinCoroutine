package com.androidapps.kotlincoroutine

import kotlinx.coroutines.*

suspend fun main() {
/*Scope provide lifecycle methods for coroutine which allow us to start and stop the coroutine for our convenient.
* ex :we can start coroutine in onStart() of activity and stop coroutine in onStop()
*
* we can start coroutine in three ways :
* GlobalScope.launch{}
* runBlocking{}
* coroutineScope.launch{}
*
* if i start coroutine using GlobalScope.launch{},scope of coroutine is the lifecycle of entire application
* it launches top level coroutine
* rarely used launch method
*
* coroutineScope.launch{} ,we can start new scope ,does not complete until all children coroutine complete
* runBlocking{},creates a scope and run coroutine in blocking way.*/


    /*coroutine scope is an interface  provides the scope to the coroutine
    * using this scope we can check track of coroutine work
    * also it provides function to cancel coroutine and handle error or exception*/


    println("program execution will now block")
    runBlocking {
        launch {
            delay(1000L)
            println("Task from runBlocking")
        }
    }


    GlobalScope.launch {
        delay(500L)
        println("Task from GlobalScope")

    }

    coroutineScope {

    }
    coroutineScope {
        launch {
            delay(1500L)
            println("Task from coroutineScope")
        }
    }
    println("Program execution will continue")

}