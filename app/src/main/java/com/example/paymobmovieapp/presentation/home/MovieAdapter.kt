package com.example.paymobmovieapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paymobmovieapp.R
import com.example.paymobmovieapp.common.loadImage
import com.example.paymobmovieapp.databinding.ItemMovieBinding
import com.example.paymobmovieapp.domain.model.Movie


class MovieAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Movie>() {

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.movieName == newItem.movieName
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MovieViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MovieViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    class MovieViewHolder(val binding: ItemMovieBinding, private val interaction: Interaction?) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Movie) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }
            binding.moviePoster.loadImage(item.moviePoster)
            binding.movieName.text = item.movieName
            binding.movieRating.text = item.rating.toString()
            binding.movieReleaseDate.text = item.releaseDate
            isFavMovie(item)
            binding.addToFavorites.setOnClickListener {

                interaction?.onFavSelected(adapterPosition, item)
                isFavMovie(item)
            }
        }

        private fun isFavMovie(item: Movie) {
            if (item.isFavorite)
                binding.addToFavorites.setImageResource(R.drawable.ic_isfav)
            else
                binding.addToFavorites.setImageResource(R.drawable.ic_fav)
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Movie)

        fun onFavSelected(position: Int, item: Movie)

    }
}