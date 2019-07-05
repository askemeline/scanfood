package com.example.yuka.screens.list

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.yuka.model.Product
import com.example.yuka.screens.details.ProductFragment

class ProductDetailsAdapter(fm: FragmentManager, val product: Product) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return ProductFragment.newInstance(product)
        /*return when (position) {
            0 -> ProductFragment()
//            1 -> Fragment1()
//            2 -> Fragment2()
            else -> throw Exception("Unknown position")
        }*/

    }

    // Le nombre d'onglets à afficher
    override fun getCount(): Int = 3

    // Le titre à afficher dans l'onglet selon la position
    // TODO Utiliser des ressources
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Fiche"
            1 -> "Nutrition"
            2 -> "Infos nutritionnelles"
            else -> throw Exception("Unknown position")
        }
    }

}