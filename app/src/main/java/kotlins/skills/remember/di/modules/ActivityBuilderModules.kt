package com.example.template.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlins.skills.remember.MainActivity
import kotlins.skills.remember.di.dagger.ActivityScope
import kotlins.skills.remember.di.dagger.modules.MainActivityModule
import kotlins.skills.remember.di.dagger.modules.MainFragmentBuilder

@Module
internal interface ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainFragmentBuilder::class])
    @ActivityScope
    fun mainActivity(): MainActivity
}