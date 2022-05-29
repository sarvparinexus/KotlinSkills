package kotlins.skills.remember.useCase.TermsAndConditions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import kotlins.skills.remember.R
import kotlins.skills.remember.useCase.Register.RegisterViewModel
import javax.inject.Inject

class TermsAndConditionsFragment : Fragment() {

    // @Inject annotated fields will be provided by Dagger
    @Inject
    lateinit var registrationViewModel: RegisterViewModel

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
        val view = inflater.inflate(R.layout.fragment_terms_and_conditions, container, false)

        view.findViewById<Button>(R.id.next).setOnClickListener {
            registrationViewModel.acceptTCs()
//            MainActivity
        }

        return view
    }
}
