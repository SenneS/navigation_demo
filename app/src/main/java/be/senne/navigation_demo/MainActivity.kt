package be.senne.navigation_demo

import android.R.attr
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import be.senne.navigation_demo.compose.createChatsList
import be.senne.navigation_demo.model.ChatPreviewData
import be.senne.navigation_demo.ui.theme.Navigation_demoTheme
import java.nio.ByteBuffer


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myResources = resources

        setContent {
            Navigation_demoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //createChatsList(items)
                    createMainScreen()
                }
            }
        }
    }

    companion object {
        lateinit var myResources : Resources
    }

}

fun hexStringToBytes(str : String) : ByteArray {
    var str = str.filter { !it.isWhitespace() }
    return str.chunked(2).map { it.toUByte(16).toByte() }.toByteArray()
}

@Composable
fun createMainScreen() {
    val tabs = listOf("chatsScreen", "contactsScreen", "settingsScreen")
    val tabIdx = remember { mutableStateOf(0) }
    Scaffold(topBar = {
        TabRow(selectedTabIndex = tabIdx.value, Modifier.padding(20.dp)) {
            tabs.forEachIndexed { index, s ->
                Tab(selected = index == tabIdx.value, onClick = { tabIdx.value = index }) {
                    Text(text = s, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
    }) { padding -> Column(modifier = Modifier.padding(padding)) {
        when(tabs[tabIdx.value]) {
            "chatsScreen" -> {
                createChatsScreen()
            }
            "contactsScreen" -> {
                createContactsScreen()
            }
            "settingsScreen" -> {
                createSettingsScreen()
            }
        }
    }
    }
}

@Composable
fun createChatsScreen() {
    val bitmap = BitmapFactory.decodeResource(MainActivity.myResources, R.drawable.profile_image)
    var items = ArrayList<ChatPreviewData>()
    for(i in 0 until 100) {
        items.add(ChatPreviewData("Gebruiker $i", "Bericht $i", bitmap))
    }
    createChatsList(list = items)
}

@Composable
fun createContactsScreen() {
    Text("ContactsScreen")
}

@Composable
fun createSettingsScreen() {
    Text("SettingsScreen")
}