package com.kursivee.weather.ui.current

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kursivee.weather.R
import com.kursivee.weather.databinding.CurrentForecastFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrentForecastFragment : Fragment() {

    private val viewModel: CurrentForecastViewModel by viewModels()
    private var _binding: CurrentForecastFragmentBinding? = null
    private val binding: CurrentForecastFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CurrentForecastFragmentBinding.inflate(layoutInflater)
        viewModel.state.observe(viewLifecycleOwner) { currentForecastEntity ->
            with(binding) {
                tvDegree.isVisible = true
                tvDate.text = currentForecastEntity.timeString()
                tvTemperature.text = String.format(
                    resources.getString(R.string.temp),
                    currentForecastEntity.currentFahrenheit
                )
                tvHighLow.text = String.format(
                    resources.getString(R.string.max_min_temp),
                    currentForecastEntity.maxFahrenheit,
                    currentForecastEntity.minFahrenheit
                )
                tvFeeling.text = String.format(
                    resources.getString(R.string.feels_like_temp),
                    currentForecastEntity.feelsLikeFahrenheit
                )
            }
        }
        with(binding.toolbar.menu.findItem(R.id.search).actionView as SearchView) {
            maxWidth = Int.MAX_VALUE
            setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    if(!p0.isNullOrBlank()) {
                        viewModel.getCurrentForecast(p0)
                    }
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    return true
                }

            })
            isIconified = false
        }git a
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
