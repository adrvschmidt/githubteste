package br.com.schmidt.testegithub.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.schmidt.testegithub.adapters.PullRequestAdapter
import br.com.schmidt.testegithub.adapters.RepositoryAdapter
import br.com.schmidt.testegithub.databinding.FragmentRecyclerViewBinding
import br.com.schmidt.testegithub.databinding.FragmentShowPullRequestsBinding
import br.com.schmidt.testegithub.models.ItemPullRequest
import br.com.schmidt.testegithub.models.ItemRepository
import br.com.schmidt.testegithub.viewmodels.PullRequestViewModel
import kotlinx.coroutines.launch

class ShowPullRequestsFragment : Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null

    private val binding get() = _binding!!

    private val args: ShowPullRequestsFragmentArgs by navArgs()

    private val pullRequestViewModel by viewModels<PullRequestViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val teste = args.teste

        pullRequestViewModel.pullRequestsLiveData.observe(viewLifecycleOwner) {
            it?.let { list ->
                setupRecyclerView(list)
            }
        }

        pullRequestViewModel.getPullRequests("LinkedInLearning", "learning-java-2825378", "1")
    }

    private fun setupRecyclerView(list: List<ItemPullRequest?>) {
        binding.apply{
            recyclerViewFragment.layoutManager = LinearLayoutManager(requireActivity())
            recyclerViewFragment.adapter = PullRequestAdapter(list) { webUrlPullRequest ->
                adapterOnClick(
                    webUrlPullRequest
                )
            }
        }
    }

    private fun adapterOnClick(webUrlPullRequest: String) {
        Log.d("Adriano", "Teste da url: $webUrlPullRequest")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}