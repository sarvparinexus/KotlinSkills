package com.example.template.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.template.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlins.skills.remember.KotlinSkillsViewModelFactory
import kotlins.skills.remember.useCase.Dashborad.RequestsConcurrentlyViewModel
import kotlins.skills.remember.useCase.Home.HomeViewModel
import kotlins.skills.remember.useCase.Login.LoginViewModel
import kotlins.skills.remember.useCase.Notification.NotificationViewModel
import kotlins.skills.remember.useCase.Register.RegisterViewModel

@Module
internal interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NotificationViewModel::class)
    fun notificationViewModel(viewModel: NotificationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun loginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    fun registerViewModel(viewModel: RegisterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RequestsConcurrentlyViewModel::class)
    fun requestsConcurrentlyViewModel(viewModel: RequestsConcurrentlyViewModel): ViewModel

    @Binds
    fun kotlinSkillsViewModelFactory(viewModelFactory: KotlinSkillsViewModelFactory):
            ViewModelProvider.Factory
}
