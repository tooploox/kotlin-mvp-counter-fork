package com.globant.counter.bus.observer

import io.reactivex.functions.Consumer

class BusObserver<in T>(
        private val clazz: Class<T>,
        private val onEvent: (T) -> Unit
) : Consumer<Any> {

    override fun accept(value: Any) {
        if (value.javaClass == clazz) {
            @Suppress("UNCHECKED_CAST")
            onEvent(value as T)
        }
    }
}
