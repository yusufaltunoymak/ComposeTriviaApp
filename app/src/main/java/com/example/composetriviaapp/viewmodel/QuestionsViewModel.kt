package com.example.composetriviaapp.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetriviaapp.data.DataOrException
import com.example.composetriviaapp.model.QuestionItem
import com.example.composetriviaapp.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val repository : QuestionRepository
) : ViewModel() {
    val data: MutableState<DataOrException<ArrayList<QuestionItem>,
            Boolean, Exception>> = mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        getAllQuestions()
    }

    private fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()
            if(data.value.data.toString().isNotBlank()) {
                data.value.loading = false
                Log.e("asd","${data.value.data?.size}")
            }
        }
    }
}