package com.example.android_mvp_example.user.di

import androidx.fragment.app.Fragment
import com.example.android_mvp_example.user.presenter.UserContract
import com.example.android_mvp_example.user.view.UserFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class UserModule {

    @Binds
    abstract fun bindView(fragment: UserFragment): UserContract.View

    @Binds
    abstract fun bindPresenter(presenterImpl: UserContract.PresenterImpl): UserContract.Presenter
}

@InstallIn(FragmentComponent::class)
@Module
object UserFragmentModule {

    @Provides
    fun provideFragment(fragment: Fragment): UserFragment {
        return fragment as UserFragment
    }
}
