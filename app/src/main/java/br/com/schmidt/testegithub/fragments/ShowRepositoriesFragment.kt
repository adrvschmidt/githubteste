package br.com.schmidt.testegithub.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.schmidt.testegithub.R
import br.com.schmidt.testegithub.RepositoryAdapter
import br.com.schmidt.testegithub.databinding.FragmentShowRepositoriesBinding
import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.viewmodels.RepositoriesViewModel

class ShowRepositoriesFragment : Fragment() {

    private var _binding: FragmentShowRepositoriesBinding? = null

    private val binding get() = _binding!!

    private val flowersListViewModel by viewModels<RepositoriesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowRepositoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        flowersListViewModel.repositoriesLiveData.observe(viewLifecycleOwner) { list ->
            setupRecyclerView(list)
        }
        flowersListViewModel.getRepositories()
        //findNavController().navigate(R.id.action_ShowRepositoriesFragment_to_ShowPullRequestsFragment)
    }

    private fun setupRecyclerView(list: List<ItemRepository>) {
        binding.apply{
            recyclerViewShowRepositoriesFragment.layoutManager = LinearLayoutManager(requireActivity())
            recyclerViewShowRepositoriesFragment.adapter = RepositoryAdapter(list) { teste ->
                adapterOnClick(
                    teste
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun adapterOnClick(teste: ItemRepository) {
       // ShowPullRequestsFragmentDirections.(teste)
        val action = ShowRepositoriesFragmentDirections.actionShowRepositoriesFragmentToShowPullRequestsFragment(teste)
        findNavController().navigate(action)
        println("Teste do click: $teste")
    }
}