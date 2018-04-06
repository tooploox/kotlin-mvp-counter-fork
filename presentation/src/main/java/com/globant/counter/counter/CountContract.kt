package com.globant.counter.counter

interface CountView {
    fun setCount(count: String)

    class Events {
        object OnResetButtonPressed

        object OnCountButtonPressed
    }
}
