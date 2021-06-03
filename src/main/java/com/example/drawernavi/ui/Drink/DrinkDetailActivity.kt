package com.example.drawernavi.ui.Drink

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.drawernavi.R
import kotlinx.android.synthetic.main.activity_drink_detail.*

class DrinkDetailActivity : AppCompatActivity() {

    var d: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        initView()
    }

    fun initView(){
        d = intent.extras

        tv_namdrink.text = d?.getString("name")
        tv_descripdrink.text = d?.getString("description")
    }
}