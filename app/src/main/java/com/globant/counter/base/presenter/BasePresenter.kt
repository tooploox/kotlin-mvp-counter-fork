package com.globant.counter.base.presenter

import com.globant.counter.utils.bus.RxBus

abstract class BasePresenter(
        private val rxBusKey: Any
) {

    fun <T> subscribe(clazz: Class<T>, onValue: (T) -> Unit) {
        RxBus.subscribe(rxBusKey, clazz, onValue)
    }

    fun dispose() {
        RxBus.clear(rxBusKey)
    }
}
