package com.globant.counter.counter

import android.os.Bundle
import com.globant.counter.R
import com.globant.counter.domain.interactors.FetchCounterValue
import com.globant.counter.domain.interactors.IncrementCounter
import com.globant.counter.domain.interactors.ResetCounter
import com.globant.counter.mvp.base.BaseActivity

class CounterActivity : BaseActivity<CountPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // This would be created via DI, so no need to create all interactors manually
    override fun createPresenter(): CountPresenter = CountPresenter(
            CounterActivity::class.java,
            FetchCounterValue(),
            IncrementCounter(),
            ResetCounter(),
            ActivityCountView(this)
    )
}
