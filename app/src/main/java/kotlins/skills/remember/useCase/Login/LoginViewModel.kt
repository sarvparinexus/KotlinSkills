package kotlins.skills.remember.useCase.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlins.skills.remember.utils.UserDataStore
import javax.inject.Inject

class LoginViewModel @Inject constructor(val userDataStore: UserDataStore) : ViewModel() {

    private val _loginState = MutableLiveData<LoginViewState>()
    val loginState: LiveData<LoginViewState>
        get() = _loginState

    fun login(username: String, password: String) {
//        if (userDataStore.loginUser(username, password)) {
        if (true) {
            _loginState.value = LoginViewState.LoginSuccess
        } else {
            _loginState.value = LoginViewState.LoginError
        }
    }

    fun unregister() {
//        userManager.unregister()
    }

    fun getUsername(): String = "userManager.username"
}
