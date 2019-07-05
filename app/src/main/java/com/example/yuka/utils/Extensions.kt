package com.example.yuka.utils

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.TextView

fun TextView.setTitleValue(title: String, value: String) {
    text = SpannableString("$title $value").apply {
        setSpan(StyleSpan(Typeface.BOLD), 0, title.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
    }
}