package com.example.drawernavi.ui.Drink

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.drawernavi.R
import com.example.drawernavi.listener.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_drink.*

class Drink : Fragment() {

    lateinit var drinkAdapter: DrinkAdapter
    val lm = LinearLayoutManager(activity)
    val addDrinkList: MutableList<DrinkView> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_drink, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        action()
    }

    fun initView(){
        rv_drink.layoutManager = lm
        drinkAdapter = DrinkAdapter(requireActivity())
        rv_drink.adapter = drinkAdapter

        addDrinkList.add(DrinkView("Milk Shake", "minuman manis dan dingin yang biasanya terbuat dari es krim, susu panas ataupun susu dingin. dipadukan dengan bubuk perasa (flavor powder) ataupun sirup."))
        addDrinkList.add(DrinkView("Milk Tea", "milk tea yaitu teh yang dicampur dengan susu. susu bisa berupa susu segar rendah lemak (low fat) ataupun menggunakan krimer nabati sebagai pengganti susu."))
        addDrinkList.add(DrinkView("Fruit Tea", "ruit tea adalah minuman teh yang dicampurkan dengan sirup / konsentrat jus buah sebagai pemberi rasa teh tersebut."))
        addDrinkList.add(DrinkView("Flavoured Tea", "minuman teh yang menggunakan daun teh yang terlebih dahulu telah diberi ekstrak rasa / aroma tertentu."))
        addDrinkList.add(DrinkView("Hot Tea", "minuman teh yang disajikan panas. walaupun jumlah peminatnya lebih sedikit dibandingkan saat minuman ini disajikan dingin, tetapi teh panas tetap memiliki penikmatnya sendiri."))
        addDrinkList.add(DrinkView("Smoothie", "minuman segar dengan karakteristik sama seperti ice blend, yaitu es yang dihancurkan sampai halus (smooth), tetapi menggunakan bahan dasar sayuran (vegetable) dan buah asli (real fruit)."))
        addDrinkList.add(DrinkView("Flavoured Soda", "minuman dengan mencampurkan soda dengan sirup / konsentrat jus buah, maka akan diperoleh minuman dengan sensasi segar dan menyehatkan."))

        drinkAdapter.setFood(addDrinkList)
    }

    fun action(){
        drinkAdapter.setOnClickItemListener(object: OnItemClickListener {
            override fun onItemClick(item: View, position: Int) {
                var i = Intent(context, DrinkDetailActivity::class.java)
                i.putExtra("name", drinkAdapter.getFood().get(position).getNameDrink())
                i.putExtra("description", drinkAdapter.getFood().get(position).getDescriptionDrink())
                startActivity(i)
            }
        })
    }
}