package com.example.template.di.modules

import dagger.Binds
import dagger.Module
import kotlins.skills.remember.api.requests.repository.UsersRepository
import kotlins.skills.remember.api.requests.repository.UsersRepositoryImpl
import javax.inject.Singleton

@Module
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun usersRepository(repositoryImpl: UsersRepositoryImpl): UsersRepository

}
