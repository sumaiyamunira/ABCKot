package com.ipvision.abckot.baseclass

import com.ipvision.abckot.rootclass.Animal

 class Cat(noOfLegs : Int, noOfTail : Int) : Animal(noOfLegs,noOfTail) {

    override fun printAnimalProperty(): Int? {
        println("Cat Property : ")
        println("No of Leg:  ${noOfLegCount}")
        println("No of Tail:  ${noOfTail}")
        return  noOfLegCount
    }

     fun onlyTestFun(){
         println("This is test fun")
     }
}