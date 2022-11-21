package br.com.schmidt.testegithub.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.schmidt.testegithub.MyApplication
import br.com.schmidt.testegithub.R
import br.com.schmidt.testegithub.activity.MainActivity
import br.com.schmidt.testegithub.databinding.FragmentRecyclerViewBinding
import br.com.schmidt.testegithub.ui.adapters.RepositoryAdapter
import br.com.schmidt.testegithub.ui.comparators.RepositoriesItemComparator
import br.com.schmidt.testegithub.ui.models.ItemRepository
import br.com.schmidt.testegithub.ui.viewmodels.RepositoriesViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShowRepositoriesFragment @Inject constructor(): Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null

    private val binding get() = _binding!!

    @Inject
    lateinit var repositoriesViewModel: RepositoriesViewModel

    private val repositoryAdapter =
        RepositoryAdapter(RepositoriesItemComparator) { itemRepository ->
            adapterOnClick(
                itemRepository
            )
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().application as MyApplication).getAppComponent().inject(this)
        (requireActivity() as MainActivity).title =
            requireActivity().getString(R.string.first_fragment_label)
        setupRecyclerView()
        startGetRewpositories()
        setAdapterListener()
    }

    private fun setAdapterListener() {
        repositoryAdapter.addLoadStateListener {
            binding.textViewPageNumber.text = (repositoryAdapter.itemCount / 15).toString()
        }
    }

    private fun startGetRewpositories() {
        lifecycleScope.launch {
            repositoriesViewModel.flow.collectLatest { pagingData ->
                repositoryAdapter.submitData(pagingData = pagingData)
            }
        }
    }

    private fun setupRecyclerView() {
        binding.apply {
            recyclerViewFragment.layoutManager = LinearLayoutManager(requireActivity())
            recyclerViewFragment.adapter = repositoryAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun adapterOnClick(itemRepository: ItemRepository) {
        val action =
            ShowRepositoriesFragmentDirections.actionShowRepositoriesFragmentToShowPullRequestsFragment(
                itemRepository
            )
        findNavController().navigate(action)
    }
}