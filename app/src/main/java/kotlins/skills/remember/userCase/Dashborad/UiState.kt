package kotlins.skills.remember.userCase.Dashborad

import kotlins.skills.remember.api.models.users.UserData
import retrofit2.Response

sealed class UiState {
    object Loading : UiState()
    data class Success(
        val versionFeatures: List<Response<UserData>>
    ) : UiState()

    data class Error(val message: String) : UiState()
}