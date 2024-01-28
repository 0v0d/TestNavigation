package com.example.testnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testnavigation.databinding.FragmentInputBinding

class InputWordFragment : Fragment() {
  private var _binding: FragmentInputBinding? = null
  private val binding get() = _binding!!
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding= FragmentInputBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.button.setOnClickListener {
      val contest = binding.editText.text.toString()
      val action= InputWordFragmentDirections.actionFirstToSecond(Word(contest,contest.length))
      findNavController().navigate(action)
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}