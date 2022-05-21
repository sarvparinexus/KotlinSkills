package kotlins.skills.remember.userCase.Home

import androidx.lifecycle.*
import kotlins.skills.remember.api.models.ApiResult
import kotlins.skills.remember.api.models.users.UserResponse
import kotlins.skills.remember.repository.UsersRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart

class HomeViewModel(private val usersRepository: UsersRepository) : ViewModel() {

    private var products: LiveData<ApiResult<UserResponse>>? = null

    var _products: LiveData<ApiResult<UserResponse>>? = null
        get() = products

    fun setup(): LiveData<ApiResult<UserResponse>> {

        products = liveData {

            usersRepository.repoGetListUsers()
                .onStart {
                    emit(ApiResult.Loading(true))
                }.catch { exception ->
                    emit(ApiResult.Error(exception.cause.toString()))
                }.collect {
                    if (it.isSuccessful) {
                        emit(ApiResult.Success(it.body()))
                    }
                }
        }

        return products as LiveData<ApiResult<UserResponse>>
    }
}