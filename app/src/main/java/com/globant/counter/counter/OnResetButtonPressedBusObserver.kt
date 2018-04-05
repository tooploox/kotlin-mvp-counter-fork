package com.globant.counter.counter

import com.globant.counter.utils.bus.observer.BusObserver

abstract class OnResetButtonPressedBusObserver : BusObserver<OnResetButtonPressedBusObserver.OnResetButtonPressed>
    (OnResetButtonPressed::class.java) {

    class OnResetButtonPressed
}
