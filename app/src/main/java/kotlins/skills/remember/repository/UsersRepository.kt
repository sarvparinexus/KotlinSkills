package kotlins.skills.remember.repository

import kotlins.skills.remember.api.models.users.UserResponse
import kotlins.skills.remember.api.requests.UserServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class UsersRepository(private val userServices: UserServices) {

    suspend fun repoGetProductList() = userServices.fetchAllProducts()


    suspend fun repoGetListUsers(): Flow<Response<UserResponse>> {
        return flow {
            val usersList = userServices.listUsers()
            emit(usersList)
        }.flowOn(Dispatchers.IO)
    }
}