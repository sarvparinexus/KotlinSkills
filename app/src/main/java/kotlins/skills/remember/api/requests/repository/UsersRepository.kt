package kotlins.skills.remember.api.requests.repository

import kotlins.skills.remember.api.models.users.UserData
import kotlins.skills.remember.api.models.users.UserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface UsersRepository {

    suspend fun listUsers(): Flow<Response<UserResponse>>

    suspend fun fetchDataUserId(apiLevel: Int): Flow<Response<UserData>>
}