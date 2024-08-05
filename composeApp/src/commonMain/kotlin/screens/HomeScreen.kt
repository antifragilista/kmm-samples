package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    // Column의 부모 요소로 maxWidth를 사용
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 버튼 너비를 fillMaxWidth로 설정하여 모든 버튼의 너비를 동일하게 설정
        Button(
            onClick = { navController.navigate("column") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Column Sample")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate("row") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Row Sample")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate("columnAndRow") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Column And Row Sample")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate("animatedVisibility") },
            modifier = Modifier.fillMaxWidth() // 부모 요소의 전체 너비를 차지하도록 설정
        ) {
            Text("AnimatedVisibility Sample")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate("bottomNavigation") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Bottom Navigation Sample")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate("list") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("List Sample")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate("imagePicker") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Image Picker Sample")
        }
    }
}
