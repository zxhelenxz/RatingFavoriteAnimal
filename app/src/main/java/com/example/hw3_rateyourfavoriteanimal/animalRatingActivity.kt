package com.example.hw3_rateyourfavoriteanimal

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class animalRatingActivity : AppCompatActivity() {
    private var animal:String =""
    private val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_rating)
        val sharedPreferences = getSharedPreferences("MyRating", MODE_PRIVATE)
        animal = intent.getStringExtra("sendData")!!
        var img = when (animal){
            "dog"-> R.drawable.dog
            "cat"-> R.drawable.cat
            "bear"-> R.drawable.bear
            else-> R.drawable.rabbit
        }
        findViewById<ImageView>(R.id.img_animal).setImageResource(img)
        findViewById<TextView>(R.id.tv_name).text = animal
        findViewById<RatingBar>(R.id.rbRating).rating = sharedPreferences.getFloat(animal,0f)

    }

    fun returnDataToFirstActivity(view: View){
        val myIntent = Intent()
        val rating = findViewById<RatingBar>(R.id.rbRating).rating
        val sharedPreferences = getSharedPreferences("MyRating", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        //Testing
//        Log.d(TAG,animal)
//        Log.d(TAG,rating.toString())
        editor.putFloat(animal,rating)
        editor.apply()
        setResult(Activity.RESULT_OK,myIntent)
        finish()
    }

}