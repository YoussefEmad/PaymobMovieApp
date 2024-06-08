package com.example.paymobmovieapp.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.paymobmovieapp.R
import com.example.paymobmovieapp.common.loadImage
import com.example.paymobmovieapp.databinding.FragmentMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailsBinding
    val args:MovieDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailsBinding.bind(view)
        bindData()
    }
    fun bindData(){
        args.movie.let {
            binding.apply {
                txtDate.text = it.releaseDate
                txtOverview.text = it.overview
                txtVoteAverage.text = it.rating.toString()
                ivProduct.loadImage(it.moviePoster)
            }
        }
    }

}