package br.com.schmidt.testegithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.schmidt.testegithub.databinding.FragmentShowRepositoriesBinding

class ShowRepositoriesFragment : Fragment() {

    private var _binding: FragmentShowRepositoriesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShowRepositoriesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //findNavController().navigate(R.id.action_ShowRepositoriesFragment_to_ShowPullRequestsFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}