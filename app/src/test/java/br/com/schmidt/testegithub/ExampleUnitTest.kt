package br.com.schmidt.testegithub

import br.com.schmidt.testegithub.ui.models.ItemRepository
import br.com.schmidt.testegithub.ui.models.ListRepositoriesObject
import br.com.schmidt.testegithub.ui.repositories.Repository
import br.com.schmidt.testegithub.retrofitInterface.RetrofitInterface
import br.com.schmidt.testegithub.ui.viewmodels.RepositoriesViewModel
import com.google.gson.Gson
import io.mockk.mockk
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

   // @Mock
   // lateinit var repository: Repository

    //lateinit var repositoriesViewModel: RepositoriesViewModel

    @InjectMocks
    lateinit var repository: Repository

    //val repository2: Repository = mockk()

    private lateinit var apiService: RetrofitInterface
    private lateinit var repositoriesViewModel: RepositoriesViewModel

    private var mockWebServer = MockWebServer()

    @Before
    fun setup(){
        mockWebServer.start()
        repositoriesViewModel = RepositoriesViewModel(TestApplication())
/*        apiService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(RetrofitInterface::class.java)*/
        val applicationMock = Mockito.mock(MyApplication::class.java)

//        repositoriesViewModel = RepositoriesViewModel(applicationMock)
    }

    @Test
    suspend fun addition_isCorrect() {
        Assert.assertEquals(1, 1)
        repositoriesViewModel.flow.collectLatest {

        }
        //getItemRepositories()
    }

    fun getItemRepositories(): ListRepositoriesObject {
        val file = ClassLoader.getSystemResource("RepositoryItens.json").readText()
        println(file)
        val list = Gson().fromJson(file, ListRepositoriesObject::class.java)
       // val owner = OwnerRepositoryObject(id = 1322134, avatar_url = "avatar_url", login = "login")
        return list
    }
}