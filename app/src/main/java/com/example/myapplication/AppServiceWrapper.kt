import com.example.myapplication.AppService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppServiceWrapper @Inject constructor(private val appService: AppService) {
    private suspend fun <T> ioContextExecutor(block: suspend () -> T): T? = withContext(Dispatchers.IO) {
        try {
            block()
        } catch (ex: Exception) {
            Timber.e(ex)
            null
        }
    }
}