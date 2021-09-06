package com.example.orderpay

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.orderpay.adapter.RecyclerViewAdapter
import com.example.orderpay.databinding.FragmentCharactersBinding
import com.example.orderpay.model.Character
import com.example.orderpay.viewModel.MainActivityViewModel
import javax.inject.Inject

class CharactersFragment : Fragment() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerAdapter: RecyclerViewAdapter
    private lateinit var characters: ArrayList<Character>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        val view = binding.root
        initViewModel()
        initView()

        return view
    }

    private fun initView() {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter
        recyclerAdapter.onItemClick = { character ->
            val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailFragment(character)
            findNavController().navigate(action)
        }
    }

    private fun initViewModel() {
        viewModel.charactersLiveData.observe(viewLifecycleOwner) { result ->
            result.onSuccess {
                characters = it
                recyclerAdapter.setUpdatedData(it)
            }.onFailure {
                showErrrorMessage()
            }
        }
        viewModel.fetchCharacters()
    }

    private fun showErrrorMessage() {
        Toast.makeText(context, getString(R.string.error_connecting_to_server), Toast.LENGTH_LONG).show()
    }
}