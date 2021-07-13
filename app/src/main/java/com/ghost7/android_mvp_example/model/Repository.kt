package com.ghost7.android_mvp_example.model

class Repository {

    val carList: ArrayList<Car> = ArrayList()

    fun addMyCars() {
        carList.add(Car("myCar1", 100))
        carList.add(Car("myCar2", 200))
        carList.add(Car("myCar3", 300))
    }

}