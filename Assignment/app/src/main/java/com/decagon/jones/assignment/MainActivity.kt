package com.decagon.jones.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    var disposableIntegers = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val flowableIntegers = Flowable.just(arrayOf(1,10,56,43,10))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { value -> value.forEach {
                //println(it/3)
                Log.i("FlowableIntegers","${it/3}")
            } }

        disposableIntegers.add(flowableIntegers)
    }
}