package com.example.kotlin2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.R


class Main2Activity : AppCompatActivity() {
    private var send_btn: Button? = null
    private var set_drink: EditText? = null
    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null

    private var sugar = "無糖"
    private var ice_opt = "微冰"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.kotlin2.R.layout.activity_main2)

        rg1 = findViewById(com.example.kotlin2.R.id.radioGroup)
        rg1!!.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                com.example.kotlin2.R.id.radioButton1 -> sugar = "無糖"
                com.example.kotlin2.R.id.radioButton2 -> sugar = "少糖"
                com.example.kotlin2.R.id.radioButton3 -> sugar = "半糖"
                com.example.kotlin2.R.id.radioButton4 -> sugar = "全糖"
            }
        }
        rg2 = findViewById(com.example.kotlin2.R.id.radioGroup2)
        rg2!!.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                com.example.kotlin2.R.id.radioButton5 -> ice_opt = "微冰"
                com.example.kotlin2.R.id.radioButton6 -> ice_opt = "少冰"
                com.example.kotlin2.R.id.radioButton7 -> ice_opt = "正常冰"
            }
        }

        send_btn = findViewById(com.example.kotlin2.R.id.btn_send)
        send_btn!!.setOnClickListener {
            set_drink = findViewById(com.example.kotlin2.R.id.ed_drink)
            val drink = set_drink!!.text.toString()
            val i = Intent()
            val b = Bundle()
            b.putString("sugar", sugar)
            b.putString("drink", drink)
            b.putString("ice", ice_opt)
            i.putExtras(b)
            setResult(101, i)
            finish()
        }
    }
}
