package com.globant.counter.counter

import com.globant.counter.utils.bus.observer.BusObserver

abstract class OnCountButtonPressedBusObserver : BusObserver<OnCountButtonPressedBusObserver.OnCountButtonPressed>
    (OnCountButtonPressed::class.java) {

    class OnCountButtonPressed
}
