package com.example.composetriviaapp.repository

import android.util.Log
import com.example.composetriviaapp.data.DataOrException
import com.example.composetriviaapp.model.QuestionItem
import com.example.composetriviaapp.service.QuestionAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuestionRepository @Inject constructor(
    private val api : QuestionAPI
) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()


    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.exception = exception
            Log.d("asd", "getAllQuestions: ${dataOrException.exception!!.localizedMessage}")
        }
        return dataOrException
    }
}