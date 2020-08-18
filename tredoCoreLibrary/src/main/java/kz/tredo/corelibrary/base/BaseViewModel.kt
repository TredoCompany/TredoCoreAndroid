package kz.tredo.corelibrary.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel(
    private val coroutineJob: Job = Job(),
    val scope: CoroutineScope = CoroutineScope(coroutineJob + Dispatchers.IO)
): ViewModel() {

    override fun onCleared() {
        super.onCleared()
        coroutineJob.cancel()
    }
}