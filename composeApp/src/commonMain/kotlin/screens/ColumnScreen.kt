package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Column은 수직으로 자식 컴포저블을 배치합니다.
// 각 자식은 위에서 아래로 쌓이게 되며, verticalArrangement와 horizontalAlignment를 통해 자식 컴포저블의 정렬을 제어할 수 있습니다.

@Composable
fun ColumnScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Column의 모든 자식들에게 16dp의 패딩을 줍니다.
        verticalArrangement = Arrangement.SpaceEvenly, // 자식들을 수직 방향으로 균일하게 배치합니다.
        horizontalAlignment = Alignment.CenterHorizontally // 자식들을 수평 방향으로 중앙에 정렬합니다.
    ) {
        // 자식 컴포저블들
        Text("First item")
        Text("Second item")
        Button(onClick = {}) {
            Text("Third item")
        }
    }
}
