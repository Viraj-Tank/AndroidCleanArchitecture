package com.novuspax.androidcleanarchitecture.utils

object DSL {

    fun lambdaWithReceiver(action: (StringBuilder).() -> Unit) {
        val builder = StringBuilder()
        action(builder)
    }

    fun lambdaWithCallBack(action: (StringBuilder) -> Unit) {
        val builder = StringBuilder()
        action(builder)
    }

    fun lambdaWithCallBackWithNoBody(action: (StringBuilder) -> Unit) {

    }
}

