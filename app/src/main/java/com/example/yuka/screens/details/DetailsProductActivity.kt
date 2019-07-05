package com.example.yuka.screens.details

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.yuka.R
import com.example.yuka.model.Product
import com.example.yuka.screens.list.ProductDetailsAdapter
import kotlinx.android.synthetic.main.activity_details.*

class DetailsProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //La toolbar affiche une fleche retour
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //recuperer le produit passer en parametre
        val product = intent.getParcelableExtra<Product>("product")


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

