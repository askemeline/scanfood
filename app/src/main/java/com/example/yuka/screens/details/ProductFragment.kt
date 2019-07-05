package com.example.yuka.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yuka.R
import com.example.yuka.model.Product
import com.example.yuka.utils.setTitleValue
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_product_detail.view.*

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
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        on recupere le produit envoyé au Fragment
        val product = arguments?.getParcelable<Product>("product")

//        on bind le product à la vue
//        ex: product_name.text= product.name
        view.description_product.text = product?.name
        view.mark.text = product?.mark
        view.title_ingredient.text = product?.ingredient?.joinToString(separator = ", ")
        view.title_ingredient.setTitleValue("Ingredients : ", formatList(product!!.ingredient))
        view.description_product.text = product.name
        view.mark.text = product.mark
        view.title_bar_code.text = product.barCode


        view.title_bar_code.setTitleValue("Code barres : ", product.barCode)
        view.title_quantity.setTitleValue("Quantité:", product.quantity)


        view.title_from.text = product.countryFrom.joinToString(separator = ", ")
        view.title_from.setTitleValue("Vendu en : ", formatList(product.countryFrom))

        view.title_allergen.text = product.allergen.joinToString(separator = ", ")
        view.title_allergen.setTitleValue("Substances allergènes : ", formatList(product.allergen))

        view.title_addictifs.text = product.addictif.joinToString(separator = ", ")
        view.title_addictifs.setTitleValue("Addictifs : ", formatList(product.addictif))


        val nutriscore = "B"

        view.nutriscore_img.setImageResource(
            resources.getIdentifier(
                "nutriscore${nutriscore.toLowerCase()}",
                "drawable",
                context?.getPackageName()
            )
        )

        Picasso.get().load(product.imgUrl).into(view.url_image)

    }

    fun formatList(list: List<String>): String {
        return if (list.isEmpty()) {
            getString(R.string.empty_ingredient)
        } else {
            list.joinToString(separator = ",")
        }
    }


}