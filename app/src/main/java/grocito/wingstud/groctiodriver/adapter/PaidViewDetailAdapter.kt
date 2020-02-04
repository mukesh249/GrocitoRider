package grocito.wingstud.groctiodriver.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import grocito.wingstud.groctiodriver.R
import grocito.wingstud.groctiodriver.activity.DeliveryProductDetail
import grocito.wingstud.groctiodriver.extensions.inflate
import grocito.wingstud.groctiodriver.response.PaymentViewResponse
import kotlinx.android.synthetic.main.payement_view_details.view.*


class PaidViewDetailAdapter(private val context: Context, private val clubList: List<PaymentViewResponse.Data>) :
        RecyclerView.Adapter<PaidViewDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(viewGroup.inflate(R.layout.payement_view_details))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val paidA = clubList[position]
        holder.bind(paidA)
        holder.itemView.let {
            if (position % 2 == 0) {
                it.backLL.setBackgroundColor(context.resources.getColor(R.color.light_gray))
            } else {
                it.backLL.setBackgroundColor(context.resources.getColor(R.color.white))
            }
            it.snoTv.text = "${(position + 1)}"
            it.orderIdTv.text = paidA.order_id
            if (paidA.order_amount != null)
                it.AmtTv.text = String.format("%.2f", paidA.order_amount.toDouble())
            it.distanceTv.text = "${paidA.distance}"
            it.paymentModeTv.text = paidA.payment_mode
            it.typeTv.text = paidA.type
            it.bonustv.text = "${paidA.bonus}"


            var tdate = paidA.date
//            var tspf = SimpleDateFormat("yyyy-mm-dd")
//            val tnewDate = tspf.parse(tdate)
//            tspf = SimpleDateFormat("dd/mm/yyyy")
//            tdate = tspf.format(tnewDate)
            it.datetime_Tv.text = tdate

//            var date = paidA.date
//            var spf = SimpleDateFormat("yyyy-MM-dd")
//            val newDate = spf.parse(date)
//            spf = SimpleDateFormat("dd/MM/yyyy")
//            date = spf.format(newDate)
//            println(date)
//            it.datetime_Tv.text = date
        }

    }

    override fun getItemCount(): Int {
        return clubList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var context: Context
        fun bind(order: PaymentViewResponse.Data) {
            context = super.itemView.context
            itemView.actionTv.setOnClickListener {
                // todayOrderInterface.viewDetail(order)
                // Move to AnotherActivity
                ContextCompat.startActivity(this.context,
                        Intent(this.context, DeliveryProductDetail::class.java)
                                .apply {
                                    putExtra("order_id", order.id)
                                    putExtra("seller_id", order.seller_id)
                                }
                        ,
                        null)
            }
        }
    }

}