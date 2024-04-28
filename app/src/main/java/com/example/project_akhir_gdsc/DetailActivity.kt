package com.example.project_akhir_gdsc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_akhir_gdsc.databinding.ActivityDetailBinding
import com.example.project_akhir_gdsc.model.Mahasiswa

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mahasiswa = intent.getParcelableExtra<Mahasiswa>("MAHASISWA")

        mahasiswa?.let {
            binding.txtName.text = it.nama
            binding.txtNpm.text = it.nim
            binding.txtUniversitas.text = it.universitas
            binding.txtFakultas.text = it.programStudi
            binding.imgView.setImageResource(it.imgSiswa)
        }

    }
}