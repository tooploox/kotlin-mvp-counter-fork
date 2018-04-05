package com.globant.counter.counter

import com.globant.counter.utils.bus.RxBus
import com.globant.counter.utils.bus.observer.BusObserver

class CountPresenter(model: CountModel, view: CountView) {

    init {

        val activity = view.activity
        if (activity != null) {

            RxBus.subscribe(activity, BusObserver(OnCountButtonPressed::class.java) {
                model.inc()
                view.setCount(model.count.toString())
            })

            RxBus.subscribe(activity, BusObserver(OnResetButtonPressed::class.java) {
                model.reset()
                view.setCount(model.count.toString())
            })
        }
    }
}
