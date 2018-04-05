package com.globant.counter.counter

import com.globant.counter.utils.bus.RxBus

class CountPresenter(model: CountModel, view: CountView) {

    init {

        val activity = view.activity
        if (activity != null) {

            RxBus.subscribe(activity, object : OnCountButtonPressedBusObserver() {
                override fun onEvent(value: OnCountButtonPressedBusObserver.OnCountButtonPressed) {
                    model.inc()
                    view.setCount(model.count.toString())
                }
            })

            RxBus.subscribe(activity, object : OnResetButtonPressedBusObserver() {
                override fun onEvent(value: OnResetButtonPressedBusObserver.OnResetButtonPressed) {
                    model.reset()
                    view.setCount(model.count.toString())
                }
            })
        }

    }
}
