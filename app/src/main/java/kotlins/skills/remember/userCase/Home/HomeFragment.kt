package kotlins.skills.remember.userCase.Home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlins.skills.remember.R
import kotlins.skills.remember.api.models.ApiStatus
import kotlins.skills.remember.api.models.users.DataItem
import kotlins.skills.remember.BaseFragment
import kotlins.skills.remember.ui.adapter.ProductsAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val homeViewModel by viewModel<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.setup()
        homeViewModel._products?.observe(requireActivity(), Observer {
            Log.d("TAG", "onViewCreated:observe ")

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
}