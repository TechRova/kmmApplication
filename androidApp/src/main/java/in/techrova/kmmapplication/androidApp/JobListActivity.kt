package `in`.techrova.kmmapplication.androidApp

import `in`.techrova.kmmapplication.androidApp.databinding.ActivityJobListBinding
import `in`.techrova.kmmapplication.shared.data.TestActExp
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.airbnb.epoxy.carousel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class JobListActivity : AppCompatActivity() {

    private lateinit var bn: ActivityJobListBinding

    val viewModel by viewModels<JobListActivityViewModel>()
    val scope = CoroutineScope(Job() + Dispatchers.Main)
    var progressDialog : ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bn = ActivityJobListBinding.inflate(layoutInflater)
        setContentView(bn.root)
        progressDialog = ProgressDialog(this)
        progressDialog!!.setTitle("loading ...")
        subscribeData()
        initViews()
    }

    private fun initViews() {
        bn.searchBar.setOnClickListener {
            startActivity(Intent(this,SearchActivity::class.java))
        }

        bn.java.setOnClickListener {
            subscribeData(1, "java")
        }

        bn.kotlin.setOnClickListener {
            subscribeData(1, "kotlin")
        }

        bn.python.setOnClickListener {
            subscribeData(1, "python")
        }
    }

    private  fun subscribeData(page: Int = 1 , query: String = "python") {
        progressDialog!!.show()


        scope.launch {
            withContext(Dispatchers.IO) {
            viewModel.getJobByPage(page,query).collect {
                withContext(Dispatchers.Main) {
                    progressDialog!!.dismiss()

                    Log.d(
                        this@JobListActivity.javaClass.simpleName,
                        "subscribeData: ${it[0].description}"
                    )

                    bn.epoxy.withModels {
                        carousel {
                            id(1001)
                            models(it.map {
                                JobItemBindingModel_()
                                    .id(it.id)
                                    .job(it)
                            })


                        }
                    }

                }
            }
            }
        }
    }
}