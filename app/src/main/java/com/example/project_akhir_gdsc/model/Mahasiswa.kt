package com.example.project_akhir_gdsc.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mahasiswa(
    val nama: String,
    val imgSiswa: Int,
    val nim: String,
    val programStudi: String,
    val universitas: String,

) : Parcelable