package com.globant.counter.counter

import com.globant.counter.base.presenter.BasePresenter
import com.globant.counter.domain.interactors.FetchCounterValue
import com.globant.counter.domain.interactors.IncrementCounter
import com.globant.counter.domain.interactors.ResetCounter

class CountPresenter(
        rxBusKey: Any,
        fetchCounterValue: FetchCounterValue,
        incrementCounter: IncrementCounter,
        resetCounter: ResetCounter,
        view: CountView
) : BasePresenter(rxBusKey) {
    init {
        subscribe(CountView.Events.OnCountButtonPressed::class.java) {
            incrementCounter.execute()
            view.setCount(fetchCounterValue.execute().toString())
        }

        subscribe(CountView.Events.OnResetButtonPressed::class.java) {
            resetCounter.execute()
            view.setCount(fetchCounterValue.execute().toString())
        }
    }
}
