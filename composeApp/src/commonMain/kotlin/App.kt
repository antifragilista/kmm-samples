import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import screens.AnimatedVisibilityScreen
import screens.ColumnAndRowScreen
import screens.ColumnScreen
import screens.HomeScreen
import screens.ListScreen
import screens.RowScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        // NavController 생성 및 기억
        val navController = rememberNavController()

        // NavHost를 통해 네비게이션 그래프 설정
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") { HomeScreen(navController) }
            composable("column") { ColumnScreen() }
            composable("row") { RowScreen() }
            composable("columnAndRow") { ColumnAndRowScreen() }
            composable("animatedVisibility") { AnimatedVisibilityScreen() }
            composable("bottomNavigation") { BottomNavigationScreen() }
            composable("list") { ListScreen() }
            composable("imagePicker") { ImagePickerScreen() }
        }
    }
}