package com.example.project_akhir_gdsc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_akhir_gdsc.adapter.SiswaAdapter
import com.example.project_akhir_gdsc.databinding.ActivityMainBinding
import com.example.project_akhir_gdsc.model.Mahasiswa

class MainActivity : AppCompatActivity(), SiswaAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Mahasiswa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyleView.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()
    }

    private fun getListHeroes(): ArrayList<Mahasiswa> {
        val dataName = resources.getStringArray(R.array.data_name)
        val npm = resources.getStringArray(R.array.data_nim)
        val dataPhoto = resources.obtainTypedArray(R.array.data_img)
        val dataUniversitas = resources.getStringArray(R.array.data_universitas)
        val dataProgramStudi = resources.getStringArray(R.array.data_programStudi)
        val listSiswa = ArrayList<Mahasiswa>()
        for (i in dataName.indices) {
            val hero = Mahasiswa(dataName[i], dataPhoto.getResourceId(i, -1), npm[i], dataProgramStudi[i], dataUniversitas[i])
            listSiswa.add(hero)
        }
        dataPhoto.recycle() // Melepaskan TypedArray
        return listSiswa
    }

    private fun showRecyclerList() {
        binding.recyleView.layoutManager = LinearLayoutManager(this)
        val listSiswaAdapter = SiswaAdapter(list, this)
        binding.recyleView.adapter = listSiswaAdapter
    }

    override fun onItemClick(mahasiswa: Mahasiswa) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("MAHASISWA", mahasiswa)
        startActivity(intent)
    }
}
