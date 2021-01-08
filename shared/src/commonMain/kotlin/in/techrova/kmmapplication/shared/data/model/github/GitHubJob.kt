package `in`.techrova.kmmapplication.shared.data.model.github

import kotlinx.serialization.Serializable

@Serializable
data class GitHubJob (

    val id : String?,
    val type : String?,
    val url : String?,
    val created_at : String?,
    val company : String?,
    val company_url : String?,
    val location : String?,
    val title : String?,
    val description : String?,
    val how_to_apply : String?,
    val company_logo : String?
)
