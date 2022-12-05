package be.senne.navigation_demo

import android.R.attr
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import be.senne.navigation_demo.compose.createChatsList
import be.senne.navigation_demo.model.ChatPreviewData
import be.senne.navigation_demo.ui.theme.Navigation_demoTheme
import java.nio.ByteBuffer


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            Navigation_demoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val bitmap = BitmapFactory.decodeResource(resources, R.drawable.profile_image)
                    var items = ArrayList<ChatPreviewData>()
                    for(i in 0 until 100) {
                        items.add(ChatPreviewData("Gebruiker $i", "Bericht $i", bitmap))
                    }
                    createChatsList(items)
                }
            }
        }
    }
}

fun hexStringToBytes(str : String) : ByteArray {
    var str = str.filter { !it.isWhitespace() }
    return str.chunked(2).map { it.toUByte(16).toByte() }.toByteArray()
}

@Composable
fun createMainScreen() {
    val navController = rememberNavController()
/*
    NavHost(navController = navController, startDestination = "chatScreen") {
        composable("chatsScreen") {
            val myViewModel = viewModel()
            createChatsScreen()
        }

        composable("contactsScreen") {
            createContactsScreen()
        }

        composable("settingsScreen") {
            createSettingsScreen()
        }
    }
*/
}

@Composable
fun createChatsScreen() {

}

@Composable
fun createContactsScreen() {

}

@Composable
fun createSettingsScreen() {

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Navigation_demoTheme {
        Greeting("Android")
    }
}