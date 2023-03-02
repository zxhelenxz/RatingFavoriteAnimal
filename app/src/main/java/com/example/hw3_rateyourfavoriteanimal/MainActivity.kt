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
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private val animalList = listOf("dog","cat","bear","rabbit")
    private val imageList = listOf(R.id.img_btn_dog,R.id.img_btn_cat,R.id.img_btn_bear,R.id.img_btn_rabbit)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val secondActivityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result-> if (result.resultCode == Activity.RESULT_OK){
            val data = result.data
        }
        }
        for ((index,imageId) in imageList.withIndex()){
            findViewById<ImageButton>(imageId).setOnClickListener{
                val myIntent = Intent(this, animalRatingActivity::class.java)
                myIntent.putExtra("sendData",animalList[index])
                secondActivityLauncher.launch(myIntent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getDataFromSharePreference()
    }
    override fun onDestroy() {
        super.onDestroy()
        setDataFromSharePreference()
    }
    private fun setDataFromSharePreference(){
        val sharedPreferences = getSharedPreferences("MyRating", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        for (animal in animalList){
            editor.putFloat(animal,-1f)
        }
        editor.apply()
    }
    private fun getDataFromSharePreference(){
        var name:String
        var tv:Int
        var rb:Int

        val sharedPreferences = getSharedPreferences("MyRating", MODE_PRIVATE)
        for( index in 0..3){
            when (index){
                0-> {
                    name="dog"
                    tv=R.id.tv_dog
                    rb=R.id.rb_dog
                }
                1->{
                    name="cat"
                    tv=R.id.tv_cat
                    rb=R.id.rb_cat
                }
                2->{
                    name="bear"
                    tv=R.id.tv_bear
                    rb=R.id.rb_bear
                }
                else->{
                    name="rabbit"
                    tv=R.id.tv_rabbit
                    rb=R.id.rb_rabbit
                }
            }
            val rating = sharedPreferences.getFloat(name,-1f)
            if(rating!=-1f) {
                findViewById<TextView>(tv).text = "Your rating $rating"
                findViewById<RatingBar>(rb).rating = rating
            }
        }
    }
    }


