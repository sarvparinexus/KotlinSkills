package kotlins.skills.remember.useCase.Home

import androidx.lifecycle.*
import kotlins.skills.remember.api.models.ApiResult
import kotlins.skills.remember.api.models.users.UserResponse
import kotlins.skills.remember.api.requests.repository.UsersRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject


class HomeViewModel @Inject constructor( private val usersRepository: UsersRepository) : ViewModel() {


    private var products: LiveData<ApiResult<UserResponse>>? = null

    var _products: LiveData<ApiResult<UserResponse>>? = null
        get() = products

    fun setup(): LiveData<ApiResult<UserResponse>> {

        products = liveData {

            usersRepository.listUsers()
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