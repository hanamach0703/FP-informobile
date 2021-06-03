package com.example.drawernavi.ui.Food

class FoodView{

    private var name: String = ""
    private var description: String = ""

    constructor(name: String, description: String){
        this.name = name
        this.description = description
    }
    fun getName(): String{
        return name
    }
    fun setName(name: String){
        this.name = name
    }
    fun getDescription(): String{
        return description
    }
    fun setDescription(description: String){
        this.description = description
    }

}