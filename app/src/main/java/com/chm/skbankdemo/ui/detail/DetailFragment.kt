package com.chm.skbankdemo.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.chm.skbankdemo.api.model.Park
import com.chm.skbankdemo.databinding.FragmentDetailBinding
import com.chm.skbankdemo.serializable

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null

    private val binding get() = _binding!!

    private lateinit var park: Park

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        park = arguments?.serializable("parkData")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val videoId = park.videoUrl.substringAfterLast("/")
        val youtubeUrl = """<iframe width="100%" height="100%" src="https://www.youtube.com/embed/$videoId" frameborder="0" allowfullscreen></iframe>"""
        binding.webView.settings.javaScriptEnabled = true
        //binding.webView.settings.loadWithOverviewMode = true
        //binding.webView.settings.useWideViewPort = true
        binding.webView.loadData(youtubeUrl, "text/html" , "utf-8")

        binding.tvInfo.text = park.info
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}