package com.globant.counter

import com.globant.counter.counter.CountPresenter
import com.globant.counter.counter.CountView
import com.globant.counter.counter.Events
import com.globant.counter.domain.interactors.FetchCounterValue
import com.globant.counter.domain.interactors.IncrementCounter
import com.globant.counter.domain.interactors.ResetCounter
import com.globant.counter.utils.bus.RxBus
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.`when` as whenever

class MainPresenterTest {

    private lateinit var presenter: CountPresenter

    @Mock
    lateinit var view: CountView

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        presenter = CountPresenter(
                MainPresenterTest::class.java,
                FetchCounterValue(), // These would be also mocked, but it's out of scope for MVP example
                IncrementCounter(),
                ResetCounter(),
                view
        )

        ResetCounter().execute()
    }

    @After
    fun tearDown() {
        presenter.dispose()
    }

    @Test
    fun isShouldIncCountByOne() {
        RxBus.post(Events.OnCountButtonPressed)

        val count = "1"
        verify(view).setCount(count)
    }

    @Test
    fun isShouldResetCount() {
        RxBus.post(Events.OnCountButtonPressed)
        RxBus.post(Events.OnCountButtonPressed)
        RxBus.post(Events.OnCountButtonPressed)

        verify(view).setCount("3")

        RxBus.post(Events.OnResetButtonPressed)

        verify(view).setCount("0")
    }
}
