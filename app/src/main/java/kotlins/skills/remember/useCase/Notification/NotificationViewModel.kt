package kotlins.skills.remember.useCase.Notification

import androidx.lifecycle.ViewModel
import kotlins.skills.remember.api.requests.repository.UsersRepository
import javax.inject.Inject



class NotificationViewModel @Inject constructor (private val userRepository: UsersRepository): ViewModel() {
}