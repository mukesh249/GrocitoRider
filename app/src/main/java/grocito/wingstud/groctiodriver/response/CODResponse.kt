package grocito.wingstud.groctiodriver.response

data class CODResponse(
        val cod_list: List<Cod>,
        val error_message: String,
        val message: String,
        val status_code: Int
)

data class Cod(
        val amount_per_km: Int,
        val bonus: Int,
        val created_at: String,
        val delivery_boy_id: Int,
        val distance: Int,
        val id: Int,
        val is_cod_submitted: Int,
        val order: Order,
        val order_id: Int,
        val payment_mode: String,
        val seller_id: Int,
        val sub_order_id: Any,
        val type: String,
        val updated_at: String,
        val user_id: Int,
        val warehouse_id: Any
)

data class Order(
        val address_id: Int,
        val admin_commission: Double,
        val cashback_amount: Int,
        val created_at: String,
        val d_p_d_amount: Int,
        val delivery_boy_id: Int,
        val delivery_date: String,
        val delivery_time: String,
        val delivery_type: String,
        val distance: Int,
        val dock_no: String,
        val express_time: String,
        val extra_amount: Int,
        val gst_amount: Int,
        val id: Int,
        val is_cod_submitted: Int,
        val net_amount: Double,
        val ord_payment_id: String,
        val order_id: String,
        val payment_amount: Int,
        val payment_mode: String,
        val payment_status: String,
        val reason: String,
        val seller_id: Int,
        val sgst_amount: Double,
        val shipped_by: String,
        val shipped_date: String,
        val shipping_charge: Int,
        val status: String,
        val status_message: String,
        val total_amount: Int,
        val transaction_id: String,
        val updated_at: String,
        val user_id: Int,
        val wallet_amount: Int,
        val wallet_pay: Int,
        val wallet_use: Int,
        val warehouse_id: Int
)