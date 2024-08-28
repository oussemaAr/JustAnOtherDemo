package template.app.launches.screens.list

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import template.app.launches.components.LaunchDTO
import template.app.launches.repository.LaunchesRepository
import template.app.rockets.repository.RocketRepository

class LaunchScreenModel(
    private val launchesRepository: LaunchesRepository,
    private val rocketRepository: RocketRepository
) : ScreenModel {

    private var _state = MutableStateFlow<List<LaunchDTO>>(emptyList())
    val state: StateFlow<List<LaunchDTO>> = _state.asStateFlow()

    private var _failure = MutableStateFlow(false)
    val failure: StateFlow<Boolean> = _failure.asStateFlow()

    fun fetchItems() {
        screenModelScope.launch {
            launchesRepository.fetchLaunches()
                .onSuccess { data ->
                    data.forEach {
                        it.description = rocketRepository.fetchRocketDetails(it.id)?.type.orEmpty()
                    }
                    _state.value = data
                }
                .onFailure {
                    _failure.value = true
                }

        }
    }
}