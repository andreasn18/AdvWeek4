package com.example.advweek4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advweek4.model.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailViewModel(application: Application):AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()
    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(id: String){
//        val student1 = Student("05-9353982", "Ronalda", "1992/05/04", "863-646-7915", "http://dummyimage.com/100x75.jpg/dddddd/000000")
//        studentLD.value = student1

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php?id=" + id
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                    response ->
                val sType = object : TypeToken<Student>() { }.type
                val result = Gson().fromJson<Student>(response, sType)
                studentLD.value = result
                Log.d("showvoley", response.toString())
            },
            {
                Log.d("showvoley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}