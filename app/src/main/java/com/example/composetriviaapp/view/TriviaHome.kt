package com.example.composetriviaapp.view

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetriviaapp.component.Questions
import com.example.composetriviaapp.viewmodel.QuestionsViewModel

@Composable
fun TriviaHome(viewModel : QuestionsViewModel = hiltViewModel()) {
    Questions(viewModel)

}
