package grocito.wingstud.groctiodriver.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import grocito.wingstud.groctiodriver.R
import grocito.wingstud.groctiodriver.extensions.inflate
import grocito.wingstud.groctiodriver.response.Data
import kotlinx.android.synthetic.main.order_details_item.view.*

class OrderDetailsAdapter(private val context: Context, private val orderdetailList: List<Data>) : RecyclerView.Adapter<OrderDetailsAdapter.ViewHolder>() {
//    var orderdetailList : List<Data> = emptyList()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.order_details_item))
    }

    override fun getItemCount(): Int {
        return orderdetailList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ordetailModel = orderdetailList[position]
//        holder.bind(ordetailModel)
        holder.itemView.nameTv.text = ordetailModel.name
        holder.itemView.price_tv.text = String.format("₹ %.2f", ordetailModel.price)
        holder.itemView.qty_tv.text = String.format("Qty : ${ordetailModel.qty}")
        holder.itemView.weight_tv.text = String.format("Weight : ${ordetailModel.weight}")

        if (ordetailModel.return_status === 1) {
            holder.itemView.statusTv.setVisibility(View.VISIBLE)
            holder.itemView.statusTv.setText("Item Retuned")
        }
//        else if (ordetailModel.exchange_status === 1) {
//            holder.itemView.statusTv.setVisibility(View.VISIBLE)
//            holder.itemView.statusTv.setText("Item Exchanged")
//        }
        else {
            holder.itemView.statusTv.setVisibility(View.GONE)
        }

        Glide.with(context).load("https://www.grocito.com/public/admin/uploads/product/" + ordetailModel.image).into(holder.itemView.productImage)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}