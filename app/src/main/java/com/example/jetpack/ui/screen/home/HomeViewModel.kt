package com.example.jetpack.ui.screen.home

//class HomeViewModel() : ViewModel() {
//    private val _uiState: MutableStateFlow<UiState<List<OrderReward>>> = MutableStateFlow(UiState.Loading)
//    val uiState: StateFlow<UiState<List<OrderReward>>>
//        get() = _uiState
//
//    fun getAllRewards() {
//        viewModelScope.launch {
//                .catch {
//                    _uiState.value = UiState.Error(it.message.toString())
//                }
//                .collect { orderRewards ->
//                    _uiState.value = UiState.Success(orderRewards)
//                }
//        }
//    }
//}