package com.example.kotlinbar.Scanner

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import com.example.kotlinbar.API.APIProducts
import com.example.kotlinbar.Produit.ClassProduits
import com.example.kotlinbar.R
import com.google.zxing.integration.android.IntentIntegrator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ScannerActivity : AppCompatActivity() {
    private lateinit var mQrResultLauncher : ActivityResultLauncher<Intent>

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Alternative to "onActivityResult", because that is "deprecated"
        mQrResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == Activity.RESULT_OK) {
                val result = IntentIntegrator.parseActivityResult(it.resultCode, it.data)

                if (result.contents != null) {
                    // Do something with the contents (this is usually a URL)
                    println(result.contents)
                    val url = "https://fr.openfoodfacts.org/"
                    val API_VER = "v0"
                    val API_P = "api/$API_VER"

                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://fr.openfoodfacts.org/")
                        .addConverterFactory(MoshiConverterFactory.create())
                        .build()

                    val service = retrofit.create(APIProducts::class.java)
                    val call = service.listRepos(result.contents)

                    if (call != null) {
                        call.enqueue( object : Callback<ClassProduits>  {
                            override fun onResponse(
                                call: Call<ClassProduits>,
                                response: Response<ClassProduits>
                            ) {
                                Log.i("TAG", "onResponse: ${response.body()}")
                            }

                            override fun onFailure(call: Call<ClassProduits>, t: Throwable) {
                                Log.e("TAG", "onFailure: ", t)
                            }
                        })
                    }

                    val barcode = result.contents
                    Toast.makeText(this, "${result.contents}", Toast.LENGTH_LONG).show()

                }
            }
        }

        // Starts scanner on Create of Overlay (you can also call this function using a button click)
        startScanner()
    }


    // Start the QR Scanner
    private fun startScanner() {
        val scanner = IntentIntegrator(this)
        // QR Code Format
        scanner.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        // Set Text Prompt at Bottom of QR code Scanner Activity
        scanner.setPrompt("ROBIN t'es trop incroyable ( je te prepare ton virement paypal tkt ) ")
        // Start Scanner (don't use initiateScan() unless if you want to use OnActivityResult)
        mQrResultLauncher.launch(scanner.createScanIntent())

    }

}



