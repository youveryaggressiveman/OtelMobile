package com.example.otel.adapter

import android.app.Activity
import android.widget.ArrayAdapter
import android.content.Context
import android.content.Intent

import android.widget.TextView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.example.otel.R
import com.example.otel.activity.InfoAboutOrder


class NumbersViewAdapter(private val context: Activity, private val title: ArrayList<String?>, private val description: ArrayList<String?>)
    : ArrayAdapter<String>(context, R.layout.custom_list, title) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView
        val subtitleText = rowView.findViewById(R.id.description) as TextView

        titleText.text = title[position]
        subtitleText.text = description[position]

        return rowView
    }

    override fun getItemId(position: Int): Long {

        return super.getItemId(position)
    }
}
