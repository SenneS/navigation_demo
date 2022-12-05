package be.senne.navigation_demo.compose

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import be.senne.navigation_demo.model.ChatPreviewData

@Composable
fun createChatsList(list: List<ChatPreviewData>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(list) { index, item ->
            Row() {
                Surface() {
                    Image(bitmap = item.afbeelding.asImageBitmap(), contentDescription = "Afbeelding")
                }
                Column() {
                    Text(item.naam)
                    Text(item.bericht)
                }
            }
        }
    }
}