package com.example.printrealtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val database = Firebase.database
    private val myRef = database.getReference("할 일")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickAdd(view: View) { // 버튼 누르면 realtime database 에 할 일 추가됨
        var etValue = etWrite.text.toString()
        myRef.child("예정").push().setValue(etValue)
        etWrite.text.clear()
    }
}