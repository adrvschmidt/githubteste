package br.com.schmidt.testegithub.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.schmidt.testegithub.MyApplication
import br.com.schmidt.testegithub.ui.comparators.PullRequestsItemComparator
import br.com.schmidt.testegithub.activity.MainActivity
import br.com.schmidt.testegithub.ui.adapters.PullRequestAdapter
import br.com.schmidt.testegithub.databinding.FragmentRecyclerViewBinding
import br.com.schmidt.testegithub.ui.viewmodels.PullRequestViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


class ShowPullRequestsFragment @Inject constructor(): Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null

    private val binding get() = _binding!!

    private val args: ShowPullRequestsFragmentArgs by navArgs()

    @Inject
    lateinit var pullRequestViewModel: PullRequestViewModel

    private val pullRequestAdapter = PullRequestAdapter(PullRequestsItemComparator) { pullRequestWebUrl ->
        adapterOnClick(
            pullRequestWebUrl
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
        val itemSafeArgs = args.item
        (requireActivity() as MainActivity).title = "Repository: ${itemSafeArgs.name}"
        pullRequestViewModel.setCreatorAndRepositoryName(itemSafeArgs.owner!!.login, itemSafeArgs.name)
        setupRecyclerView()
        startGetRewpositories()
        setAdapterListener()
    }

    private fun setupRecyclerView() {
        binding.apply{
            recyclerViewFragment.layoutManager = LinearLayoutManager(requireActivity())
            recyclerViewFragment.adapter = pullRequestAdapter
            }
        }

    private fun startGetRewpositories() {
        lifecycleScope.launch {
            pullRequestViewModel.flow.collectLatest { pagingData ->
                pullRequestAdapter.submitData(pagingData = pagingData)
            }
        }
    }

    private fun adapterOnClick(webUrlPullRequest: String) {
        try {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrlPullRequest))
            startActivity(browserIntent)
        } catch (e: Exception){
            Log.d("Adriano", "Sem browser")
        }
    }

    private fun setAdapterListener() {
        pullRequestAdapter.addLoadStateListener {
            binding.textViewPageNumber.text = (pullRequestAdapter.itemCount / 10).toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}