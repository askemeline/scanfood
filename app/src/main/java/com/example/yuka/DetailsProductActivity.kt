package com.example.yuka

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_detail.*
import kotlinx.android.synthetic.main.product_detail.view.*

class DetailsProductActivity : AppCompatActivity() {

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


        setContentView(R.layout.detail_fragment)
        supportFragmentManager.beginTransaction()
            .replace(R.id.detail_with_fragment, ProductFragment.newInstance(product)).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}

class ProductFragment : Fragment() {
    //la maniere de donner à un Fragment des arguments
    companion object {
        fun newInstance(product: Product): ProductFragment {
            val fragment = ProductFragment()
            val args = Bundle()
            args.putParcelable("product", product)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        donner le layout de la vue de details
        return inflater.inflate(R.layout.product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        on recupere le produit envoyé au Fragment
        val product = arguments?.getParcelable<Product>("product")

//        on bind le product à la vue
//        ex: product_name.text= product.name
        view.description_product.text = product?.name
        view.mark.text = product?.mark
        title_ingredient.text = product?.ingredient?.joinToString(separator = ", ")
        title_ingredient.setTitleValue("Ingredients : ", formatList(product!!.ingredient))
        description_product.text = product.name
        mark.text = product.mark
        title_bar_code.text = product.barCode


        title_bar_code.setTitleValue("Code barres : ", product.barCode)
        title_quantity.setTitleValue("Quantité:", product.quantity)


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
                context?.getPackageName()
            )
        )

        Picasso.get().load(product.imgUrl).into(url_image)

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