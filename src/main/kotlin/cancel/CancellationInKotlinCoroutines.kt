package cancel

import kotlinx.coroutines.*
import java.util.concurrent.CancellationException

class CancellationInKotlinCoroutines {

    suspend fun `잡이 취소되면 다시 던지는 것이 좋다`(): Unit = coroutineScope {
        val job = Job()
        launch(job) {
            try {
                repeat(1_000) {
                    i ->
                    delay(200)
                    println("Thread Name : ${Thread.currentThread()} Printing $i")
                }
            } catch (e: CancellationException){
                println("Thread Name : ${Thread.currentThread()} Error : ${e.message}")
                throw e
            }
        }
        delay(1_100)
        job.cancelAndJoin()
        println("Thread Name : ${Thread.currentThread()} Cancelled successfully")
        delay(1_000)
    }
}

fun main() = runBlocking {
    CancellationInKotlinCoroutines().`잡이 취소되면 다시 던지는 것이 좋다`()
}