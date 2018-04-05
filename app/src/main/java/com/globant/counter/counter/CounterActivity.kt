package com.globant.counter.counter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.globant.counter.R
import com.globant.counter.utils.bus.RxBus


class CounterActivity : AppCompatActivity() {

    private var presenter: CountPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = CountPresenter(CountModel(), CountView(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.clear(this)
    }

}
