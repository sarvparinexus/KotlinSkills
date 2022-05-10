package kotlins.skills.remember.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_dashboard.buttonNextPage
import kotlins.skills.remember.NavigationGraphMainDirections
import kotlins.skills.remember.R

class DashboardFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNextPage.setOnClickListener {
            val action =
                NavigationGraphMainDirections.actionGlobalPageFragment(1, "DashboardFragment")
            view.findNavController().navigate(action)
        }
    }
}