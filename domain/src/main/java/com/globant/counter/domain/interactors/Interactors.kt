package com.globant.counter.domain.interactors

import com.globant.counter.domain.interfaces.Counter

// These would be proper use cases, out of scope for MVP example

class FetchCounterValue {

    fun execute(): Int = Counter.count
}

class IncrementCounter {
    fun execute() {
        Counter.count += 1
    }
}

class ResetCounter {
    fun execute() {
        Counter.count = 0
    }
}
