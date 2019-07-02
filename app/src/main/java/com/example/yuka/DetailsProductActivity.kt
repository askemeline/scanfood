package com.example.yuka

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.list_item_cell.view.*
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


        setContentView(R.layout.fragment_first)
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
        val product = arguments?.getParcelable< Product >("product")

//        on bind le product à la vue
//        ex: product_name.text= product.name
        view.description_product.text = product?.name
    }

}