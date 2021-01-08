package `in`.techrova.kmmapplication.androidApp

import `in`.techrova.kmmapplication.shared.data.model.github.GitHubJob
import `in`.techrova.kmmapplication.shared.repo.GitHubRepo
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

class JobListActivityViewModel : ViewModel() {

    fun getJobByPage (page: Int, query: String): Flow<List<GitHubJob>> {
        return GitHubRepo().getJobByPage(page,query)
    }
}