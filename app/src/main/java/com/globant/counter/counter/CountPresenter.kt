package com.globant.counter.counter

import com.globant.counter.utils.bus.RxBus
import com.globant.counter.utils.bus.observer.BusObserver

class CountPresenter(
        rxBusKey: Class<*>,
        model: CountModel,
        view: CountView
) {
    init {
        RxBus.subscribe(rxBusKey, BusObserver(Events.OnCountButtonPressed::class.java) {
            model.inc()
            view.setCount(model.count.toString())
        })

        RxBus.subscribe(rxBusKey, BusObserver(Events.OnResetButtonPressed::class.java) {
            model.reset()
            view.setCount(model.count.toString())
        })
    }
}
