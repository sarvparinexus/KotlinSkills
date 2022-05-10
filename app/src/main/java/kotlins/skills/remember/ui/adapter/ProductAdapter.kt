package kotlins.skills.remember.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlins.skills.remember.R
import kotlins.skills.remember.api.models.users.DataItem
import kotlinx.android.synthetic.main.product_row.view.*

class ProductsAdapter(
    private val products: List<DataItem>
) : androidx.recyclerview.widget.RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.title.text = product.firstName
        holder.price.text = product.email.toString()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = products.size

    class ViewHolder(itemView: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)
        val saleImageView = itemView.saleImageView
    }
}