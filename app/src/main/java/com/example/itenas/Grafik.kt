package com.example.itenas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement

class Grafik : AppCompatActivity() {

    var nilai_rata2 = ArrayList<Double>()
    var nilai  = ArrayList<Double>()
    var nama = ArrayList<String>()
    var j = 0
    var a = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafik)

        val btn_back = findViewById<ImageView>(R.id.btn_back)
        val aaChartView = findViewById<AAChartView>(R.id.aa_chart_view)
        val button = findViewById<Button>(R.id.btn_inputbmi)
        val input = findViewById<EditText>(R.id.edt_inputbmi)
        var text = findViewById<TextView>(R.id.txt_inputbmi)

        btn_back.setOnClickListener{
            var pindah = Intent(this,FragmentActivity::class.java)
            var ambil = intent.getStringExtra("uText")
            pindah.putExtra("textToDisplay", ambil)
            startActivity(pindah)
        }

        button.setOnClickListener {
            if(input.text.toString() == ""){
                Toast.makeText(this,"Tolong isi nilai BMI-nya", Toast.LENGTH_SHORT).show()
            } else {
                var value = input.text.toString().toDouble()

                nilai.add(value)
                Log.i("Nilai", nilai.toString())

                nama.add("Minggu " + a)

                a++

                text.setText("Masukkan BMI Minggu " + a + " : ")

                var myList = listOf(70, 80)
                var myArray = nilai.toTypedArray()
                var nmearray = nama.toTypedArray()
                val aaChartModel: AAChartModel = AAChartModel()
                    .chartType(AAChartType.Line)
                    .title("Grafik BMI Mingguan")
                    .categories(arrayOf(*nmearray))
                    .backgroundColor("#FFFFFF")
                    .dataLabelsEnabled(true)
                    .series(
                        arrayOf(
                            AASeriesElement()
                                .name("Nilai BMI anda")
                                .data(arrayOf(*myArray))
                        )
                    )
                aaChartView.aa_drawChartWithChartModel(aaChartModel)
            }
        }
    }
}