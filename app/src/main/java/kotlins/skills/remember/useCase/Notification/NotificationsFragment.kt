package kotlins.skills.remember.useCase.Notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_notifications.buttonNextPage
import kotlins.skills.remember.NavigationGraphMainDirections
import kotlins.skills.remember.R
import javax.inject.Inject

class NotificationsFragment : Fragment() , HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onViewCreated(view, savedInstanceState)

        buttonNextPage.setOnClickListener {
            val action =
                NavigationGraphMainDirections.actionGlobalPageFragment(1, "NotificationsFragment")
            view.findNavController().navigate(action)
        }
    }

    override fun androidInjector() = dispatchingAndroidInjector
}