package com.example.advweek4.view

import android.view.View
import com.example.advweek4.model.Student

interface ButtonDetailClickListener{
    fun onButtonDetailClick(v:View)
}
interface SaveChangesClickListener{
    fun onSaveChangesClick(v:View, obj:Student)
}