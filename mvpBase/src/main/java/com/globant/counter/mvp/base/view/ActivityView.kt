package com.globant.counter.base.view

import android.app.Activity
import android.app.FragmentManager
import android.content.Context
import com.globant.counter.bus.RxBus

abstract class ActivityView(protected val activity: Activity) {

    protected val context: Context
        get() = activity

    protected val fragmentManager: FragmentManager
        get() = this.activity.fragmentManager

    protected fun postEvent(event: Any) {
        RxBus.post(event)
    }
}
