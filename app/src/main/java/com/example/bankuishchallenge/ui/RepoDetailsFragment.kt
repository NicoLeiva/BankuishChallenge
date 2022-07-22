package com.example.bankuishchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.bankuishchallenge.databinding.FragmentRepoDetailsBinding
import com.example.bankuishchallenge.model.Item
import com.example.bankuishchallenge.utils.DateUtils.parseDate
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
        binding.close.setOnClickListener {
            NavHostFragment.findNavController(this).popBackStack()
        }
        return binding.root
    }

    private fun setRepoInformation() {
        checkVisibility()
        with(item) {
            binding.name.text = name
            binding.description.text = description
            binding.language.text = language
            binding.url.text = html_url
            val dateFormatted = ""
            binding.dateCreate.text= parseDate(created_at)
            binding.dateUpdated.text= parseDate(updated_at)
            binding.visibility.text = visibility
            Picasso.get().load(item.owner.avatar_url).into(binding.imageView)
        }
    }

    private fun checkVisibility(){
        with(item) {
            if(description.isEmpty()) binding.descriptionTitle.visibility = View.INVISIBLE
            binding.description.text = description
            if(language.isNullOrEmpty()) binding.languageTitle.visibility = View.INVISIBLE
            binding.language.text = language
            if(html_url.isEmpty()) binding.urlTitle.visibility = View.INVISIBLE
            binding.url.text = html_url
            if(created_at.isEmpty()) binding.dateCreateTitle.visibility = View.INVISIBLE
            parseDate(created_at)
            if(updated_at.isEmpty()) binding.dateUpdatedTitle.visibility = View.INVISIBLE
            parseDate(updated_at)
            if(visibility.isEmpty()) binding.visibilityTitle.visibility = View.INVISIBLE
            binding.visibility.text = visibility
        }
    }
}