package `in`.techrova.kmmapplication.androidApp

import `in`.techrova.kmmapplication.androidApp.databinding.ActivityDetailBinding
import `in`.techrova.kmmapplication.shared.data.model.github.GitHubJob
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class DetailActivity : AppCompatActivity() {
    private lateinit var bn: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bn = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(bn.root)
        setData()
    }

    private fun setData() {
        val json = intent.getStringExtra("json")
        bn.job = Json.decodeFromString<GitHubJob>(json)


    }
}