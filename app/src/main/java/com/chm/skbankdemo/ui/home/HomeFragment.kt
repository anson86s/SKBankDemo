package com.chm.skbankdemo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.chm.skbankdemo.api.ApiManager
import com.chm.skbankdemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels {
        ViewModelFactory(HomeRepository(ApiManager.apiService))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.list) {
            layoutManager = LinearLayoutManager(context)
        }
        homeViewModel.zooResponse.observe(viewLifecycleOwner) {
            binding.list.adapter = RecyclerViewAdapter(it.data.results)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}