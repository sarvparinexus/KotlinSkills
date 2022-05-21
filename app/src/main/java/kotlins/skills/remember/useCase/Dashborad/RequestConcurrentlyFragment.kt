package kotlins.skills.remember.useCase.Dashborad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import kotlins.skills.remember.R
import kotlins.skills.remember.Utils.toast
import kotlins.skills.remember.databinding.PerformrequestsconcurrentlyFragmentBinding
import kotlins.skills.remember.BaseFragment
import kotlins.skills.remember.Utils.fromHtml
import kotlins.skills.remember.Utils.setGone
import kotlins.skills.remember.Utils.setVisible
import org.koin.androidx.viewmodel.ext.android.viewModel

class RequestConcurrentlyFragment : BaseFragment() {

    private lateinit var binding :PerformrequestsconcurrentlyFragmentBinding
    private val viewModel by viewModel<RequestsConcurrentlyViewModel>()
    private var operationStartTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.uiState().observe(this, Observer { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.performrequestsconcurrently_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRequestsConcurrently.setOnClickListener {
            viewModel.performNetworkRequestsConcurrently()
        }

//        buttonNextPage.setOnClickListener {
//            val action =
//                NavigationGraphMainDirections.actionGlobalPageFragment(1, "DashboardFragment")
//            view.findNavController().navigate(action)
//        }
    }


    private fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                onLoad()
            }
            is UiState.Success -> {
                onSuccess(uiState)
            }
            is UiState.Error -> {
                onError(uiState)
            }
        }
    }

    private fun onLoad() = with(binding) {
        operationStartTime = System.currentTimeMillis()
        progressBar.setVisible()
        textViewDuration.text = ""
        textViewResult.text = ""
        disableButtons()
    }

    private fun onSuccess(uiState: UiState.Success) = with(binding) {
        enableButtons()
        progressBar.setGone()
        val duration = System.currentTimeMillis() - operationStartTime
        textViewDuration.text = getString(R.string.duration, duration)

        val versionFeatures = uiState.versionFeatures
        val versionFeaturesString = versionFeatures.joinToString(separator = "<br><br>") {
            "<b>New User Data:  ${it.body()?.data?.id} </b> <br> ${
                it.body()?.data?.name
            }"
        }

        textViewResult.text = fromHtml(versionFeaturesString)
    }

    private fun onError(uiState: UiState.Error) {
        binding.progressBar.setGone()
        binding.textViewDuration.setGone()
        activity.toast(uiState.message)
        enableButtons()
    }

    private fun enableButtons() {
        binding.btnRequestsConcurrently.isEnabled = true
    }

    private fun disableButtons() {
        binding.btnRequestsConcurrently.isEnabled = false
    }
}