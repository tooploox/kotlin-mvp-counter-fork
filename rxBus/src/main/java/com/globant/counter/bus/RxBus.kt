package com.globant.counter.bus

import com.globant.counter.bus.observer.BusObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import java.util.HashMap

object RxBus {
    private val disposableMap = HashMap<Any, CompositeDisposable>()
    private val publishSubject = PublishSubject.create<Any>()

    fun post(`object`: Any) {
        publishSubject.onNext(`object`)
    }

    fun <T> subscribe(key: Any, clazz: Class<T>, onValue: (T) -> Unit) {
        val compositeDisposable = disposableMap.getOrPut(key, { CompositeDisposable() })

        compositeDisposable.add(publishSubject.subscribe(BusObserver(clazz, onValue)))
    }

    fun clear(key: Any) {
        val compositeDisposable = disposableMap.remove(key)
        compositeDisposable?.clear()
    }

    fun clearAll() {
        for ((_, value) in disposableMap) {
            value.clear()
        }
        disposableMap.clear()
    }
}
