package kaleidot725.exifreader.ui

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kaleidot725.exifreader.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PrivacyPolicyActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_privacy_policy)
        CoroutineScope(Dispatchers.Main).launch {
            val webView = findViewById<WebView>(R.id.webview)
            webView.loadUrl(getString(R.string.privacy_policy_url))
            webView.settings.textZoom = 65
        }
    }
}
