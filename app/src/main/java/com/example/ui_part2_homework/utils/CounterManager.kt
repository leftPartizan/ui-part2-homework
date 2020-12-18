package com.example.ui_part2_homework.utils

import android.os.Bundle
import androidx.core.os.bundleOf

class CounterManager() {

    private val KEY_COUNTER_IN_BUNDLE = "KEY_COUNTER_IN_BUNDLE"

    fun getCounter(bundle : Bundle?) = bundle?.getInt(KEY_COUNTER_IN_BUNDLE) ?: 0

    fun createArgs(counter: Int) = bundleOf(KEY_COUNTER_IN_BUNDLE to counter)
}