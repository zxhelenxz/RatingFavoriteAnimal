package com.example.hw3_rateyourfavoriteanimal

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity

abstract class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE = 123 // MUST BE 0 -65535
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
//    val secondActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            result-> if (result.resultCode == Activity.RESULT_OK){
//        val data = result.data
//        val imgBtnId = data?.getIntExtra("img_btn_id",0)
//        val imgRating = data?.getDoubleExtra("rating",0.0)
//        var rb:Int
//        var tv:Int
//        when (imgBtnId){
//            1 -> {
//                rb = R.id.rb_dog
//                tv = R.id.tv_dog
//            }
//            2 -> {
//                rb = R.id.rb_cat
//                tv = R.id.tv_cat
//            }
//            3 -> {
//                rb = R.id.rb_bear
//                tv = R.id.tv_bear
//            }
//            else -> {
//                rb = R.id.rb_rabbit
//                tv = R.id.tv_rabbit
//            }
//        }
//        findViewById<RatingBar>(rb).rating = imgRating!!.toFloat()
//        findViewById<TextView>(tv).text = imgRating.toString()
//    }
//    }


//    fun sendRatingToSecondActivity(view: View){
//        //Create an Intent object with two parameters
//        val myIntent = Intent(this, animalRatingActivity::class.java)
//        val id = when (view.id){
//            R.id.img_btn_dog->1
//            R.id.img_btn_cat->2
//            R.id.img_btn_bear->3
//            else ->4
//        }
//        // put "extras" into the intent for access in the second activity
//        myIntent.putExtra("img_btn_id",id)
//
//        // Start the new Activity with the given intent and registers the ActivityResultCallback
//        //secondActivityLauncher.launch(myIntent)
//        //startActivity(myIntent)
//        //startActivityForResult(myIntent,REQUEST_CODE)
//        val sp = getSharedPreferences("MyRatingPoint", Context.MODE_PRIVATE)
//        val editor = sp.edit()
//        editor.putInt("img_btn_id", id)
//        editor.commit()
//        startActivity(myIntent)
//    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//            if (requestCode ==REQUEST_CODE){
//                val img_btn_id = data?.getIntExtra("img_btn_id",0)
//                val img_rating = data?.getDoubleExtra("rating",0.0)
//                var rb:Int
//                var tv:Int
//                when (img_btn_id){
//                    1 -> {
//                        rb = R.id.rb_dog
//                        tv = R.id.tv_dog
//                    }
//                    2 -> {
//                        rb = R.id.rb_cat
//                        tv = R.id.tv_cat
//                    }
//                    3 -> {
//                        rb = R.id.rb_bear
//                        tv = R.id.tv_bear
//                    }
//                    else -> {
//                        rb = R.id.rb_rabbit
//                        tv = R.id.tv_rabbit
//                    }
//                }
//                findViewById<RatingBar>(rb).rating = img_rating!!.toFloat()
//                findViewById<TextView>(tv).text = img_rating.toString()
//            }
//    }
}