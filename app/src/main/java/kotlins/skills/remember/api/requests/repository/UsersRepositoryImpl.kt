package kotlins.skills.remember.api.requests.repository

import com.example.template.core.dataSource.remote.ApiHelper
import kotlins.skills.remember.api.models.users.UserData
import kotlins.skills.remember.api.models.users.UserResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class UsersRepositoryImpl @Inject constructor (private val apiHelper: ApiHelper) : UsersRepository {
    override suspend fun listUsers(): Flow<Response<UserResponse>> {
        return apiHelper.getUsers()
    }

    override suspend fun fetchDataUserId(apiLevel: Int): Response<UserData> {
        return apiHelper.getDataUser(apiLevel)
    }
}

