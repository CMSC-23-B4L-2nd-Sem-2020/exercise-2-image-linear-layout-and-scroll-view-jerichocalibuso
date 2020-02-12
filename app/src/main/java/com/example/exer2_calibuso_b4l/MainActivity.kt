//Author: Jericho R. Calibuso
//Date finished: 2/12/20
//Description: An application that randomizes which Disney character you are.

package com.example.exer2_calibuso_b4l

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    //lateinit promises the compiler that the variables will be initialized and will not be null
    private lateinit var disneyImage: ImageView
    private lateinit var header: TextView
    private lateinit var disneyDescription: TextView
    var startFlag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton: Button = findViewById(R.id.start_button)
        val retryButton: Button = findViewById(R.id.retry_button)
        startButton.setOnClickListener{
            roll()
            startFlag = 1
        }

        retryButton.setOnClickListener{//ensures that you cannot retry if not started
            if (startFlag == 1){
                roll()
            }else{
                Toast.makeText(this, "Please start first.", Toast.LENGTH_SHORT).show()
            }
        }

        //targets the appropriate elements based on their ids
        header = findViewById(R.id.header_text)
        disneyImage = findViewById(R.id.character_image)
        disneyDescription = findViewById(R.id.description_text)
    }

    private fun roll(){

        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt){
            1 -> R.drawable.woody
            2 -> R.drawable.zazu
            3 -> R.drawable.snow_white
            4 -> R.drawable.marlin
            5 -> R.drawable.flynn_rider
            6 -> R.drawable.tinkerbell
            7 -> R.drawable.timon
            8 -> R.drawable.pumbaa
            9 -> R.drawable.mufasa
            else -> R.drawable.mulan
        }

        val descriptionString = when (randomInt){
            1 -> R.string.woody_text
            2 -> R.string.zazu_text
            3 -> R.string.snow_white_text
            4 -> R.string.marlin_text
            5 -> R.string.flynn_rider_text
            6 -> R.string.tinkerbell_text
            7 -> R.string.timon_text
            8 -> R.string.pumbaa_text
            9 -> R.string.mufasa_text
            else -> R.string.mulan_text

        }

        //dynamically replaces the strings and images based on the random values
        header.text = getString(R.string.header2_text)
        disneyImage.setImageResource(drawableResource)
        disneyDescription.text = getString(descriptionString)

    }
}
