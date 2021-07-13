package com.ghost7.android_mvp_example.presenter

import com.ghost7.android_mvp_example.model.Repository

class MainPresenter : MainContract.Presenter {

    private val repository = Repository()

    private var mainView: MainContract.View? = null

    override fun takeView(view: MainContract.View) {
        mainView = view
    }

    override fun dropView() {
        mainView = null
    }

    override fun initCarList() {
        repository.addMyCars()
    }

    override fun displayCarList() {
        mainView?.showCarList(repository.carList)
    }

}