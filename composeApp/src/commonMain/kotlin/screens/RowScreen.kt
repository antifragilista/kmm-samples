package screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Row는 수평으로 자식 컴포저블을 배치합니다.
// 각 자식은 왼쪽에서 오른쪽으로 나란히 배치되며, horizontalArrangement와 verticalAlignment를 통해 자식 컴포저블의 정렬을 제어할 수 있습니다.

@Composable
fun RowScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), // Row의 모든 자식들에게 16dp의 패딩을 줍니다.
        horizontalArrangement = Arrangement.SpaceBetween, // 자식들을 수평 방향으로 균일하게 배치합니다.
        verticalAlignment = Alignment.CenterVertically // 자식들을 수직 방향으로 중앙에 정렬합니다.
    ) {
        // 자식 컴포저블들
        Text("First item")
        Text("Second item")
        Button(onClick = {}) {
            Text("Third item")
        }
    }
}
