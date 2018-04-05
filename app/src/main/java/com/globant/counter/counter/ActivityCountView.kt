package com.globant.counter.counter

import android.app.Activity
import com.globant.counter.base.view.ActivityView
import kotlinx.android.synthetic.main.activity_main.*

class ActivityCountView(activity: Activity) : ActivityView(activity), CountView {

    init {
        activity.count_button.setOnClickListener {
            postEvent(Events.OnCountButtonPressed)
        }

        activity.reset_button.setOnClickListener {
            postEvent(Events.OnResetButtonPressed)
        }
    }

    override fun setCount(count: String) {
        activity!!.count_label.text = count
    }
}
