package com.chm.skbankdemo.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.chm.skbankdemo.R
import com.chm.skbankdemo.api.model.Park
import com.chm.skbankdemo.databinding.ParkItemBinding
import com.google.android.material.navigation.NavigationBarItemView


class RecyclerViewAdapter(
    private val items: List<Park>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ParkItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ParkItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(park: Park) {
            Glide.with(binding.ivPic.context)
                .load(park.picUrl)
                .transform(CenterCrop(), RoundedCorners(20))
                .into(binding.ivPic)

            binding.tvName.text = park.name
            binding.tvInfo.text = park.info

            itemView.setOnClickListener {
                val bundle = bundleOf(
                    "parkName" to park.name,
                    "parkData" to park
                )
                Navigation.findNavController(it).navigate(R.id.detail_fragment, bundle)
            }
        }
    }
}