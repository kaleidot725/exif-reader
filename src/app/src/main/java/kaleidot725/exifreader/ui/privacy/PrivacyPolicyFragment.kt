package kaleidot725.exifreader.ui.privacy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.PrivacyPolicyFragmentBinding
import kaleidot725.exifreader.extention.dataBinding

class PrivacyPolicyFragment : Fragment(R.layout.privacy_policy_fragment) {
    private val _binding: PrivacyPolicyFragmentBinding? by dataBinding()
    private val binding: PrivacyPolicyFragmentBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        binding.webView.apply {
            loadUrl(getString(R.string.privacy_policy_url))
            settings.textZoom = 65
        }
    }
}
