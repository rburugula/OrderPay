package com.example.orderpay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.orderpay.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment() {

    val args: CharacterDetailFragmentArgs by navArgs()

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.tvName.text = args.character.name
        binding.tvNickname.text = args.character.nickname
        binding.tvStatus.text = args.character.status

        return view
    }
}