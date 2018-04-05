package com.globant.counter.counter

import com.globant.counter.domain.interactors.FetchCounterValue
import com.globant.counter.domain.interactors.IncrementCounter
import com.globant.counter.domain.interactors.ResetCounter
import com.globant.counter.utils.bus.RxBus
import com.globant.counter.utils.bus.observer.BusObserver

class CountPresenter(
        rxBusKey: Class<*>,
        fetchCounterValue: FetchCounterValue,
        incrementCounter: IncrementCounter,
        resetCounter: ResetCounter,
        view: CountView
) {
    init {
        RxBus.subscribe(rxBusKey, BusObserver(Events.OnCountButtonPressed::class.java) {
            incrementCounter.execute()
            view.setCount(fetchCounterValue.execute().toString())
        })

        RxBus.subscribe(rxBusKey, BusObserver(Events.OnResetButtonPressed::class.java) {
            resetCounter.execute()
            view.setCount(fetchCounterValue.execute().toString())
        })
    }
}
