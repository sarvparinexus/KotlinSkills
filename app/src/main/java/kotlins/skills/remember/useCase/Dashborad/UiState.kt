package kotlins.skills.remember.useCase.Dashborad

import kotlins.skills.remember.api.models.users.UserData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

sealed class UiState {
    object Loading : UiState()
    data class Success(
        val versionFeatures: List<Response<UserData>>
    ) : UiState()

    data class Error(val message: String) : UiState()
}