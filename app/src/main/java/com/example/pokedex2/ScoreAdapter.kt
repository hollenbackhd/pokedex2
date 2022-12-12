package com.example.pokedex2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex2.data.scores
import com.example.pokedex2.databinding.ListScoreBinding
import java.text.SimpleDateFormat

class ScoreAdapter  : ListAdapter<scores, ScoreAdapter.ScoreboardViewHolder>(DiffCallback) {
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<scores>() {
            override fun areItemsTheSame(oldItem: scores, newItem: scores): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: scores, newItem: scores): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreboardViewHolder {
        val viewHolder = ScoreboardViewHolder(
            ListScoreBinding.inflate(
                LayoutInflater.from( parent.context),
                parent,
                false
            )
        )

        return viewHolder
    }

    override fun onBindViewHolder(holder: ScoreboardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ScoreboardViewHolder(
        private var binding: ListScoreBinding
    ): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SimpleDateFormat")
        fun bind(scores: scores) {
            binding.userName.text = scores.userName
            binding.userScore.text = scores.userScore.toString()
        }
    }
}





