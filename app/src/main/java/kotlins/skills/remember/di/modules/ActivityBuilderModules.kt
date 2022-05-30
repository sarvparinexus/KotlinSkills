package com.example.template.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlins.skills.remember.MainActivity
import kotlins.skills.remember.di.dagger.ActivityScope
import kotlins.skills.remember.di.dagger.modules.MainActivityModule
import kotlins.skills.remember.di.dagger.modules.MainFragmentBuilder
import kotlins.skills.remember.useCase.Intro.IntroActivity
import kotlins.skills.remember.useCase.Login.LoginActivity
import kotlins.skills.remember.useCase.Register.RegistrationActivity

@Module
internal interface ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainFragmentBuilder::class])
    @ActivityScope
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    @ActivityScope
    fun introActivity(): IntroActivity

    @ContributesAndroidInjector
    @ActivityScope
    fun loginActivity(): LoginActivity

    @ContributesAndroidInjector
    @ActivityScope
    fun registrationActivity(): RegistrationActivity
}
