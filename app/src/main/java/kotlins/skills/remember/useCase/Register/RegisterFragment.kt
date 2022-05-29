package kotlins.skills.remember.useCase.Register

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlins.skills.remember.R
import kotlinx.android.synthetic.main.fragment_register.*
import javax.inject.Inject

class RegisterFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val registerViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[RegisterViewModel::class.java]
    }
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Grabs the registrationComponent from the Activity and injects this Fragment
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        registerViewModel.enterDetailsState.observe(
            viewLifecycleOwner,
            { state ->
                when (state) {
                    is EnterDetailsViewState.EnterDetailsSuccess -> {

                        val username = username.text.toString()
                        val password = password.text.toString()
                        registerViewModel.updateUserData(username, password)

//                        TermsAndConditionsFragment
                    }
                    is EnterDetailsViewState.EnterDetailsError -> {
                        error.text = state.error
                        error.visibility = View.VISIBLE
                    }
                }
            }
        )

        setupViews(view)
        return view
    }

    private fun setupViews(view: View) {

        username.doOnTextChanged { _, _, _, _ -> error.visibility = View.INVISIBLE }

        password.doOnTextChanged { _, _, _, _ -> error.visibility = View.INVISIBLE }

        view.findViewById<Button>(R.id.next).setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()
            registerViewModel.validateInput(username, password)
        }
    }
}
