package com.example.quiz


class Questions {
    var allQuestions = arrayListOf<String>(
    )

    val allAnswers = arrayListOf<ArrayList<String>>(
            )

    val correctAnswers = arrayListOf<String>(
    )

    var savedQuestions = arrayListOf<String>()
    var savedAnswers = arrayListOf<ArrayList<String>>()
    var savedCorrectAnswers = arrayListOf<String>()


    fun addQuestion(question : String)
    {
        allQuestions.add(question)
    }

    fun addWrongAnswer(answers : ArrayList<String>) {
        allAnswers.add(answers)
    }

    fun addCorrectAnswer(answer : String) {
        correctAnswers.add(answer)
    }

    fun getRandomQuestion()
    {
        val randomNumber = (0..(allQuestions.size - 1)).shuffled().first()
        println(allQuestions.size)

        var result = allQuestions.removeAt(randomNumber)
        savedQuestions.add(result)
        
        var results = allAnswers.removeAt(randomNumber)
        results.shuffle()
        savedAnswers.add(results)

        result = correctAnswers.removeAt(randomNumber)
        savedCorrectAnswers.add(result)

    }



}

