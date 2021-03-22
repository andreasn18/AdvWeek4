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

class ListViewModel(application: Application):AndroidViewModel(application) {
    val studentsLD = MutableLiveData<List<Student>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue:RequestQueue ?= null

    fun refresh(){
//        val student1 = Student("05-9353982", "Ronalda", "1992/05/04", "863-646-7915", "http://dummyimage.com/100x75.jpg/dddddd/000000")
//        val student2 = Student("92-3192498", "Sylas", "2014/07/08", "551-454-7701", "http://dummyimage.com/100x75.png/dddddd/000000")
//        val student3 = Student("26-6932517", "Linnie", "1999/02/12", "152-348-8733", "http://dummyimage.com/100x75.bmp/dddddd/000000")
//
//        val studentList = arrayListOf<Student>(student1, student2, student3)
//        studentsLD.value = studentList
        loadingDoneLD.value = false
        loadingErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://adv.jitusolution.com/student.php"
        val stringRequest = StringRequest(Request.Method.GET, url,
            {
                response ->
                val sType = object : TypeToken<List<Student>>() { }.type
                val result = Gson().fromJson<List<Student>>(response, sType)
                studentsLD.value = result
                loadingDoneLD.value = true
                Log.d("showvoley", response.toString())
            },
            {
                Log.d("showvoley", it.toString())
                loadingErrorLD.value = true
                loadingDoneLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}