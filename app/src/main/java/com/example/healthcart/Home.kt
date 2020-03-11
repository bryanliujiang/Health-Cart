package com.example.healthcart


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        // Navigation of buttons
        val updateBtn = view.findViewById<Button>(R.id.update)
        val selectBtn = view.findViewById<Button>(R.id.select)

        //@@//
        val weightInfo = view.findViewById<TextView>(R.id.weight_info)
        val heightInfo = view.findViewById<TextView>(R.id.height_info)
        val ageInfo = view.findViewById<TextView>(R.id.age_info)

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)

        if (sharedPref != null) {
            weightInfo.text = (sharedPref.getString("user_weight", "N/A")?.replace("\"", "")) + " " + (sharedPref.getString("user_weightUnit", "N/A")?.replace("\"", ""))
            heightInfo.text = (sharedPref.getString("user_height", "N/A")?.replace("\"", "")) + " " + (sharedPref.getString("user_heightUnit", "N/A")?.replace("\"", ""))
            ageInfo.text = (sharedPref.getString("user_age", "N/A")?.replace("\"", "")) + " days"
            //weightInfo.text = sharedPref.getString("user_weight", "N/A")
        }
        //@@//

        val navigateToUpdate = Navigation.createNavigateOnClickListener(R.id.action_home_to_update)
        val navigateToSelect = Navigation.createNavigateOnClickListener(R.id.action_home_to_select)
        updateBtn.setOnClickListener(navigateToUpdate)
        selectBtn.setOnClickListener(navigateToSelect)

        //@@//
        weightInfo.setOnClickListener(navigateToUpdate)
        heightInfo.setOnClickListener(navigateToUpdate)
        ageInfo.setOnClickListener(navigateToUpdate)
        //@@//
        return view
    }


}
