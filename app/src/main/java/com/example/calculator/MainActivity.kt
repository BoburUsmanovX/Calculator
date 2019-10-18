package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bir.setOnClickListener { ifodaQoshish("1", true) }
        ikki.setOnClickListener { ifodaQoshish("2", true) }
        uch.setOnClickListener { ifodaQoshish("3", true) }
        tort.setOnClickListener { ifodaQoshish("4", true) }
        besh.setOnClickListener { ifodaQoshish("5", true) }
        olti.setOnClickListener { ifodaQoshish("6", true) }
        yetti.setOnClickListener { ifodaQoshish("7", true) }
        sakkiz.setOnClickListener { ifodaQoshish("8", true) }
        toqqiz.setOnClickListener { ifodaQoshish("9", true) }

        qoshish.setOnClickListener { ifodaQoshish("+", true) }
        ayirish.setOnClickListener { ifodaQoshish("-", true) }
        kopaytirish.setOnClickListener { ifodaQoshish("*", true) }
        bolish.setOnClickListener { ifodaQoshish("/", true) }
        qavsOchish.setOnClickListener { ifodaQoshish("(", true) }
        qavsYopish.setOnClickListener { ifodaQoshish(")", true) }
        nuqta.setOnClickListener { ifodaQoshish(".", true) }

        tozalash.setOnClickListener {
            hisoblash.text = ""
            javob.text = ""
        }

        backspace.setOnClickListener {
            val ifoda = hisoblash.text.toString()
            if (ifoda.isNotEmpty()) {
                hisoblash.text = ifoda.substring(0, ifoda.length - 1)
            }
            javob.text = ""
        }
        barobar.setOnClickListener {
            try {

                val ifodaX = ExpressionBuilder(hisoblash.text.toString()).build()
                val result = ifodaX.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    javob.text = longResult.toString()
                else
                    javob.text = result.toString()

            } catch (e: Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }
    }

    private fun ifodaQoshish(string: String, clear: Boolean) {

        if (javob.text.isNotEmpty()) {
            hisoblash.text = ""
        }

        if (clear) {
            javob.text = ""
            hisoblash.append(string)
        } else {
            this.hisoblash.append(javob.text)
            this.hisoblash.append(string)
            javob.text = ""
        }
    }
}
