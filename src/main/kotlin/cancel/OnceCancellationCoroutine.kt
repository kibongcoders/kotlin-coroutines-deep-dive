package cancel

import kotlinx.coroutines.*

class OnceCancellationCoroutine {

    suspend fun exampleOne(): Unit = coroutineScope{
        val job = Job()
        launch {
            try {
                delay(2_000)
                println("Job is done")
            } finally {
                println("Finally")
                launch {
                    println("Will not be printed")
                }
                delay(1_000)
                job.cancelAndJoin()
                println("Cancel done")
            }
        }
    }
}

fun main() = runBlocking {
    OnceCancellationCoroutine().exampleOne()
}