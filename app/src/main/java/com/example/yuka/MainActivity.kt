package com.example.yuka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.product_detail.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getString(R.string.app_name, 2, "hello")

        //resources.getQuantityString(R.plurals.users, 1)
        //resources.getQuantityString(R.plurals.users, 10)

        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.toolbar))

        Toast.makeText(this, "Hello World!" , Toast.LENGTH_LONG).show();
        setContentView(R.layout.product_detail)
        description_product.text="hello"
        nutriscore.setImageResource(R.drawable.nutriscorea)
    }
}
