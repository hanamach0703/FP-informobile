package com.example.drawernavi.ui.Drink

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.drawernavi.R
import com.example.drawernavi.listener.OnItemClickListener

class DrinkAdapter (val context: Context): RecyclerView.Adapter<DrinkAdapter.DrinkViewHolder>(){

    private val drink: MutableList<DrinkView> = mutableListOf()
    private var onSelectedLitener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        return DrinkViewHolder(LayoutInflater.from(context).inflate(R.layout.item_drink, parent, false))
    }

    override fun getItemCount(): Int {
        return drink.size
    }

    override fun onBindViewHolder(holder: DrinkAdapter.DrinkViewHolder, position: Int) {
        holder.bindmodel(drink[position])
    }

    fun setFood(data: List<DrinkView>){
        drink.clear()
        drink.addAll(data)
        notifyDataSetChanged()
    }

    fun getFood():MutableList<DrinkView>{
        return drink
    }

    inner class DrinkViewHolder(item: View):RecyclerView.ViewHolder(item){

        val txtName: TextView = item.findViewById(R.id.tv_namedrink)
        val txtDescription: TextView = item.findViewById(R.id.tv_descriptiondrink)
        val cardviewfood: CardView = item.findViewById(R.id.cv_drink)

        fun bindmodel(f: DrinkView){
            txtName.text = f.getNameDrink()
            txtDescription.text = f.getDescriptionDrink()
        }

        init{
            cardviewfood.setOnClickListener { onSelectedLitener?.onItemClick(it,layoutPosition) }
        }
    }

    fun setOnClickItemListener(onClikItemListener: OnItemClickListener){
        this.onSelectedLitener = onClikItemListener
    }
}