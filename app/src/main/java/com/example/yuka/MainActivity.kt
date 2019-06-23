package com.example.yuka

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_detail.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail)


        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))

        Toast.makeText(this, "Hello World!" , Toast.LENGTH_LONG).show();
        setContentView(R.layout.product_detail)
        description_product.text = product.name
        mark.text = product.mark
        title_bar_code.text = product.barCode


        nutriscore.setImageResource(R.drawable.nutriscorea)


        Picasso.get().load(product.imgUrl).into(url_image)
    }
}



class Product(
    val name: String,
    val mark: String,
    val barCode: String,
    val nutriscore: String,
    val imgUrl: String,
    val quantity: String,
    val countryFrom: List<String>,
    val ingredient: List<String>,
    val allergen: List<String>,
    val addictif: List<String>
)


val product = Product(
    "Petits pois et carottes\n",
    "Cassegrain",
    "Code barres : 3083680085304",
    "A",
    "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
    "Quantité : 400 g (280 g net égoutté)",
    listOf("Vendu en : ","France", "Japon", "Suisse"),
    listOf("Ingrédients : ","Petits pois 66%, eau, garniture 2,8% (salade, oignon grelot), sucre, sel, arôme naturel"),
    listOf("Substances allergènes :", "Aucun"),
    listOf("Additifs : ","Aucune"))


