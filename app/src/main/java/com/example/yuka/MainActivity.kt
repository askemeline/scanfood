package com.example.yuka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.list.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list)

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


@Parcelize

data class Product(
    val name: String,
    val mark: String,
    val barCode: String,
    val nutriscore: String,
    val imgUrl: String,
    val quantity: String,
    val countryFrom: List<String>,
    val ingredient: List<String>,
    val allergen: List<String>,
    val addictif: List<String>,
    val calorie: Int
) : Parcelable {

}




