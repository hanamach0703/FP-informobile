package com.example.drawernavi.ui.Food

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drawernavi.R
import com.example.drawernavi.listener.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_food.*

class Food : Fragment() {

    lateinit var foodAdapter: FoodAdapter
    val lm = LinearLayoutManager(activity)
    val addFoodList: MutableList<FoodView> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        action()
    }

    fun initView(){
        rv_food.layoutManager = lm
        foodAdapter = FoodAdapter(requireActivity())
        rv_food.adapter = foodAdapter

        addFoodList.add(FoodView("Lasagna", "Pasta yang disusun dengan lapisan keju dan saus bolognaise ini menjadi pilihan pertama yang mudah dibuat dan rasanya gak pernah mengecewakan. Lasagna berbeda dari pasta yang lain karena isiannya cukup banyak sehingga terasa lebih istimewa."))
        addFoodList.add(FoodView("Beef wellington", "Makanan ini berupa steak dan dibungkus dalam puff pastry? Pasti bikin penasaran! Nah, olahan tersebut bernama beef wellington. Tingkat kematangan dagingnya bisa disesuaikan layaknya sedang memasak steak. Menu ini pas banget jadi penghilang rasa bosan saat gak selera makan buat menyantap daging yang diolah dengan santan. "))
        addFoodList.add(FoodView("Ratatoullie", "Ratatoullie terbuat dari irisan sayur seperti timun, zucchini, tomat, terung, dengan saus tomat yang dicampur kacang atau isian lain sesuai selera. "))
        addFoodList.add(FoodView("Roasted herbs chicken", "roasted herbs chicken. Cara buatnya gak susah, ayam yang sudah dibersihkan dibumbui dengan rempah rosemary, thyme, bawang putih dan mentega tawar, lalu dipanggang hingga kulitnya menjadi krispi kecokelatan."))
        addFoodList.add(FoodView("Mushroom risotto", "Mushroom risotto memiliki rasa gurih dan kaldu khas jamur yang gak bikin enek. "))
        addFoodList.add(FoodView("Potato gratin", "potato gratin yang cara buatnya gampang banget! Potato gratin ini terdiri dari irisan tipis kentang yang dicampur dengan saus keju dan susu lalu dipanggang hingga matang dan berwarna kecokelatan."))
        addFoodList.add(FoodView("Creamy chicken soup", "Chicken creamy soup pada dasarnya sama seperti sup ayam pada umumnya, namun tambahan ekstrak krim kental dan rempah membuatnya terasa lebih gurih dan menggoyang lidah. "))
        addFoodList.add(FoodView("Pasta marinara", "Pasta marinara kaya akan rasa gurih dan segar khas seafood yang bisa menetralkan rasa enek dari makanan bersantan"))
        foodAdapter.setFood(addFoodList)
    }

    fun action(){
        foodAdapter.setOnClickItemListener(object: OnItemClickListener {
            override fun onItemClick(item: View, position: Int) {
                var i = Intent(context, FoodDetailActivity::class.java)
                i.putExtra("name", foodAdapter.getFood().get(position).getName())
                i.putExtra("description", foodAdapter.getFood().get(position).getDescription())
                startActivity(i)
            }
        })
    }
}