package com.example.yuka.screens.list

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yuka.R
//import com.example.yuka.model.NutritionFactsItem
import com.example.yuka.model.Product
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_products_list.*

class ProductsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_products_list)

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
//                NutritionFactsItem(
//                    "kj",
//                    0.57,
//                    293
//                )
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
//                NutritionFactsItem(
//                    "kCal",
//                    (1..600).shuffled().first(),
//                    (1..600).shuffled().first()
//                )
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
//            NutritionFactsItem(
//                "gramme",
//                (1..600).shuffled().first(),
//                (1..600).shuffled().first()
//            )
        )
        list.adapter = ProductAdapter(products)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.barcode) {

            val intent = Intent("com.google.zxing.client.android.SCAN")
            intent.putExtra("SCAN_FORMATS", "EAN_13")
            startActivityForResult(intent, 100)

            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            data.getStringExtra("SCAN_RESULT_FORMAT")
            data.getStringExtra("SCAN_RESULT")

        }
    }
}




