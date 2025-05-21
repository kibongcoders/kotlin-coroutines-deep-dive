package cancel

import kotlinx.coroutines.*

class BasicCancel {

    suspend fun `Join and Cancel`(): Unit = coroutineScope {
        val job = launch {
            repeat(1_000) {
                i ->
                delay(200)
                println("Printing $i")
            }
        }

        delay(1100)
        job.cancel()
        job.join()
        println("Cancelled successfully")
    }


    suspend fun `Not Join and Cancel`(): Unit = coroutineScope {
        val job = launch {
            repeat(1_000) {
                    i ->
                delay(100)
                Thread.sleep(100)
                println("Thread Name : ${Thread.currentThread()} Printing $i")
            }
        }

        delay(1000)
        job.cancel()
        println("Thread Name : ${Thread.currentThread()} Cancelled successfully")
    }

    suspend fun `CancelAndJoin Function`(): Unit = coroutineScope {
        val job = launch {
            repeat(1_000) {
                    i ->
                delay(200)
                println("Thread Name : ${Thread.currentThread()} Printing $i")
            }
        }

        delay(1100)
        job.cancelAndJoin()
        println("Thread Name : ${Thread.currentThread()} Cancelled successfully")
    }
}

fun main() = runBlocking {
    //StructuredConcurrency().`Join and Cancel`()
    //StructuredConcurrency().`Not Join and Cancel`()
    BasicCancel().`CancelAndJoin Function`()
}

