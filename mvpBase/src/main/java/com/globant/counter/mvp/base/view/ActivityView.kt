package com.globant.counter.base.view

import android.app.Activity
import android.app.FragmentManager
import android.content.Context
import com.globant.counter.bus.RxBus
import java.lang.ref.WeakReference

abstract class ActivityView(activity: Activity) {
    private val activityRef: WeakReference<Activity> = WeakReference(activity)

    protected val activity: Activity?
        get() = activityRef.get()

    protected val context: Context?
        get() = activity

    protected val fragmentManager: FragmentManager?
        get() {
            val activity = activity
            return activity?.fragmentManager
        }

    protected fun postEvent(event: Any) {
        RxBus.post(event)
    }
}
