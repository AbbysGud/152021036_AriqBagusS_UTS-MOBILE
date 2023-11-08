package com.example.itenas.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.itenas.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fCalculator.newInstance] factory method to
 * create an instance of this fragment.
 */
class fCalculator : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_f_calculator, container, false)

        //region Inisialisasi button
        var pilihan = 0

        var gEdt_bil1 = view.findViewById<EditText>(R.id.edt_bil1)
        var gEdt_bil2 = view.findViewById<EditText>(R.id.edt_bil2)
        var gSpn_operator = view.findViewById<Spinner>(R.id.spn1)
        var gBtn_calculate = view.findViewById<Button>(R.id.btn_calculate)
        var gTxt_hasil = view.findViewById<TextView>(R.id.txt_hasil)
        //endregion

        //region tombol hitung
        gBtn_calculate.setOnClickListener {
            var bilangan1 = gEdt_bil1.text.toString().toDouble()
            var bilangan2 = gEdt_bil2.text.toString().toDouble()
            var hasil = 0.0

            if(pilihan.equals(0)){
                hasil = bilangan1 + bilangan2
            } else if (pilihan.equals(1)){
                hasil = bilangan1 - bilangan2
            } else if (pilihan.equals(2)){
                hasil = bilangan1 / bilangan2
            } else if (pilihan.equals(3)){
                hasil = bilangan1 * bilangan2
            }

            gTxt_hasil.text = hasil.toString()
        }
        //endregion

        //region spinner
        gSpn_operator.setOnItemSelectedListener(
            object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    Log.d("ariq", "item terpilih: " + position)
                    pilihan = position
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            })
        //endregion

        // Inflate the layout for this fragment
        return view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fCalculator.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fCalculator().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}