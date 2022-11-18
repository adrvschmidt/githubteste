package br.com.schmidt.testegithub.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.schmidt.testegithub.adapters.RepositoryAdapter
import br.com.schmidt.testegithub.databinding.FragmentRecyclerViewBinding
import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.viewmodels.RepositoriesViewModel

class ShowRepositoriesFragment : Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null

    private val binding get() = _binding!!

    private val repositoriesViewModel by viewModels<RepositoriesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startGetRewpositories()
    }

    private fun startGetRewpositories() {
        repositoriesViewModel.repositoriesLiveData.observe(viewLifecycleOwner) {
            it?.let { list ->
                setupRecyclerView(list)
            }
        }
        repositoriesViewModel.getRepositories()
    }

    private fun setupRecyclerView(list: List<ItemRepository?>) {
        binding.apply{
            recyclerViewFragment.layoutManager = LinearLayoutManager(requireActivity())
            recyclerViewFragment.adapter = RepositoryAdapter(list) { itemRepository ->
                adapterOnClick(
                    itemRepository
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun adapterOnClick(itemRepository: ItemRepository) {
        val action = ShowRepositoriesFragmentDirections.actionShowRepositoriesFragmentToShowPullRequestsFragment(itemRepository)
        findNavController().navigate(action)
        println("Teste do click: $itemRepository")
    }
}