package com.example.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.w3c.dom.Text

class FirstFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val highscore1 = view.findViewById<TextView>(R.id.textview_score1)
        val highscore2 = view.findViewById<TextView>(R.id.textview_score2)
        val highscore3 = view.findViewById<TextView>(R.id.textview_score3)

        val mainActivity = activity as MainActivity
        val users = mainActivity.getUsers()

        for (i in 0 until users.size) {
            if (i == 0) {
                highscore1.text = users[i].username.toString() + " scored: " + users[i].score.toString()
            }
            if (i == 1) {
                highscore2.text = users[i].username.toString() + " scored: " + users[i].score.toString()
            }
            if (i == 2) {
                highscore3.text = users[i].username.toString() + " scored: " + users[i].score.toString()
            }

        }


        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}