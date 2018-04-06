package com.globant.counter.domain.interfaces

// Visible only in the domain, presentation should use this class indirectly, via interactors
internal object Counter {
    var count: Int = 0
}
