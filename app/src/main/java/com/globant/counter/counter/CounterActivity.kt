package com.globant.counter.counter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.globant.counter.R
import com.globant.counter.domain.interactors.FetchCounterValue
import com.globant.counter.domain.interactors.IncrementCounter
import com.globant.counter.domain.interactors.ResetCounter
import com.globant.counter.utils.bus.RxBus


class CounterActivity : AppCompatActivity() {

    private var presenter: CountPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This would be created via DI, so no need to create all interactors manually
        presenter = CountPresenter(
                CounterActivity::class.java,
                FetchCounterValue(),
                IncrementCounter(),
                ResetCounter(),
                ActivityCountView(this)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.clear(this)
    }

}
