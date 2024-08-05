import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class NavigationItem(
    val name: String,
    val icon: ImageVector
)

@Composable
fun BottomNavigationScreen() {
    val items = listOf(
        NavigationItem("Home", Icons.Default.Home),
        NavigationItem("Search", Icons.Default.Search),
        NavigationItem("Settings", Icons.Default.Settings)
    )

    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My App") },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                elevation = 12.dp
            )
        },
        bottomBar = {
            BottomNavigation {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = { Icon(item.icon, contentDescription = item.name) },
                        label = { Text(item.name) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Add action */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        drawerContent = {
            Text("Drawer Content")
        },
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding).fillMaxSize()
        when (selectedItem) {
            0 -> HomeScreen(modifier)
            1 -> SearchScreen(modifier)
            2 -> SettingsScreen(modifier)
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier) {
    Text("Home Screen", modifier = modifier, fontSize = 24.sp)
}

@Composable
fun SearchScreen(modifier: Modifier) {
    Text("Search Screen", modifier = modifier, fontSize = 24.sp)
}

@Composable
fun SettingsScreen(modifier: Modifier) {
    Text("Settings Screen", modifier = modifier, fontSize = 24.sp)
}
