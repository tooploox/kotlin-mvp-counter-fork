package com.globant.counter.mvp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.globant.counter.base.presenter.BasePresenter

abstract class BaseActivity<out P : BasePresenter> : AppCompatActivity() {

    private lateinit var presenter: P

    abstract fun createPresenter(): P

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        presenter = createPresenter()
    }

    override fun onDestroy() {
        presenter.dispose()

        super.onDestroy()
    }
}
