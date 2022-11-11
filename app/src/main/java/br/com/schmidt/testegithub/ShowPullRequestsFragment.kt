package br.com.schmidt.testegithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.schmidt.testegithub.databinding.FragmentShowPullRequestsBinding

class ShowPullRequestsFragment : Fragment() {

    private var _binding: FragmentShowPullRequestsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShowPullRequestsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //findNavController().navigate(R.id.action_ShowPullRequestsFragment_to_ShowRepositoriesFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}