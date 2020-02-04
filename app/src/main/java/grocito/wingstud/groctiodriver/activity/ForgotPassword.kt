package grocito.wingstud.groctiodriver.activity

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.google.android.gms.common.api.CommonStatusCodes
import grocito.wingstud.groctiodriver.App
import grocito.wingstud.groctiodriver.R
import grocito.wingstud.groctiodriver.account.AccountManager
import grocito.wingstud.groctiodriver.databinding.ActivityForgotPasswordBinding
import grocito.wingstud.groctiodriver.extensions.defaultSharedPreferences
import grocito.wingstud.groctiodriver.extensions.putString
import grocito.wingstud.groctiodriver.response.CommanResponse
import grocito.wingstud.groctiodriver.response.SessionResponse
import grocito.wingstud.groctiodriver.rest.network.RestClient
import grocito.wingstud.groctiodriver.rest.responses.LoginResponse
import grocito.wingstud.groctiodriver.util.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPassword : AppCompatActivity() {


    lateinit var binding : ActivityForgotPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_forgot_password)

        binding.btnSubmit.setOnClickListener { forgotPassword() }
    }

    fun forgotPassword(){

        val hashMap: HashMap<String, String> = HashMap()
        hashMap["mobile"] = binding.etMobileNo.text.toString();

        RestClient.getInstance().apiInterface.forgotPassword(hashMap).enqueue(object : Callback<CommanResponse> {
            override fun onFailure(call: Call<CommanResponse>, t: Throwable) {
//                dialog.dismiss()
                toast("Network connection error.")
                Log.e(ContentValues.TAG, "onFailure", t);
            }

            override fun onResponse(call: Call<CommanResponse>, response: Response<CommanResponse>) {
//                dialog.dismiss()
                if (response.isSuccessful ) {
                    val body = response.body()!!
                    if(response.body()!!.status_code == 1){
                        toast( response.body()!!.message!!)
                        finish()
                    }

                } else {
//                    if (response.body() != null && response.body()!!.message != null)
                    toast( response.body()!!.message!!)
//                    else context?.toast( response.body()!!.message!!)
                }
            }
        })
    }
}
