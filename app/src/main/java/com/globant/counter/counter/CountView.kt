package com.globant.counter.counter


import android.app.Activity
import com.globant.counter.base.view.ActivityView
import com.globant.counter.utils.bus.RxBus
import kotlinx.android.synthetic.main.activity_main.*


class CountView(activity: Activity) : ActivityView(activity) {

    init {
        activity.count_button.setOnClickListener {
            RxBus.post(OnCountButtonPressedBusObserver.OnCountButtonPressed())
        }

        activity.reset_button.setOnClickListener {
            RxBus.post(OnResetButtonPressedBusObserver.OnResetButtonPressed())
        }
    }

    fun setCount(count: String) {
        activity!!.count_label.text = count
    }
}
