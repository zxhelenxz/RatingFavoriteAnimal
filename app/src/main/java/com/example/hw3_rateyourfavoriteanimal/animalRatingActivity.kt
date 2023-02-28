package com.example.hw3_rateyourfavoriteanimal

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class animalRatingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_rating)
        val sp = applicationContext.getSharedPreferences("MyRatingPoint", Context.MODE_PRIVATE)
        var id = sp.getInt("img_btn_id",0)
        //val id = intent.getIntExtra("img_btn_id",0)
        var imgresource:Int =1
        var name:String = ""
        when (id){
            1-> {
                imgresource=R.drawable.dog
                name="Dog";
            }
            2-> {
                imgresource=R.drawable.cat
                name="Cat"
            }
            3-> {
                imgresource=R.drawable.bear
                name="Bear"
            }
            else -> {
               imgresource=R.drawable.rabbit
                name="Rabbit"
            }
        }
        findViewById<ImageView>(R.id.img_animal).setImageResource(imgresource)
        findViewById<TextView>(R.id.tv_name).text = name


    }
//    fun returnDataToFirstActivity(view: View){
//        val myIntent = Intent()
//        val myRatingBar = findViewById<RatingBar>(R.id.rbRating)
//        val rating = myRatingBar.rating.toString()
//        val id = intent.getIntExtra("img_btn_id",1)
//        myIntent.putExtra("img_btn_id",id)
//        myIntent.putExtra("rating",rating)
//        setResult(Activity.RESULT_OK,myIntent)
//        finish()
//    }

}