package com.example.yuka.screens.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yuka.R
import com.example.yuka.model.Product
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_products_list.*

class ProductsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_products_list)
        setSupportActionBar(toolbar)



        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))
        supportActionBar?.title = getString(R.string.products)
//        Toast.makeText(this, "Hello World!", Toast.LENGTH_LONG).show();

        list.layoutManager = LinearLayoutManager(this)


        val products = listOf(
            Product(
                "Petits pois et carottes",
                "Cassegrain",
                "3083680085304",
                "E",
                "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
                "400 g (280 g net égoutté)",
                listOf("France", "Japon", "Suisse"),
                listOf(
                    "Petits pois 66%",
                    "eau",
                    "garniture 2,8% (salade, oignon grelot)",
                    "sucre",
                    "sel",
                    "arôme naturel"
                ),
                listOf(),
                listOf(),
                122
            ),
            Product(
                "Petits pois et carottes",
                "Cassegrain",
                "3083680085304",
                "E",
                "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
                "400 g (280 g net égoutté)",
                listOf("France", "Japon", "Suisse"),
                listOf(
                    "Petits pois 66%",
                    "eau",
                    "garniture 2,8% (salade, oignon grelot)",
                    "sucre",
                    "sel",
                    "arôme naturel"
                ),
                listOf(),
                listOf(),
                12
            ),
            Product(
                "Petits pois et carottes",
                "Cassegrain",
                "3083680085304",
                "E",
                "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
                "400 g (280 g net égoutté)",
                listOf("France", "Japon", "Suisse"),
                listOf(
                    "Petits pois 66%",
                    "eau",
                    "garniture 2,8% (salade, oignon grelot)",
                    "sucre",
                    "sel",
                    "arôme naturel"
                ),
                listOf(),
                listOf(),
                12
            )
        )
        list.adapter = ProductAdapter(products)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.barcode) {
            //TODO OUVRIR LE LECTEUR DE CODE BARRE
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}




