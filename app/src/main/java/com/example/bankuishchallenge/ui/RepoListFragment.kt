package com.example.bankuishchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankuishchallenge.RepoViewModel
import com.example.bankuishchallenge.databinding.FragmentRepoListBinding
import com.example.bankuishchallenge.model.Item
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepoListFragment : Fragment() {

    private var _binding: FragmentRepoListBinding? = null
    private val binding get() = _binding!!


    private val viewModel by viewModel<RepoViewModel>()
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View {
        _binding = FragmentRepoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    private fun createView() {
        recyclerViewAdapter = RecyclerViewAdapter { data -> showCharacterDetails(data) }
        binding.recyclerView.apply {
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            adapter = recyclerViewAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createView()
        initViewModel()
    }

    private fun initViewModel() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        viewModel.getAllRepositoriesByLanguage().collectLatest{ it ->
                recyclerViewAdapter.submitData(it)
            }
        }
    }

    private fun showCharacterDetails(item: Item) {
        val action = RepoListFragmentDirections.actionRepoListFragmentToRepoDetailsFragment(item)
        findNavController().navigate(action)
    }
}