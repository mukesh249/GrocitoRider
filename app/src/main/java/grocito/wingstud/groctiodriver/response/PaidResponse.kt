package grocito.wingstud.groctiodriver.response

data class PaidResponse(
        val `data`: List<Data>,
        val message: String,
        val status_code: Int
) {
    data class Data(

            val amount_per_km: Int,
            val base_income: Int,
            val bonus: Int,
            val cod_total: Double,
            val from_date: String,
            val payable: Double,
            val payment_id: String,
            val to_date: String,
            val total: Double,
            val total_count: Int,
            val total_days: Int,
            val total_distance: Double

//            val amount: Int,
//            val cod: Int,
//            val created_at: String,
//            val deduction: Int,
//            val delivery_boy_id: Int,
//            val description: String,
//            val distance: String,
//            val distance_wise_amount: Int,
//            val grocito_fee: Double,
//            val id: Int,
//            val no_of_days: Int,
//            val order_count: Int,
//            val payment_amount: Double,
//            val payment_slot: PaymentSlot,
//            val payment_slot_id: String,
//            val slip: String,
//            val transaction_id: String,
//            val updated_at: String
    ) {
        data class PaymentSlot(
                val created_at: String,
                val from_date: String,
                val id: Int,
                val to_date: String,
                val updated_at: String
        )
    }
}