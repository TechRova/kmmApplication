package `in`.techrova.kmmapplication.androidApp

import `in`.techrova.kmmapplication.androidApp.databinding.ActivityMainBinding
import `in`.techrova.kmmapplication.shared.Greeting
import `in`.techrova.kmmapplication.shared.MathCalc
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.*

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    private lateinit var bn: ActivityMainBinding
    val scope = CoroutineScope(Job() + Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bn = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bn.root)


        bn.add.setOnClickListener {

          //  calcAndGet()
            startActivity(Intent(this,JobListActivity::class.java))

        }
    }

    private fun calcAndGet() {
        bn.textView.text = MathCalc.add(bn.num1.toInt(), bn.num2.toInt()).toString()
        scope.launch {
            val html = withContext(Dispatchers.IO) {
                MathCalc().getApi()
            }
            withContext(Dispatchers.Main) {
                bn.name.text = html.results[0].name?.first + " " + html.results[0].name?.last
            }
        }
        /*            runBlocking {
                        withContext(Dispatchers.IO) {
                            val html = MathCalc().getApi()
                            Log.d(
                                this@MainActivity.javaClass.simpleName,
                                "onCreate: ${html.results[0].name}"
                            )
                            bn.name.text = html.results[0].name?.first + " " + html.results[0].name?.last
        *//*                    val nt : NetworkStatus
                        when(nt){
                            is NetworkStatus.Loading -> TODO()
                            is NetworkStatus.CustomSignal -> TODO()
                            is NetworkStatus.CustomSignalDetailed -> TODO()
                            is NetworkStatus.Failure -> TODO()
                            is NetworkStatus.Data<* > -> {
                                val data = nt.data as MathCalc
                                data.client
                            }
                        }*//*

                    }
                }*/
    }

    fun EditText.toInt(): Int? {
        return this.text.toString().toIntOrNull()
    }
}
