package com.example.advweek4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advweek4.model.Student

class ListViewModel:ViewModel() {
    val studentsLD = MutableLiveData<List<Student>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh(){
        val student1 = Student("05-9353982", "Ronalda", "1992/05/04", "863-646-7915", "http://dummyimage.com/100x75.jpg/dddddd/000000")
        val student2 = Student("92-3192498", "Sylas", "2014/07/08", "551-454-7701", "http://dummyimage.com/100x75.png/dddddd/000000")
        val student3 = Student("26-6932517", "Linnie", "1999/02/12", "152-348-8733", "http://dummyimage.com/100x75.bmp/dddddd/000000")

        val studentList = arrayListOf<Student>(student1, student2, student3)
        studentsLD.value = studentList
        loadingDoneLD.value = true
        loadingErrorLD.value = false
    }
}