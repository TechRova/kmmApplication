package `in`.techrova.kmmapplication.shared

import android.widget.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.*
actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT} ${EditText.ACCESSIBILITY_LIVE_REGION_ASSERTIVE}"

}