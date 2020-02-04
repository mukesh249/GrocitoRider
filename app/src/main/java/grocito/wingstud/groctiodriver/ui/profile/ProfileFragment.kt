package grocito.wingstud.groctiodriver.ui.profile


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import grocito.wingstud.groctiodriver.R
import grocito.wingstud.groctiodriver.account.AccountManager
import grocito.wingstud.groctiodriver.activity.MainActivity
import grocito.wingstud.groctiodriver.databinding.FragmentProfile2Binding
import grocito.wingstud.groctiodriver.extensions.defaultSharedPreferences
import grocito.wingstud.groctiodriver.util.setProfileImage


class ProfileFragment : Fragment() {

    private val session by lazy { AccountManager.getUserAccount()!! }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding : FragmentProfile2Binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile2, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Profile"
        context?.setProfileImage( session.profile_image,binding.avatarIv)

        Log.d("profile_imge",defaultSharedPreferences.getString("ImagePath","")+ session.profile_image);
        binding.nameTv.text = session.username
        binding.mobTv.text = session.mobile
        binding.emailTv.text = session.email
        binding.employeeId.text = session.employeeNo
        return binding.root
    }



}
