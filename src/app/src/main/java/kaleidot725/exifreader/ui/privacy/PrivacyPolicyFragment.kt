package kaleidot725.exifreader.ui.privacy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kaleidot725.exifreader.R
import kaleidot725.exifreader.databinding.PrivacyPolicyFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PrivacyPolicyFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return DataBindingUtil.inflate<PrivacyPolicyFragmentBinding>(
            inflater,
            R.layout.privacy_policy_fragment,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            val webView = view.findViewById<WebView>(R.id.web_view)
            webView.loadUrl(getString(R.string.privacy_policy_url))
            webView.settings.textZoom = 65
        }
    }
}
