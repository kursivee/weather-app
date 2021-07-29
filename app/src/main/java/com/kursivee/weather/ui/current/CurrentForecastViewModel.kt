package com.kursivee.weather.ui.current

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kursivee.weather.entity.CurrentForecastEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentForecastViewModel @Inject constructor(
    private val getCurrentForecastUseCase: GetCurrentForecast
) : ViewModel() {

    init {
        getCurrentForecast("90210")
    }

    private val _state = MutableLiveData<CurrentForecastEntity>()
    val state: LiveData<CurrentForecastEntity> = _state

    fun getCurrentForecast(zipCode: String) {
        viewModelScope.launch {
            getCurrentForecastUseCase(zipCode).map { currentForecastEntity ->
                _state.value = currentForecastEntity
            }
        }
    }
}
