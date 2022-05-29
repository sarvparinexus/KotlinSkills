package kotlins.skills.remember.useCase.Register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class RegisterViewModel @Inject constructor() : ViewModel() {
    private var username: String? = null
    private var password: String? = null
    private var acceptedTCs: Boolean? = null

    fun updateUserData(username: String, password: String) {
        this.username = username
        this.password = password
    }

    fun acceptTCs() {
        acceptedTCs = true
    }

    fun registerUser() {
        assert(username != null)
        assert(password != null)
        assert(acceptedTCs == true)

//        userManager.registerUser(username!!, password!!)
    }

    private val _enterDetailsState = MutableLiveData<EnterDetailsViewState>()
    val enterDetailsState: LiveData<EnterDetailsViewState>
        get() = _enterDetailsState

    fun validateInput(username: String, password: String) {
        when {
            username.length < Companion.MAX_LENGTH ->
                _enterDetailsState.value =
                    EnterDetailsViewState.EnterDetailsError("Username has to be longer than 4 characters")
            password.length < Companion.MAX_LENGTH ->
                _enterDetailsState.value =
                    EnterDetailsViewState.EnterDetailsError("Password has to be longer than 4 characters")
            else -> _enterDetailsState.value = EnterDetailsViewState.EnterDetailsSuccess
        }
    }

    companion object {
        private const val MAX_LENGTH = 5
    }
}
