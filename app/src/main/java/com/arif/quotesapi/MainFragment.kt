package com.arif.quotesapi

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.arif.quotesapi.adapter.QuotesAdapter
import com.arif.quotesapi.databinding.FragmentMainBinding
import com.arif.quotesapi.model.ModelQuotesItem

class MainFragment : Fragment() {
    private val quotesViewModel:QuotesViewModel by activityViewModels()
    private lateinit var binding : FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        val adapter = QuotesAdapter(::receiveDataFromAdapter)
        //binding.QuotesRV.layoutManager = LinearLayoutManager(requireActivity())
        binding.QuotesRV.layoutManager = GridLayoutManager(requireActivity(),2)
        binding.QuotesRV.adapter = adapter
        quotesViewModel.fetchQuotes()
        binding.mProgressbar.visibility = View.VISIBLE
        quotesViewModel.quotesLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
            binding.mProgressbar.visibility = View.GONE
            Log.d("TestingCase2",it.toString());
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    fun receiveDataFromAdapter(mQuotes: ModelQuotesItem.ModelQuotesItemItem){

        val bundle = Bundle().apply {
            putString("text_info",mQuotes.text)
            putString("auth_info",mQuotes.author)
        }
        findNavController().navigate(R.id.action_mainFragment_to_quotesDetailsFragment,bundle)

    }


}