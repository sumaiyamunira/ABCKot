package com.ipvision.abckot.rootclass

abstract class Animal (noOfLegCount:Int, noOfTail : Int) {
    val noOfLegCount = noOfLegCount;
    val noOfTail = noOfTail;

    abstract fun printAnimalProperty () : Int?

}
