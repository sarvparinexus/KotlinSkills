package kotlins.skills.remember.useCase.TermsAndConditions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlins.skills.remember.MainActivity
import kotlins.skills.remember.R
import kotlins.skills.remember.databinding.FragmentRegisterBinding
import kotlins.skills.remember.useCase.Register.RegisterViewModel
import javax.inject.Inject

class TermsAndConditionsFragment @Inject constructor() : Fragment() , HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    private val registrationViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[RegisterViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false)

        view.findViewById<Button>(R.id.next).setOnClickListener {
            registrationViewModel.acceptTCs()
            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()

        }

        return view
    }

    override fun androidInjector() = dispatchingAndroidInjector

}
