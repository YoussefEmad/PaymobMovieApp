package com.example.paymobmovieapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.paymobmovieapp.common.ViewState
import com.example.paymobmovieapp.common.gone
import com.example.paymobmovieapp.common.show
import com.example.paymobmovieapp.databinding.FragmentMovieHomeBinding
import com.example.paymobmovieapp.domain.model.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieHomeFragment : Fragment(), MovieAdapter.Interaction {


    private lateinit var binding: FragmentMovieHomeBinding
    private val viewModel: MovieViewModel by viewModels()
    private val movieAdapter by lazy { MovieAdapter(this) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeToMoviesLiveData()
    }


    private fun setupRecyclerView() {
        binding.swipeRefresh.apply {
            setOnRefreshListener {
                viewModel.getMovies()
            }
        }
        binding.moviesRecycler.apply {
            adapter = movieAdapter
        }
    }

    private fun observeToMoviesLiveData() {
        viewModel.movieLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Error -> {
                    binding.ProgressBar.gone()
                }
                is ViewState.Loading -> binding.ProgressBar.show()
                is ViewState.Success -> {
                    if (it.data != null) {
                        binding.ProgressBar.gone()
                        binding.swipeRefresh.isRefreshing = false
                        movieAdapter.differ.submitList(it.data)
                    }
                }
            }
        })
    }

    override fun onItemSelected(position: Int, item: Movie) {
        val action = MovieHomeFragmentDirections.actionMovieListFragmentToMovieDetails(item)
        findNavController().navigate(action)
    }

    override fun onFavSelected(position: Int, item: Movie) {
        item.isFavorite = !item.isFavorite
        viewModel.updateFav(item.isFavorite, item.id)

    }

}
