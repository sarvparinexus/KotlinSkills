package kotlins.skills.remember.useCase.Dashborad

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlins.skills.remember.api.requests.repository.UsersRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject


class RequestsConcurrentlyViewModel @Inject constructor( private val usersRepository: UsersRepository): ViewModel(){


//    fun performNetworkRequestsSequentially() {
//        uiState.value = UiState.Loading
//        viewModelScope.launch {
//            try {
//                val dataUser27 = usersRepository.fetchDataUserId(1)
//                val dataUser28 = usersRepository.fetchDataUserId(2)
//                val dataUser29 = usersRepository.fetchDataUserId(3)
//
//                val listUsers = listOf(dataUser27, dataUser28, dataUser29)
//                uiState.value = UiState.Success(listUsers)
//
//            } catch (exception: Exception) {
//                uiState.value = UiState.Error("Network Request failed")
//            }
//        }
//    }
//
    fun performNetworkRequestsConcurrently() {


        val dataUser27 = viewModelScope.async { usersRepository.fetchDataUserId(1) }
        val dataUser28 = viewModelScope.async { usersRepository.fetchDataUserId(2) }
        val dataUser29 =
            viewModelScope.async { usersRepository.fetchDataUserId(3) }

        viewModelScope.launch {
            try {
                val versionFeatures =
                    awaitAll(dataUser27, dataUser28, dataUser29)
//                uiState.value = UiState.Success(versionFeatures)
            } catch (exception: Exception) {
//                uiState.value = UiState.Error("Network Request failed")
            }
        }

        /*

        Alternatively:

        viewModelScope.launch {
            try {
                // we need to wrap this code with a coroutineScope block
                // otherwise the app would crash on unsuccessful network requests
                coroutineScope {
                    val dataUser27 = async { usersRepository.fetchDataUserId(27) }
                    val dataUser28 = async { usersRepository.fetchDataUserId(28) }
                    val dataUser29 = async { usersRepository.fetchDataUserId(29) }

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