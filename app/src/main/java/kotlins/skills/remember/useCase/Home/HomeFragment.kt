package kotlins.skills.remember.useCase.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlins.skills.remember.R
import kotlins.skills.remember.api.models.ApiStatus
import kotlins.skills.remember.api.models.users.DataItem
import kotlins.skills.remember.ui.adapter.ProductsAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment(), HasAndroidInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>


    private val homeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.setup()
        homeViewModel._products?.observe(requireActivity(), Observer {


            when (it.status) {
                ApiStatus.LOADING -> progressBar.visibility = View.VISIBLE
                ApiStatus.SUCCESS -> {

                    it.data?.let { it1 -> loadRecyclerView(it1.dataUser as List<DataItem>) }
                    progressBar.visibility = View.GONE
                }

                ApiStatus.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

//        buttonNextPage.setOnClickListener {
//            val action = NavigationGraphMainDirections.actionGlobalPageFragment(1, "HomeFragment")
//            view.findNavController().navigate(action)
//        }
    }

    private fun loadRecyclerView(listUsers: List<DataItem>) {
        recycler_view.apply {

            layoutManager = GridLayoutManager(activity, 2)
            adapter = ProductsAdapter(listUsers)

        }
        progressBar.visibility = View.GONE
    }

    override fun androidInjector() = dispatchingAndroidInjector
}