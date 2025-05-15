package coroutine_context

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class AccessingContextInASuspendingFunction {
    @OptIn(DelicateCoroutinesApi::class)
    suspend fun printName() {
        println(coroutineContext[CoroutineName]?.name)
    }

    suspend fun main () = withContext(CoroutineName("Outer")) {
        printName()
        launch(CoroutineName("Inner")) {
            printName()
        }
        delay(10)
        printName()
    }
}

fun main() = runBlocking {
    AccessingContextInASuspendingFunction().main()
}