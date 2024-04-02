package com.example.quiz

import android.app.AlertDialog
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.quiz.Database.User
import com.example.quiz.Database.UserClass


class SecondFragment : Fragment() {

    private var question = Questions()
    private var currentPoints = 0
    private var correctChoices = arrayListOf<Boolean>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_previous).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        val mainActivity = activity as MainActivity
        question = mainActivity.getQuestions()

        val totalAmountOfQuestions = 9
        var currentMaxQuestions = 0
        var currentCorrectQuestion = 0
        var currentQuestion = 0


        question.getRandomQuestion()

        displayQuestions(currentQuestion, view)
        view.findViewById<TextView>(R.id.text_points).text = "Current points: " + currentPoints.toString()


        // Button 1
        view.findViewById<Button>(R.id.button_choice1).setOnClickListener {
            checkCorrectAnswer(currentQuestion, 0, view)
        }

        // Button 2
        view.findViewById<Button>(R.id.button_choice2).setOnClickListener {
            checkCorrectAnswer(currentQuestion, 1, view)
        }

        // Button 3
        view.findViewById<Button>(R.id.button_choice3).setOnClickListener {
            checkCorrectAnswer(currentQuestion, 2, view)
        }

        // Button 4
        view.findViewById<Button>(R.id.button_choice4).setOnClickListener {
            checkCorrectAnswer(currentQuestion, 3, view)
        }

        // The right arrow
        view.findViewById<ImageButton>(R.id.imageRightArrow).setOnClickListener {

            // If the current question is bigger than 10
            if (currentQuestion >= totalAmountOfQuestions)
            {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Congratulations!")

                val info = TextView(context)
                info.text = R.string.show_high_score.toString()
                builder.setView(info)


                val input = EditText(context)
                input.inputType =
                    InputType.TYPE_CLASS_TEXT
                builder.setView(input)

                builder.setPositiveButton(
                    "Submit score"
                )
                {
                    dialog, _ -> val name = input.text.toString()
                    if (name.isNotEmpty()) {
                        Thread{
                            val user = UserClass(name, currentPoints)
                            mainActivity.addUser(user)

                        }.start()
                        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                    }
                }
                builder.setNegativeButton(
                    "Cancel"
                ) { dialog, which -> dialog.cancel() }

                builder.show()
            }

            // Check if it's supposed to be a new question
            else if (currentQuestion == currentMaxQuestions && correctChoices.size == currentQuestion + 1)
            {
                currentQuestion++
                currentMaxQuestions = currentQuestion

            }


            // If it's a new question, load new questions
            if (currentQuestion == currentMaxQuestions)
            {
                if (correctChoices.size == currentQuestion)
                {
                    changeBackground(view, 0)
                    question.getRandomQuestion()
                    enableButtons(view)
                    displayQuestions(currentQuestion, view)
                }

            }

            // If it is the most recent one, but it has not been answered yet
            else if (currentQuestion + 1 == currentMaxQuestions && correctChoices.size == currentMaxQuestions)
            {
                currentQuestion++
                changeBackground(view, 0)
                enableButtons(view)
                displayQuestions(currentQuestion, view)
            }


            // If the question has already been answered
            else
            {
                currentQuestion++
                if (correctChoices[currentQuestion]) {
                    changeBackground(view, 1)
                }
                else
                {
                    changeBackground(view, 2)
                }
                displayQuestions(currentQuestion, view)

            }

        }

        // The left arrow
        view.findViewById<ImageButton>(R.id.imageLeftArrow).setOnClickListener {
            if (currentQuestion > 0)
            {
                currentQuestion--
                displayQuestions(currentQuestion, view)
                disableButtons(view)
                if (correctChoices[currentQuestion]) {
                    changeBackground(view, 1)
                }
                else
                {
                    changeBackground(view, 2)
                }
            }
        }

    }

    private fun displayQuestions(number: Int, view: View) {
        val selectedQuestion = question.savedQuestions[number]
        val selectedAnswers = question.savedAnswers[number]

        view.findViewById<TextView>(R.id.text_question_number).text = "Questions number: " + (number + 1).toString()
        view.findViewById<TextView>(R.id.text_question).text = selectedQuestion
        view.findViewById<Button>(R.id.button_choice1).text = selectedAnswers[0]
        view.findViewById<Button>(R.id.button_choice2).text = selectedAnswers[1]
        view.findViewById<Button>(R.id.button_choice3).text = selectedAnswers[2]
        view.findViewById<Button>(R.id.button_choice4).text = selectedAnswers[3]
    }

    private fun checkCorrectAnswer(number: Int, choice: Int, view: View)
    {

        val correctAnswer = question.savedCorrectAnswers[number]
        println("correctAnswer" + correctAnswer)

        val chosenAnswer = question.savedAnswers[number][choice]
        println("chosenAnswer" + chosenAnswer)


        if (chosenAnswer == correctAnswer) {
            addPoints()
            correctChoices.add(true)
            changeBackground(view, 1)
        } else {
            reducePoints()
            correctChoices.add(false)
            changeBackground(view, 2)
        }

        view.findViewById<TextView>(R.id.text_points).text = "Current points: " + currentPoints.toString()
        disableButtons(view)

    }

    private fun addPoints() {
        currentPoints++
    }

    private fun reducePoints() {
        currentPoints -= 2
    }

    private fun disableButtons(view: View)
    {
        view.findViewById<Button>(R.id.button_choice1).setEnabled(false)
        view.findViewById<Button>(R.id.button_choice2).setEnabled(false)
        view.findViewById<Button>(R.id.button_choice3).setEnabled(false)
        view.findViewById<Button>(R.id.button_choice4).setEnabled(false)
    }

    private fun enableButtons(view: View)
    {
        view.findViewById<Button>(R.id.button_choice3).setEnabled(true)
        view.findViewById<Button>(R.id.button_choice2).setEnabled(true)
        view.findViewById<Button>(R.id.button_choice1).setEnabled(true)
        view.findViewById<Button>(R.id.button_choice4).setEnabled(true)
    }

    private fun changeBackground(view: View, type: Int)
    {
        if (type == 0)
        {
            view.findViewById<ImageView>(R.id.imageBackground).setImageDrawable(
                resources.getDrawable(
                    R.drawable.white
                )
            )
        }
        else if (type == 1)
        {
            view.findViewById<ImageView>(R.id.imageBackground).setImageDrawable(
                resources.getDrawable(
                    R.drawable.green
                )
            )

        }
        else
        {
            view.findViewById<ImageView>(R.id.imageBackground).setImageDrawable(
                resources.getDrawable(
                    R.drawable.red
                )
            )

        }
    }


}