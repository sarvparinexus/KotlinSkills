package kotlins.skills.remember.useCase.Dashborad

import androidx.lifecycle.viewModelScope
import kotlins.skills.remember.BaseViewModel
import kotlins.skills.remember.repository.UsersRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

class RequestsConcurrentlyViewModel(
    private val usersRepository: UsersRepository
) : BaseViewModel<UiState>() {

    fun performNetworkRequestsSequentially() {
        uiState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val dataUser27 = usersRepository.getDataUserId(1)
                val dataUser28 = usersRepository.getDataUserId(2)
                val dataUser29 = usersRepository.getDataUserId(3)

                val listUsers = listOf(dataUser27, dataUser28, dataUser29)
                uiState.value = UiState.Success(listUsers)

            } catch (exception: Exception) {
                uiState.value = UiState.Error("Network Request failed")
            }
        }
    }

    fun performNetworkRequestsConcurrently() {
        uiState.value = UiState.Loading

        val dataUser27 = viewModelScope.async { usersRepository.getDataUserId(1) }
        val dataUser28 = viewModelScope.async { usersRepository.getDataUserId(2) }
        val dataUser29 =
            viewModelScope.async { usersRepository.getDataUserId(3) }

        viewModelScope.launch {
            try {
                val versionFeatures =
                    awaitAll(dataUser27, dataUser28, dataUser29)
                uiState.value = UiState.Success(versionFeatures)
            } catch (exception: Exception) {
                uiState.value = UiState.Error("Network Request failed")
            }
        }

        /*

        Alternatively:

        viewModelScope.launch {
            try {
                // we need to wrap this code with a coroutineScope block
                // otherwise the app would crash on unsuccessful network requests
                coroutineScope {
                    val dataUser27 = async { usersRepository.getDataUserId(27) }
                    val dataUser28 = async { usersRepository.getDataUserId(28) }
                    val dataUser29 = async { usersRepository.getDataUserId(29) }

                    val dataUser27Features = dataUser27.await()
                    val dataUser28Features = dataUser28.await()
                    val dataUser29Features = dataUser29.await()

                    val versionFeatures = listOf(dataUser27Features, dataUser28Features, dataUser29Features)

                    // other alternative: (but slightly different behavior when a deferred fails, see docs)
                    // val versionFeatures = awaitAll(dataUser27, dataUser28, dataUser29)

                    uiState.value = UiState.Success(versionFeatures)
                }

            } catch (exception: Exception) {
                uiState.value = UiState.Error("Network Request failed")
            }
        }*/
    }
}