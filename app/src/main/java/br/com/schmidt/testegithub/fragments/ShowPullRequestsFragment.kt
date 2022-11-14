package br.com.schmidt.testegithub.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import br.com.schmidt.testegithub.databinding.FragmentShowPullRequestsBinding

class ShowPullRequestsFragment : Fragment() {

    private var _binding: FragmentShowPullRequestsBinding? = null

    private val binding get() = _binding!!

    val args: ShowPullRequestsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowPullRequestsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val teste = args.teste
        Log.d("Adriano", "Teste 1: ${teste.name}")
        Log.d("Adriano", "Teste 2: ${teste.owner.login}")
        binding.textviewSecond.text = teste.owner.login
        //findNavController().navigate(R.id.action_ShowPullRequestsFragment_to_ShowRepositoriesFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}