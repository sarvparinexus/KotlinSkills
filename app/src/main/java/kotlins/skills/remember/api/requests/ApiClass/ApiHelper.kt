package com.example.template.core.dataSource.remote

import kotlins.skills.remember.api.models.users.UserData
import kotlins.skills.remember.api.models.users.UserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Flow<Response<UserResponse>>
    suspend fun getDataUser(userId:Int): Response<UserData>
}
