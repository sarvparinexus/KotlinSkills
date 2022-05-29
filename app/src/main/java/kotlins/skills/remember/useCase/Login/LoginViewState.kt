package kotlins.skills.remember.useCase.Login

sealed class LoginViewState {
    object LoginSuccess : LoginViewState()
    object LoginError : LoginViewState()
}
