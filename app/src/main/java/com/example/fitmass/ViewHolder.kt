package com.example.fitmass

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.layout_menurec_template, parent, false)) {

    private var imgView: ImageView? = null
    private var txtTitle: TextView? = null
    private var txtSubTitle: TextView? = null
    private var txtProtein: TextView? = null
    private var txtCarbo: TextView? = null
    private var txtFat: TextView? = null

    init {
        imgView = itemView.findViewById(R.id.img_view)
        txtTitle= itemView.findViewById(R.id.txt_title)
        txtSubTitle = itemView.findViewById(R.id.txt_sub_title)
        txtProtein = itemView.findViewById(R.id.txt_Protein)
        txtCarbo = itemView.findViewById(R.id.txt_Carbo)
        txtFat = itemView.findViewById(R.id.txt_Fat)
    }

    fun bind(data: Menu){
        imgView?.setImageResource(data.imgView)
        txtTitle?.text = data.txtTitle
        txtSubTitle?.text = data.txtSubTitle
        txtProtein?.text = data.txtProtein
        txtCarbo?.text = data.txtCarbo
        txtFat?.text = data.txtFat
    }


}