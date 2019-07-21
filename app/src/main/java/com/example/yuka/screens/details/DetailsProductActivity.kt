package com.example.yuka.screens.details

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.yuka.R
import com.example.yuka.model.Product
import com.example.yuka.request.Request
import com.example.yuka.request.ServerResponse
import com.example.yuka.screens.list.ProductDetailsAdapter
import kotlinx.android.synthetic.main.activity_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //La toolbar affiche une fleche retour
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //recuperer le produit passer en parametre
        // TODO Changer pour un code-barres
        val product = intent.getParcelableExtra<Product>("product")
        val barcode = "12345"

        Request().getProduct(barcode, object: Callback<ServerResponse> {
            override fun onFailure(call: Call<ServerResponse>, t: Throwable) {
                //
            }

            override fun onResponse(
                call: Call<ServerResponse>,
                response: Response<ServerResponse>
            ) {
                response.body()
              //TODO changer ca pour avoir la mm chose mais avec le code bar
                //TODO viewpager.adapter = ProductDetailsAdapter(supportFragmentManager, product)

            }

        })


        setContentView(R.layout.activity_details)

        viewpager.adapter = ProductDetailsAdapter(supportFragmentManager, product)
        tabs.setupWithViewPager(viewpager)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}

