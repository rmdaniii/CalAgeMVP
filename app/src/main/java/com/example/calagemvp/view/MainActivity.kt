package com.example.calagemvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.calagemvp.R
import com.example.calagemvp.model.Person
import com.example.calagemvp.presenter.CalculateAgePresenter
import com.example.calagemvp.presenter.ICalculateAgePresenter

class MainActivity : AppCompatActivity(), CalculateAgePresenter.View{

    lateinit var infoTv: TextView
    lateinit var ageEdt:EditText
    lateinit var nameEdt:EditText
    lateinit var calAgeBtn: Button

    lateinit var calculateAgePresenter: ICalculateAgePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateAgePresenter = CalculateAgePresenter(this)

        infoTv = findViewById(R.id.your_age_tv)
        ageEdt = findViewById(R.id.age_edt)
        nameEdt = findViewById(R.id.name_edt)
        calAgeBtn = findViewById(R.id.calAge_btn)

        calAgeBtn.setOnClickListener {
            val name = nameEdt.text.trim().toString()
            val age = ageEdt.text.trim().toString()

            calculateAgePresenter.calculateYourAge(name,age)
        }

    }

    override fun getInfo(person: Person) {
        infoTv.text = "${person.name} your Age: ${person.age} "
    }
}