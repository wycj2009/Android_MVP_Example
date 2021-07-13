package com.ghost7.android_mvp_example.presenter

import com.ghost7.android_mvp_example.model.Car

interface MainContract {

    interface View {
        fun showCarList(car: ArrayList<Car>)
    }

    interface Presenter {
        fun takeView(view: View)
        fun dropView()
        fun initCarList()
        fun displayCarList()
    }

}