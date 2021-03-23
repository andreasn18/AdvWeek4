package com.example.advweek4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.advweek4.R
import com.example.advweek4.util.createNotificationChannel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

        init {
            instance = this
        }
    companion object {
        private var instance:MainActivity ?= null
        fun showNotifications(title: String, content:String, icon:Int){
            val channelID = "${instance?.packageName}-${instance?.getString(R.string.app_name)}"
            val builder = NotificationCompat.Builder(instance!!.applicationContext, channelID)
                .apply {
                    setSmallIcon(icon)
                    setContentTitle(title)
                    setContentText(content)
                    setStyle(NotificationCompat.BigTextStyle())
                    priority = NotificationCompat.PRIORITY_DEFAULT
                    setAutoCancel(true)
                }
            val notif = NotificationManagerCompat.from(instance!!.applicationContext)
            notif.notify(1001, builder.build())
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            getString(R.string.app_name), "App Channel")

//        var observable = Observable.just("hellow", "world", "!!")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                {Log.d("Messages", "data captured: ${it}")},
//                {Log.d("Messages", "error: ${it.message.toString()}")},
//                {Log.d("Messages", "Complete")}
//            )
//        val observer = object: Observer<String> {
//            override fun onSubscribe(d: Disposable?) {
//                Log.d("Messages", "Start subcribe")
//            }
//
//            override fun onNext(t: String?) {
//                Log.d("Messages", "data captured: ${t.toString()}")
//            }
//
//            override fun onError(e: Throwable?) {
//                Log.d("Messages", "error: ${e!!.message.toString()}")
//            }
//
//            override fun onComplete() {
//                Log.d("Messages", "Complete")
//            }
//        }
//        observable
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(observer)
    }
}