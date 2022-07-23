package com.example.bankuishchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankuishchallenge.databinding.FragmentRepoListBinding
import com.example.bankuishchallenge.model.Item
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
        createView()
        initViewModel()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    private fun createView() {
        recyclerViewAdapter = RecyclerViewAdapter { data -> showRepoDetails(data) }
        _binding?.recyclerView?.apply {
            _binding?.recyclerView?.layoutManager = LinearLayoutManager(context)
            recyclerViewAdapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
            adapter = recyclerViewAdapter
        }
    }

    private fun initViewModel(){
        viewModel.repos.observe(viewLifecycleOwner) {
            recyclerViewAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    private fun showRepoDetails(item: Item) {
        val action = RepoListFragmentDirections.actionRepoListFragmentToRepoDetailsFragment(item)
        findNavController().navigate(action)
    }
}