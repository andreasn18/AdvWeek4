package com.example.advweek4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advweek4.R
import com.example.advweek4.databinding.FragmentStudentDetailBinding
import com.example.advweek4.model.Student
import com.example.advweek4.util.loadImage
import com.example.advweek4.viewmodel.DetailViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_detail.view.*
import java.util.concurrent.TimeUnit


class StudentDetailFragment : Fragment(),SaveChangesClickListener {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding: FragmentStudentDetailBinding
//    private var student: Student = Student("", "", "", "", "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(
            inflater,
            R.layout.fragment_student_detail,
            container,
            false
        )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            viewModel.refresh(id)
            dataBinding.listener = this
            observeViewModel()
        }
    }

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
            Log.d("checkdata", dataBinding.student.toString())
//            student = it
//            imageView2.loadImage(student.photoUrl, progressBar2)
//            txtID.setText(student.id)
//            txtName.setText(student.name)
//            txtBOD.setText(student.bod)
//            txtPhone.setText(student.phone)
//
//            var student = it
//            btnNotif.setOnClickListener {
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        MainActivity.showNotifications(
//                            student.name.toString(),
//                            "A new notification created",
//                            R.drawable.ic_baseline_supervised_user_circle_24
//                        )
//                    }
//            }
        })
    }

    override fun onSaveChangesClick(v: View, obj: Student) {
        TODO("Not yet implemented")
    }
}