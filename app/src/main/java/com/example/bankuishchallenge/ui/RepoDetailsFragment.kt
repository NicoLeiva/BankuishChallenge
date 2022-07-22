package com.example.bankuishchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.bankuishchallenge.databinding.FragmentRepoDetailsBinding
import com.example.bankuishchallenge.model.Item
import com.squareup.picasso.Picasso

class RepoDetailsFragment : Fragment() {

    private lateinit var binding: FragmentRepoDetailsBinding
    private lateinit var item: Item
    private val args: RepoDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepoDetailsBinding.inflate(layoutInflater, container, false)
        item = args.item
        setRepoInformation()
        return binding.root
    }

    private fun setRepoInformation() {
        with(item) {
            binding.name.text = name
            binding.description.text = description
            binding.language.text = language
            binding.url.text = html_url
            binding.dateCreate.text = created_at
            binding.dateUpdated.text = updated_at
            Picasso.get().load(item.owner.avatar_url).into(binding.imageView)
        }
    }
}