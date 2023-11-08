package com.example.itenas.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.itenas.Grafik
import com.example.itenas.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fBmi.newInstance] factory method to
 * create an instance of this fragment.
 */
class fBmi : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_f_bmi, container, false)

        val tinggi = view.findViewById<EditText>(R.id.edt_tb)
        val berat = view.findViewById<EditText>(R.id.edt_bb)

        val calcButton = view.findViewById<Button>(R.id.btn_calcbmi)
        val clearButton = view.findViewById<Button>(R.id.btn_clrbmi)
        val bmiInfo = view.findViewById<TextView>(R.id.txt_hasilbmi)
        val grafikButton = view.findViewById<Button>(R.id.btn_grafik)

        val bundle = arguments
        val message = bundle!!.getString("uText")

        calcButton.setOnClickListener{
            var nilaiTinggi = 0.0
            var nilaiBerat = 0.0
            if(tinggi.text.toString().isNotEmpty()){
                nilaiTinggi = (tinggi.text.toString().toDouble())/100
            }
            if(berat.text.toString().isNotEmpty()){
                nilaiBerat = berat.text.toString().toDouble()
            }
            if(nilaiBerat > 0.0 && nilaiTinggi > 0.0){
                val bmiValue = String.format(" %.2f", nilaiBerat/(nilaiTinggi*nilaiTinggi))
                val bmiDouble = bmiValue.toDouble()
                bmiInfo.text = "BMI anda ${String.format(" %.2f", bmiDouble)} tergolong " +
                        "${hasilBMI(nilaiBerat/(nilaiTinggi*nilaiTinggi))}"
            }
            else {
                Toast.makeText(
                    requireActivity(), "Tolong Input BB dan TB yang > 0",
                    Toast.LENGTH_LONG).show()
            }
        }

        clearButton.setOnClickListener {
            berat.text.clear()
            tinggi.text.clear()
            bmiInfo.text = ("")
        }

        grafikButton.setOnClickListener {
            val pindah = Intent(requireActivity(), Grafik::class.java)
            pindah.putExtra("uText", message)
            startActivity(pindah)
        }

        return view
    }

    fun hasilBMI(bmi:Double):String{
        lateinit var answer: String
        if(bmi<18.5){
            answer="Kurus"
        } else if(bmi > 18.5 && bmi < 24.9) {
            answer="Normal"
        } else if(bmi > 24.9 && bmi < 30) {
            answer="Gemuk"
        } else {
            answer="Obesitas"
        }
        return answer
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fBmi.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fBmi().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}