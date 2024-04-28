package com.example.project_akhir_gdsc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_akhir_gdsc.R
import com.example.project_akhir_gdsc.model.Mahasiswa

class SiswaAdapter(
    private val listMahasiswa: ArrayList<Mahasiswa>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<SiswaAdapter.ListViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(mahasiswa: Mahasiswa)
    }

    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val npm: TextView = itemView.findViewById(R.id.tv_item_npm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_siswa_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMahasiswa.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val mahasiswa = listMahasiswa[position]
        holder.imgPhoto.setImageResource(mahasiswa.imgSiswa)
        holder.tvName.text = mahasiswa.nama
        holder.npm.text = mahasiswa.nim

        holder.itemView.setOnClickListener {
            listener.onItemClick(mahasiswa)
        }
    }
}