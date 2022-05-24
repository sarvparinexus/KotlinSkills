package com.example.template.core.dataSource.remote

import kotlins.skills.remember.api.models.users.UserData
import kotlins.skills.remember.api.models.users.UserResponse
import kotlins.skills.remember.api.requests.ApiClass.ApiServices
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class ApiHelperImpl @Inject constructor(private val apiService: ApiServices) : ApiHelper {
    override suspend fun getUsers(): Flow<Response<UserResponse>> {
        return flow { emit(apiService.listUsers()) }.flowOn(Dispatchers.IO)
    }

    override suspend fun getDataUser(userId:Int): Flow<Response<UserData>> {
        return flow { emit(apiService.fetchDataUserId(userId)) }.flowOn(Dispatchers.IO)
    }


}


