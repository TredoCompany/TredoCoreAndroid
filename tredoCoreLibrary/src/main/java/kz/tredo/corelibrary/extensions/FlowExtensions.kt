package kz.tredo.corelibrary.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun <T> Flow<T>.makeRequest(scope: CoroutineScope, block: (T) -> Unit, error: (Throwable) -> Unit, finish: () -> Unit) {
    scope.launch {
        try {
            collect { result ->
                block(result)
            }
        } catch (exception: Throwable) {
            error(exception)
        } finally {
            finish()
        }
    }
}

fun <T> Flow<T>.makeRequest(scope: CoroutineScope, block: (T) -> Unit, error: (Throwable) -> Unit) {
    scope.launch {
        try {
            collect { result ->
                block(result)
            }
        } catch (exception: Throwable) {
            error(exception)
        }
    }
}