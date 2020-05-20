package com.example.lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    interface GetUserDetail{
        fun showDetails(firstName:String, lastName:String)
    }
    lateinit var getUserDetail : GetUserDetail
    lateinit var firstNameEditText : EditText
    lateinit var lastNameEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val showButton = view.findViewById<Button>(R.id.btnShow)
        firstNameEditText = view.findViewById(R.id.edtUsername)
        lastNameEditText = view.findViewById(R.id.edtLastName)
        showButton.setOnClickListener(View.OnClickListener {
            getUserDetail.showDetails(firstNameEditText.text.toString(),lastNameEditText.text.toString())
        })
        return view
        }
}

