package layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.wai.myapplication.databinding.SplashLayoutBinding


class SplashFragment : Fragment() {

    private lateinit var binding: SplashLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SplashLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    // La view est crée

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mbNavigation.setOnClickListener{
            // Récupère la valeur saisie après le click du bouton
            val name = binding.etName.text.toString()

            // Condition pour ne valider que un nom non null
            if(!name.isNullOrBlank()){
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment(name))
            }else{
                Toast.makeText(requireContext(), "Veuillez entrer votre nom", Toast.LENGTH_LONG).show()
            }


        }

    }


}