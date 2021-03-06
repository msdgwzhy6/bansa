package com.brianegan.bansa

import rx.Observable
import rx.Scheduler
import rx.Subscriber
import rx.Subscription

abstract class Store<S : State, A : Action>(
        private val initialState: S,
        private val initialReducer: (S, A) -> S,
        private val scheduler: Scheduler
) {
    abstract val state: Observable<S>
    abstract fun getState(): S
    abstract var dispatch: (action: A) -> A
    abstract fun subscribe(subscriber: Subscriber<S>): Subscription
}
