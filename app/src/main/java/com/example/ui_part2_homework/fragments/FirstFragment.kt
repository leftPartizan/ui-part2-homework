package com.example.ui_part2_homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ui_part2_homework.R
import com.example.ui_part2_homework.databinding.FirstFragmentBinding
import com.example.ui_part2_homework.utils.CounterManager


class FirstFragment: Fragment(R.layout.first_fragment) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            val childFragment = FirstFragmentChild()
            add(R.id.fragmentContainerCounterFirst, childFragment)
            addToBackStack(null)

            commit()
        }

    }

}