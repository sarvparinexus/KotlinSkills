package kotlins.skills.remember

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.fragment_page.buttonNextPage
import kotlinx.android.synthetic.main.fragment_page.message
import javax.inject.Inject

class PageFragment : Fragment(), HasAndroidInjector {

    private val fragmentArgs: PageFragmentArgs by navArgs()

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        message.text = "Page ${fragmentArgs.pageNumber}, Parent: ${fragmentArgs.pageParent}"

        buttonNextPage.setOnClickListener {
            view.findNavController().navigate(
                NavigationGraphMainDirections.actionGlobalPageFragment(
                    fragmentArgs.pageNumber + 1,
                    "PageFragment"
                )
            )
        }
    }
    override fun androidInjector() = dispatchingAndroidInjector
}
