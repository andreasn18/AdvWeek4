package com.example.advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advweek4.model.Student

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun refresh(){
        val student1 = Student("05-9353982", "Ronalda", "1992/05/04", "863-646-7915", "http://dummyimage.com/100x75.jpg/dddddd/000000")
        studentLD.value = student1
    }
}