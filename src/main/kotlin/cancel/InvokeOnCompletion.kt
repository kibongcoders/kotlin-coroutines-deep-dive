package cancel

import kotlinx.coroutines.*
import kotlin.random.Random

class InvokeOnCompletion {

    //invokedOnCompletion 메서드는 Job이 Completed나 Cancelled와 같은 마지막 상태에 도달했을 때 호출될 핸들러를 지정
    suspend fun example_one(): Unit = coroutineScope {
        val job = launch {
            delay(1_000)
        }

        job.invokeOnCompletion { _: Throwable? ->
            println("Finished")
        }

        delay(400)
        job.cancelAndJoin()
    }

    /**
     * 호출 되기 전에 완료 됐으면 핸들러를 즉시 호출
     * - onCancelling과 invokeImmediately 파라미터를 이용하면 동작 방식을 변경도 가능
     */
    suspend fun example_two(): Unit = coroutineScope {
        val job = launch {
            delay(Random.nextLong(2_400))
            println("Finished")
        }
        delay(800)
        job.invokeOnCompletion { exception: Throwable? ->
            println("Will always be printed")
            println("The Exception was: $exception")
        }
        delay(800)
        job.cancelAndJoin()
    }
}

fun main() = runBlocking {
    //InvokeOnCompletion().example_one()
    InvokeOnCompletion().example_two()
}