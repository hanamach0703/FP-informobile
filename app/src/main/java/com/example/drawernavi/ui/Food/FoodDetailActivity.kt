package com.example.drawernavi.ui.Food

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.drawernavi.R
import kotlinx.android.synthetic.main.activity_food_detail.*

class FoodDetailActivity : AppCompatActivity() {

    var b: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        initView()
    }

    fun initView(){
        b = intent.extras

        tv_nam.text = b?.getString("name")
        tv_descrip.text = b?.getString("description")
    }
}