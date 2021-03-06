package com.example.yuka.screens.list

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yuka.screens.details.DetailsProductActivity
import com.example.yuka.R
import com.example.yuka.model.Product
import com.example.yuka.utils.setTitleValue
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.products_list_item_cell.view.*

class ProductAdapter(val products: List<Product>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProductItemCell(
            LayoutInflater.from(parent.context).inflate(
                R.layout.products_list_item_cell,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductItemCell).bindProduct(products[position])    }

}

class ProductItemCell(v: View) : RecyclerView.ViewHolder(v) {
    private val name: TextView = v.product_name
    private val picture: ImageView = v.product_image
    private val  nutriscore: TextView = v.title_nutriscore
    private val calorie: TextView = v.title_calorie
    private val mark: TextView = v.product_mark
    fun bindProduct(product: Product){
        name.text = product.name
        Picasso.get().load(product.imgUrl).into(picture)
        mark.text = product.mark
        calorie.text = product.calorie.toString()

        nutriscore.setTitleValue("Nutriscore : ", product.nutriscore)

        calorie.setTitleValue(product.calorie.toString()," kCal/part")


        itemView.setOnClickListener{
            val context = it.context
            val intent = Intent(context, DetailsProductActivity::class.java)
            intent.putExtra("product", product)
            context.startActivity(intent)
        }
    }
}
