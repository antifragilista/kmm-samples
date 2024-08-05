package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme



@Composable
fun ListScreen() {
    val itemList = (1..50).map { "Item #$it" }

    Column {
        // LazyRow를 사용하여 가로 스크롤을 구현
        LazyRow(
//            modifier = Modifier.fillMaxSize()
            modifier = Modifier.fillMaxWidth().height(120.dp)
        ) {
            item {
                Text(
                    text = "Section Header",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
            items(itemList) { item ->
                // 각 아이템을 Card로 감싸서 표시
                Card(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(8.dp),
                    elevation = 4.dp
                ) {
                    // 아이템의 텍스트를 표시
                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
        LazyColumn(
//            modifier = Modifier.fillMaxSize()
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            item {
                Text(
                    text = "Section Header",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
            // 리스트의 각 아이템을 순회
            items(itemList) { item ->
                // 각 아이템을 Card로 감싸서 표시
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = 4.dp
                ) {
                    // 아이템의 텍스트를 표시
                    Text(
                        text = item,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}