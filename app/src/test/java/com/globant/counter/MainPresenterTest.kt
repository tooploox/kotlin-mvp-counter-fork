package com.globant.counter

import com.globant.counter.counter.CountModel
import com.globant.counter.counter.CountPresenter
import com.globant.counter.counter.CountView
import com.globant.counter.counter.CounterActivity
import com.globant.counter.utils.bus.RxBus
import com.globant.counter.counter.OnCountButtonPressedBusObserver
import com.globant.counter.counter.OnResetButtonPressedBusObserver
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class PresenterTest {

    private var presenter: CountPresenter? = null
    private var model: CountModel? = null
    @Mock
    lateinit var view: CountView
    @Mock
    lateinit var activity: CounterActivity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        model = CountModel()
        // When
        whenever(view.activity).thenReturn(activity)

        presenter = CountPresenter(model!!, view)
    }

    @Test
    fun isShouldIncCountByOne() {
        model!!.reset();
        RxBus.post(OnCountButtonPressedBusObserver.OnCountButtonPressed())

        val count = "1"
        assertEquals(model!!.count, 1)
        verify(view).setCount(count)
    }

    @Test
      fun isShouldResetCount() {
        RxBus.post(OnCountButtonPressedBusObserver.OnCountButtonPressed())
        RxBus.post(OnCountButtonPressedBusObserver.OnCountButtonPressed())
        RxBus.post(OnCountButtonPressedBusObserver.OnCountButtonPressed())
        var count = 3
        assertEquals(model!!.count, count)

        RxBus.post(OnResetButtonPressedBusObserver.OnResetButtonPressed())
        count = 0
        assertEquals(model!!.count, count)
        val invocations = 4
        verify(view, times(invocations)).setCount(anyString());
    }
}
