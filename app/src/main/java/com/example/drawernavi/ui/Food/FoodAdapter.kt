package com.example.drawernavi.ui.Food

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.drawernavi.R
import com.example.drawernavi.listener.OnItemClickListener

class FoodAdapter (val context: Context): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    private val food: MutableList<FoodView> = mutableListOf()
    private var onSelectedLitener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(LayoutInflater.from(context).inflate(R.layout.item_food, parent, false))
    }

    override fun getItemCount(): Int {
        return food.size
    }

    override fun onBindViewHolder(holder: FoodAdapter.FoodViewHolder, position: Int) {
        holder.bindmodel(food[position])
    }

    fun setFood(data: List<FoodView>){
        food.clear()
        food.addAll(data)
        notifyDataSetChanged()
    }

    fun getFood():MutableList<FoodView>{
        return food
    }

    inner class FoodViewHolder(item: View):RecyclerView.ViewHolder(item){

        val txtName: TextView = item.findViewById(R.id.tv_name)
        val txtDescription: TextView = item.findViewById(R.id.tv_description)
        val cardviewfood: CardView = item.findViewById(R.id.cv_food)

        fun bindmodel(f: FoodView){
            txtName.text = f.getName()
            txtDescription.text = f.getDescription()
        }

        init{
            cardviewfood.setOnClickListener { onSelectedLitener?.onItemClick(it,layoutPosition) }
        }
    }

    fun setOnClickItemListener(onClikItemListener: OnItemClickListener){
        this.onSelectedLitener = onClikItemListener
    }
}