package com.ipvision.abckot

import android.animation.ValueAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ipvision.abckot.baseclass.Cat
import com.ipvision.abckot.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val birthdayMsg = "Happy Birthday!";
    val msg = "Hello Kotlin!";
    val shouldShow: Boolean = true;
    var mediaPlayer: MediaPlayer? = null

    val startSize = 82f // Size in pixels
    val endSize = 42f
    val animationDuration: Long = 600 // Animation duration in ms

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(shoudShow()) {
            showBirthdayMsg(birthdayMsg);
            initUI()
            checkCatPro()
        }
    }

    // Example of Inheritance
    private fun checkCatPro() {
        val cat = Cat(2, 1)
        with(cat) {
            printAnimalProperty()
            onlyTestFun()
        }
    }

    fun shoudShow(): Boolean {
        return shouldShow;
    }

    fun playSound(resource: Int) {
        mediaPlayer?.stop()
        var resId = getResources().getIdentifier(resource.toString(),
                "raw", this?.packageName)

        mediaPlayer = MediaPlayer.create(this, resId)
        mediaPlayer?.start()

    }

    fun initUI() {
        val txt_a: TextView = binding.txtA
        val txt_b = findViewById(R.id.txt_b) as TextView
        val txt_c = findViewById(R.id.txt_c) as TextView
        val txt_d = findViewById(R.id.txt_d) as TextView
        txt_a.textSize = startSize
        txt_b.textSize = startSize
        txt_c.textSize = startSize
        txt_d.textSize = startSize

        txt_a.setOnClickListener() {
            playSound(R.raw.a_audio)
            animateText(txt_a)
            Toast.makeText(this, "" + msg + " This is A", Toast.LENGTH_SHORT).show()
        }

        txt_b.setOnClickListener() {
            playSound(R.raw.b_audio)
            animateText(txt_b)
            Toast.makeText(this, msg + " This is B", Toast.LENGTH_SHORT).show()
        }
        txt_c.setOnClickListener() {
            playSound(R.raw.c_audio)
            animateText(txt_c)
            Toast.makeText(this, msg + " This is C", Toast.LENGTH_SHORT).show()
        }
        txt_d.setOnClickListener() {
            playSound(R.raw.d_audio)
            animateText(txt_d)
            Toast.makeText(this, msg + " This is D", Toast.LENGTH_SHORT).show()
        }
    }

    private fun animateText(tv: TextView) {
        val animator = ValueAnimator.ofFloat(startSize, endSize)
        animator.duration = animationDuration

        val animator2 = ValueAnimator.ofFloat(endSize, startSize)
        animator2.duration = animationDuration

        animator2.addUpdateListener { valueAnimator ->
            val animated2Value = valueAnimator.animatedValue as Float
            tv.textSize = animated2Value
        }

        animator.addUpdateListener { valueAnimator ->
            val animatedValue = valueAnimator.animatedValue as Float
            tv.textSize = animatedValue
            animator2.start()
        }

        animator.start()
    }

    fun printBorder(symbol: String, time: Int) {
        repeat(time) {
            print(symbol)
        }
    }

    fun testPrint(msg: String) {
        println(msg)
    }

    // Example of print something in the terminal
    fun showBirthdayMsg(msg: String) {
        // Let's print a cake!
        testPrint("   ,,,,,   ")
        testPrint("   |||||   ")
        testPrint(" =========")
        testPrint("@@@@@@@@@@@")
        testPrint("{~@~@~@~@~}")
        testPrint("@@@@@@@@@@@")
//        repeat(2) {
//            printBorder("@", 10)
//        }

        testPrint("")
        testPrint(msg)
        testPrint("This is the very best age to celebrate!")

    }

    override fun onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer?.stop()
            mediaPlayer = null;
        }
        super.onDestroy()
    }
}