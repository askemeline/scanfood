package com.example.yuka

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list.*
import kotlinx.android.synthetic.main.product_detail.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail)


        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))
        val product = Product(
            "Petits pois et carottes",
            "Cassegrain",
            "3083680085304",
            "A",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            "400 g (280 g net égoutté)",
            listOf("France", "Japon", "Suisse"),
            listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
            listOf("Aucun"),
            listOf("Aucune")
        )

        Toast.makeText(this, "Hello World!", Toast.LENGTH_LONG).show();
        setContentView(R.layout.product_detail)
        description_product.text = product.name
        mark.text = product.mark
        title_bar_code.text = product.barCode


        title_bar_code.setTitleValue("Code barres : ", product.barCode)
        title_quantity.setTitleValue("Quantité:", product.quantity)

        title_ingredient.text = product.ingredient.joinToString(separator = ", ")
        title_ingredient.setTitleValue("Ingredients : ", formatList(product.ingredient))

        title_from.text = product.countryFrom.joinToString(separator = ", ")
        title_from.setTitleValue("Vendu en : ", formatList(product.countryFrom))

        title_allergen.text = product.allergen.joinToString(separator = ", ")
        title_allergen.setTitleValue("Substances allergènes : ", formatList(product.allergen))

        title_addictifs.text = product.addictif.joinToString(separator = ", ")
        title_addictifs.setTitleValue("Addictifs : ", formatList(product.addictif))


        val nutriscore = "B"

        nutriscore_img.setImageResource(
            resources.getIdentifier(
                "nutriscore${nutriscore.toLowerCase()}",
                "drawable",
                packageName
            )
        )
        Picasso.get().load(product.imgUrl).into(url_image)


        list.layoutManager = LinearLayoutManager(this)
        val products = listOf(Product(
            "Petits pois et carottes",
            "Cassegrain",
            "3083680085304",
            "A",
            "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            "400 g (280 g net égoutté)",
            listOf("France", "Japon", "Suisse"),
            listOf("Petits pois 66%", "eau", "garniture 2,8% (salade, oignon grelot)", "sucre", "sel", "arôme naturel"),
            listOf("Aucun"),
            listOf("Aucune")        ))
        list.adapter = ProductAdapter(products)

    }


    fun formatList(list: List<String>): String {
        return if (list.isEmpty()) {
            getString(R.string.empty_ingredient)
        } else {
            list.joinToString(separator = ",")
        }
    }
}

fun TextView.setTitleValue(title: String, value: String) {
    text = SpannableString("$title $value").apply {
        setSpan(StyleSpan(Typeface.BOLD), 0, title.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
    }
}

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
    val addictif: List<String>
)





