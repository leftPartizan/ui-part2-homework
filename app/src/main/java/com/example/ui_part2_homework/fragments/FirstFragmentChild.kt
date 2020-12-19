package com.example.ui_part2_homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ui_part2_homework.R
import com.example.ui_part2_homework.databinding.FirstFragmentBinding
import com.example.ui_part2_homework.utils.CounterManager


class FirstFragmentChild: Fragment(R.layout.first_fragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bindingFragment = FirstFragmentBinding.bind(view)
        val counterManager = CounterManager()
        val countValue = counterManager.getCounter(arguments)
        bindingFragment.firstFragmentCounter.text = "$countValue"

        bindingFragment.firstFragmentName.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.firstFragmentContainerView, FirstFragmentChild::class.java,
                        counterManager.createArgs(countValue+1))
                addToBackStack(null)

                commit()
            }

        }
    }

}