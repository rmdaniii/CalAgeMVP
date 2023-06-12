package com.example.calagemvp.presenter

import com.example.calagemvp.model.Person
import java.util.Calendar

class CalculateAgePresenter(private val view:View) :ICalculateAgePresenter {


    override fun calculateYourAge(name: String, age: String) {

        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val yourAge = currentYear - age.toInt()
        val person = Person(name , yourAge)
        view.getInfo(person)

    }

    interface View{
        fun getInfo(person: Person)
    }
}