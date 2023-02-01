package com.srn.shortlyappchallenge.application.util.event

import androidx.lifecycle.Observer


/**
 * Created by SoheilR .
 */
open interface EventHandler<V> {
    fun onEventUnHandled(`object`: V)
}

class EventObserver<T>(onEventUnhandledContent: EventHandler<T>) :
    Observer<Event<T>?> {
    private val onEventUnhandledContent: EventHandler<T>
    override fun onChanged(event: Event<T>?) {
        if (event != null) {
            event.contentIfNotHandled?.let { onEventUnhandledContent.onEventUnHandled(it) }
        }
    }

    init {
        this.onEventUnhandledContent = onEventUnhandledContent
    }
}
