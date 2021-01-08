package `in`.techrova.kmmapplication.androidApp

import `in`.techrova.kmmapplication.androidApp.databinding.ActivitySearchBinding
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.airbnb.epoxy.carousel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class SearchActivity : AppCompatActivity() {
    private lateinit var bn: ActivitySearchBinding
    val viewModel by viewModels<SearchActivityViewModel>()
    var progressDialog : ProgressDialog? = null
    val scope = CoroutineScope(Job() + Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bn = ActivitySearchBinding.inflate(layoutInflater)
        progressDialog = ProgressDialog(this)
        progressDialog!!.setTitle("loading ...")
        setContentView(bn.root)
        initViews()
        subscribeData()
    }

    private fun initViews() {
        bn.searchBar.setOnSearchClickListener {
            bn.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    subscribeData(1,query!!)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                   return false
                }

            })
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
                        val json = Json.encodeToString(it[0])

                        Log.d(
                            this@SearchActivity.javaClass.simpleName,
                            "subscribeData: ${it[0].description}"
                        )
                        bn.epoxy.clearPreloaders()
                        bn.epoxy.clear()

                        bn.epoxy.withModels {
                        it.forEach {
                            searchItem {
                                id(it.id)
                                job(it)
                                onclick(View.OnClickListener {v ->
                                  val json = Json.encodeToString(it)
                                    val intent = Intent (this@SearchActivity,DetailActivity::class.java)
                                    intent.putExtra("json",json)
                                    startActivity(intent)

                                })

                            }
                        }
                    }
                }
            }
        }
    }
}}