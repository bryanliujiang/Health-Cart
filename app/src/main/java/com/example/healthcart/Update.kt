package com.example.healthcart


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import androidx.navigation.Navigation
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_update.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class Update : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        // Navigation of buttons
        val updateBtn = view.findViewById<Button>(R.id.update_info)

        //@@//
        val heightEdit = view.findViewById<EditText>(R.id.height)
        val weightEdit = view.findViewById<EditText>(R.id.weight)
        val ageEdit = view.findViewById<EditText>(R.id.age)

        val heightUnit = view.findViewById<Spinner>(R.id.height_unit)
        val weightUnit = view.findViewById<Spinner>(R.id.weight_unit)

        fun saveUpdateToDB(data: String, key: String): Unit
        {
            val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
            val gson = Gson()
            val json = gson.toJson(data)
            with (sharedPref.edit()) {
                putString(key, json)
                commit()
            }
        }



        val navigateToHome = Navigation.createNavigateOnClickListener(R.id.action_update_to_home)
        //updateBtn.setOnClickListener(navigateToHome)
        updateBtn.setOnClickListener {
            run {
                //if (height.getText().toString() != "")
                    saveUpdateToDB(height.getText().toString(), "user_height")
                //if (weight.getText().toString() != "")
                    saveUpdateToDB(weight.getText().toString(), "user_weight")
                //if (age.getText().toString() != "")
                    saveUpdateToDB(age.getText().toString(), "user_age")
                saveUpdateToDB(heightUnit.getSelectedItem().toString(), "user_heightUnit")
                saveUpdateToDB(weightUnit.getSelectedItem().toString(), "user_weightUnit")
            }
        }

        //@@//
        updateBtn.setOnClickListener(navigateToHome)
        return view
    }


}
