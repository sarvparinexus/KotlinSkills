package kotlins.skills.remember.useCase.Register

sealed class EnterDetailsViewState {
    object EnterDetailsSuccess : EnterDetailsViewState()
    data class EnterDetailsError(val error: String) : EnterDetailsViewState()
}
