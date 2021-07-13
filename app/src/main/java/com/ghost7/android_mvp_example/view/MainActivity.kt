package com.ghost7.android_mvp_example.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ghost7.android_mvp_example.R
import com.ghost7.android_mvp_example.model.Car
import com.ghost7.android_mvp_example.presenter.MainContract
import com.ghost7.android_mvp_example.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var activityMainButtonShowCarList: Button
    private lateinit var activityMainTextviewCarList: TextView

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainButtonShowCarList = findViewById(R.id.activity_main_button_show_car_list)
        activityMainTextviewCarList = findViewById(R.id.activity_main_textview_car_list)

        mainPresenter = MainPresenter().apply {
            takeView(this@MainActivity)
            initCarList()
        }

        activityMainButtonShowCarList.setOnClickListener {
            mainPresenter.displayCarList()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.dropView()
    }

    override fun showCarList(car: ArrayList<Car>) {
        activityMainTextviewCarList.text = car.toString()
    }

}