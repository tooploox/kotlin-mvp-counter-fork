package com.globant.counter.base.view

import android.app.Activity
import android.app.FragmentManager
import android.content.Context
import com.globant.counter.utils.bus.RxBus

import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {
    private val activityRef: WeakReference<Activity> = WeakReference(activity)

    val activity: Activity?
        get() = activityRef.get()

    val context: Context?
        get() = activity

    val fragmentManager: FragmentManager?
        get() {
            val activity = activity
            return activity?.fragmentManager
        }

    fun postEvent(event: Any) {
        RxBus.post(event)
    }
}
