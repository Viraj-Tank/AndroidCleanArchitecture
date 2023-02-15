package com.novuspax.androidcleanarchitecture.ui.mainActivity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.novuspax.androidcleanarchitecture.databinding.InflaterFirstBinding
import com.novuspax.androidcleanarchitecture.databinding.InflaterSecondBinding
import com.novuspax.androidcleanarchitecture.remote.model.Result

class MyPagingAdapter(
    val itemClick: (Result) -> Unit
) : PagingDataAdapter<Result, RecyclerView.ViewHolder>(DIFFUTIL) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.apply {
            when (holder) {
                is FirstHolder -> {
                    holder.apply {
                        binding.apply {

                        }
                    }
                }
                is SecondHolder -> {
                    holder.apply {
                        binding.apply {

                        }
                    }
                }
                else -> {

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (getItem(viewType)?.type.equals("post", true)) {
            FirstHolder(
                InflaterFirstBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            SecondHolder(
                InflaterSecondBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }


    class FirstHolder(val binding: InflaterFirstBinding) : RecyclerView.ViewHolder(binding.root)

    class SecondHolder(val binding: InflaterSecondBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val DIFFUTIL = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(o: Result, n: Result): Boolean = o == n
            override fun areContentsTheSame(o: Result, n: Result): Boolean = o == n
        }
    }

}