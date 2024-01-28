package com.example.testnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.testnavigation.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
  private var _binding: FragmentResultBinding? = null
  private val binding get() = _binding!!
  private val args: ResultFragmentArgs by navArgs()
  private val resultViewModel: ResultViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding= FragmentResultBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.button.setOnClickListener {
      findNavController().navigate(R.id.action_back_to_first)
    }

    resultViewModel.setContestData(args.contest)
    resultViewModel.textData.observe(viewLifecycleOwner) { contest ->
      binding.word = contest
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}