package com.example.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.res.TypedArrayUtils
import com.example.quiz.Database.DatabaseRepository
import com.example.quiz.Database.User
import com.example.quiz.Database.UserClass
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        getUsers()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }

    }


    fun getQuestions() : Questions {
        val questionClass = Questions()

        questionClass.addQuestion(getString(R.string.question1))
        questionClass.addQuestion(getString(R.string.question2))
        questionClass.addQuestion(getString(R.string.question3))
        questionClass.addQuestion(getString(R.string.question4))
        questionClass.addQuestion(getString(R.string.question5))
        questionClass.addQuestion(getString(R.string.question6))
        questionClass.addQuestion(getString(R.string.question7))
        questionClass.addQuestion(getString(R.string.question8))
        questionClass.addQuestion(getString(R.string.question9))
        questionClass.addQuestion(getString(R.string.question10))
        questionClass.addQuestion(getString(R.string.question11))
        questionClass.addQuestion(getString(R.string.question12))
        questionClass.addQuestion(getString(R.string.question13))
        questionClass.addQuestion(getString(R.string.question14))
        questionClass.addQuestion(getString(R.string.question15))
        questionClass.addQuestion(getString(R.string.question16))
        questionClass.addQuestion(getString(R.string.question17))
        questionClass.addQuestion(getString(R.string.question18))
        questionClass.addQuestion(getString(R.string.question19))
        questionClass.addQuestion(getString(R.string.question20))


        questionClass.addCorrectAnswer(getString(R.string.correct_answer_1))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_2))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_3))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_4))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_5))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_6))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_7))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_8))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_9))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_10))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_11))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_12))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_13))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_14))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_15))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_16))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_17))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_18))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_19))
        questionClass.addCorrectAnswer(getString(R.string.correct_answer_20))

        var wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_1),
            getString(R.string.wrong_answer1_1),
            getString(R.string.wrong_answer1_2),
            getString(R.string.wrong_answer1_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)


        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_2),
            getString(R.string.wrong_answer2_1),
            getString(R.string.wrong_answer2_2),
            getString(R.string.wrong_answer2_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_3),
            getString(R.string.wrong_answer3_1),
            getString(R.string.wrong_answer3_2),
            getString(R.string.wrong_answer3_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_4),
            getString(R.string.wrong_answer4_1),
            getString(R.string.wrong_answer4_2),
            getString(R.string.wrong_answer4_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_5),
            getString(R.string.wrong_answer5_1),
            getString(R.string.wrong_answer5_2),
            getString(R.string.wrong_answer5_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_6),
            getString(R.string.wrong_answer6_1),
            getString(R.string.wrong_answer6_2),
            getString(R.string.wrong_answer6_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)
        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_7),
            getString(R.string.wrong_answer7_1),
            getString(R.string.wrong_answer7_2),
            getString(R.string.wrong_answer7_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)
        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_8),
            getString(R.string.wrong_answer8_1),
            getString(R.string.wrong_answer8_2),
            getString(R.string.wrong_answer8_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)
        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_9),
            getString(R.string.wrong_answer9_1),
            getString(R.string.wrong_answer9_2),
            getString(R.string.wrong_answer9_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)
        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_10),
            getString(R.string.wrong_answer10_1),
            getString(R.string.wrong_answer10_2),
            getString(R.string.wrong_answer10_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_11),
            getString(R.string.wrong_answer11_1),
            getString(R.string.wrong_answer11_2),
            getString(R.string.wrong_answer11_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_12),
            getString(R.string.wrong_answer12_1),
            getString(R.string.wrong_answer12_2),
            getString(R.string.wrong_answer12_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_13),
            getString(R.string.wrong_answer13_1),
            getString(R.string.wrong_answer13_2),
            getString(R.string.wrong_answer13_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_14),
            getString(R.string.wrong_answer14_1),
            getString(R.string.wrong_answer14_2),
            getString(R.string.wrong_answer14_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_15),
            getString(R.string.wrong_answer15_1),
            getString(R.string.wrong_answer15_2),
            getString(R.string.wrong_answer15_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_16),
            getString(R.string.wrong_answer16_1),
            getString(R.string.wrong_answer16_2),
            getString(R.string.wrong_answer16_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_17),
            getString(R.string.wrong_answer17_1),
            getString(R.string.wrong_answer17_2),
            getString(R.string.wrong_answer17_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_18),
            getString(R.string.wrong_answer18_1),
            getString(R.string.wrong_answer18_2),
            getString(R.string.wrong_answer18_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)


        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_19),
            getString(R.string.wrong_answer19_1),
            getString(R.string.wrong_answer19_2),
            getString(R.string.wrong_answer19_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        wrongAnswers = arrayListOf<String>(
            getString(R.string.correct_answer_20),
            getString(R.string.wrong_answer20_1),
            getString(R.string.wrong_answer20_2),
            getString(R.string.wrong_answer20_3)
        )
        questionClass.addWrongAnswer(wrongAnswers)

        return questionClass
    }

    fun getUsers() : List<User> {

        var users : List<User> = emptyList()
        runBlocking {
            val job = GlobalScope.launch {
                val db = DatabaseRepository(application)
                users = db.returnUsers()
            }
            job.join()
        }
        return users
    }

    fun addUser(user : UserClass) {
        val db = DatabaseRepository(application)
        db.addUser(user)
    }


}