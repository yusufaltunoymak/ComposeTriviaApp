package com.example.composetriviaapp.service

import com.example.composetriviaapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI {
    @GET("world.json")
    suspend fun getAllQuestions() : Question

}