package com.novuspax.androidcleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.novuspax.androidcleanarchitecture.utils.DSL.lambdaWithCallBack
import com.novuspax.androidcleanarchitecture.utils.DSL.lambdaWithCallBackWithNoBody
import com.novuspax.androidcleanarchitecture.utils.DSL.lambdaWithReceiver

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dslInitializations()
        Log.e(TAG, "onCreate: ")

    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ");
    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
    }

    private fun dslInitializations() {
        lambdaWithReceiver(fun(_:StringBuilder) {

        })

        lambdaWithReceiver {
            // this block
            append("asd")
        }

        lambdaWithCallBack {

        }

        lambdaWithCallBackWithNoBody {

        }
    }

}