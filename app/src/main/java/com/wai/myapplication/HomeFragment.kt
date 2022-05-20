package layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.wai.myapplication.R
import com.wai.myapplication.databinding.HomeLayoutBinding


class HomeFragment: Fragment() {

    private lateinit var binding: HomeLayoutBinding
    private val navArgs: HomeFragmentArgs by navArgs()
    private var count : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = HomeLayoutBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mbPlus.setOnClickListener(){

            count +=1
            binding.tvTitle.text = getString(R.string.bonjour_s_welcome_to_my_app, navArgs.name, count.toString())
        }

        binding.mbMoins.setOnClickListener(){
            count -=1
            binding.tvTitle.text = getString(R.string.bonjour_s_welcome_to_my_app, navArgs.name, count.toString())
        }

        binding.tvTitle.text = getString(R.string.bonjour_s_welcome_to_my_app, navArgs.name, count.toString())
    }
}