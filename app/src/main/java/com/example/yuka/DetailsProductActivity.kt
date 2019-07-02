package com.example.yuka

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class DetailsProductActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //La toolbar affiche une fleche retour
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //recuperer le produit passer en parametre
        val product = intent.getParcelableExtra<Product>("product")
        //todo Afficher le layout de detail
        //setContentView(R.layout.xx)

        //todo utiliser le  prodcut dans la vue
       // myTextView.text = product.name
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}