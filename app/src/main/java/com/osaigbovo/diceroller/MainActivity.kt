package com.osaigbovo.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.osaigbovo.diceroller.databinding.ActivityMainBinding
import java.util.*

// TODO 1 - Testing
class MainActivity : AppCompatActivity() {

    // lateinit - the variable will be initialised before calling any operations on it.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rollButton.text = "Let's Roll!"
        binding.rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }

    }

    private fun rollDice() {
        //val resultText: TextView = findViewById(R.id.result_text)
        //val randomInt = Random().nextInt(6) + 1
        //resultText.text = randomInt.toString()

        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.diceImage.setImageResource(drawableResource)

    }


}
