package com.example.ui_part2_homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ui_part2_homework.R
import com.example.ui_part2_homework.databinding.SecondFragmentBinding
import com.example.ui_part2_homework.utils.CounterManager


class SecondFragment: Fragment(R.layout.second_fragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bindingFragment = SecondFragmentBinding.bind(view)
        val counterManager = CounterManager()

        bindingFragment.secondFragmentCounter.setOnClickListener {
            val countValue = counterManager.getCounter(arguments)
            bindingFragment.secondFragmentCounter.text = "$countValue"
            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                add(R.id.firstFragmentContainerView, SecondFragment::class.java,
                    counterManager.createArgs(countValue+1))
                addToBackStack(null)

                commit()
            }
        }
        bindingFragment.secondFragmentCounterText.setOnClickListener{
            if (bindingFragment.secondFragmentCounter.text == "0"){
                bindingFragment.secondFragmentCounterText.text = "0"
            }
        }
    }

}