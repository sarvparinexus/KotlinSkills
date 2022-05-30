package kotlins.skills.remember.useCase.Register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlins.skills.remember.R
import kotlins.skills.remember.databinding.FragmentRegisterBinding
import kotlins.skills.remember.useCase.TermsAndConditions.TermsAndConditionsFragment
import javax.inject.Inject

class RegisterFragment @Inject constructor() : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var termsAndConditionsFragment: TermsAndConditionsFragment

    private lateinit var fragmentRegisterBinding: FragmentRegisterBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    private val registerViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[RegisterViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentRegisterBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        registerViewModel.enterDetailsState.observe(
            viewLifecycleOwner,
            { state ->
                when (state) {
                    is EnterDetailsViewState.EnterDetailsSuccess -> {

                        val username = fragmentRegisterBinding.username.text.toString()
                        val password = fragmentRegisterBinding.password.text.toString()
                        registerViewModel.updateUserData(username, password)
                        activity?.supportFragmentManager?.beginTransaction()
                            ?.add(R.id.layoutRegister, termsAndConditionsFragment)
                            ?.commit()
//                        TermsAndConditionsFragment
                    }
                    is EnterDetailsViewState.EnterDetailsError -> {
                        fragmentRegisterBinding.error.text = state.error
                        fragmentRegisterBinding.error.visibility = View.VISIBLE
                    }
                }
            }
        )

        setupViews()
        return fragmentRegisterBinding.root
    }

    private fun setupViews() {

        fragmentRegisterBinding.username.doOnTextChanged { _, _, _, _ ->
            fragmentRegisterBinding.error.visibility = View.INVISIBLE
        }

        fragmentRegisterBinding.password.doOnTextChanged { _, _, _, _ ->
            fragmentRegisterBinding.error.visibility = View.INVISIBLE
        }

        fragmentRegisterBinding.next.setOnClickListener {
            val username = fragmentRegisterBinding.username.text.toString()
            val password = fragmentRegisterBinding.password.text.toString()
            registerViewModel.validateInput(username, password)
        }
    }

    override fun androidInjector() = dispatchingAndroidInjector
}
