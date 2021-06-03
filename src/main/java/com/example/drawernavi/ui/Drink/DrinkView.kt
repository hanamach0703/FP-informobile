package com.example.drawernavi.ui.Drink

class DrinkView{

    private var nameDrink: String = ""
    private var descriptionDrink: String = ""

    constructor(name: String, description: String){
        this.nameDrink = name
        this.descriptionDrink = description
    }
    fun getNameDrink(): String{
        return nameDrink
    }
    fun setNameDrink(name: String){
        this.nameDrink = name
    }
    fun getDescriptionDrink(): String{
        return descriptionDrink
    }
    fun setDescriptionDrink(description: String){
        this.descriptionDrink = description
    }

}