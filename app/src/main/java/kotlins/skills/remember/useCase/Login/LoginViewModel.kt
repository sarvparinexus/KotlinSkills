package kotlins.skills.remember.useCase.Login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {

    private val _loginState = MutableLiveData<LoginViewState>()
    val loginState: LiveData<LoginViewState>
        get() = _loginState

    fun login(username: String, password: String) {
//        if (userManager.loginUser(username, password)) {
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
