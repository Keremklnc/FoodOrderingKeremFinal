package com.keremkilinc.foodorderingapp_android_kotlin.ui.home_fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keremkilinc.foodorderingapp_android_kotlin.data.entity.Foods
import com.keremkilinc.foodorderingapp_android_kotlin.data.repository.FoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodListViewModel @Inject constructor(
    private val foodRepository: FoodRepository
) : ViewModel() {

    val foodList = MutableLiveData<List<Foods>>()
    private val sourceFoodList = MutableLiveData<List<Foods>>()
    private val selectionFoodList = MutableLiveData<List<Foods>>()

    init {
        loadFoods()
    }

    fun searchList(query: String){
        viewModelScope.launch(Dispatchers.Main) {
            foodList.value = sourceFoodList.value?.filter { it.foodName.startsWith(query, true) }
        }
    }

    private fun loadFoods() {
        viewModelScope.launch {
            foodList.value = foodRepository.loadFoods()
            sourceFoodList.value = foodList.value
            selectionFoodList.value = foodList.value
        }
    }
}