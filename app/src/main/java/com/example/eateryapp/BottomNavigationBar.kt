package com.example.eateryapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eateryapp.Data.totalItemInCart
import com.example.eateryapp.Screens.CartClass
import com.example.eateryapp.Screens.ItemClass
import com.example.eateryapp.Screens.Login
import com.example.eateryapp.Screens.QR
import com.example.eateryapp.Screens.RestaurantClass
import com.example.eateryapp.Screens.SignUP


data class BottomNavigationItems(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    var badgeCount: Int? = null
)

class BottomNavigationBar {
    companion object{
        @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
        @Composable
        fun BottomNavigationBar(){
            val items = listOf(
                BottomNavigationItems(
                    title = "Home",
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                    hasNews = false,
                ),
                BottomNavigationItems(
                    title = "Cart",
                    selectedIcon = Icons.Filled.ShoppingCart,
                    unselectedIcon = Icons.Outlined.ShoppingCart,
                    hasNews = false,
                    badgeCount = 0
                ),
                BottomNavigationItems(
                    title = "Settings",
                    selectedIcon = Icons.Filled.Settings,
                    unselectedIcon = Icons.Outlined.Settings,
                    hasNews = true,
                ),
            )

            val navController = rememberNavController()

            Scaffold(
                bottomBar = { BottomBar(items,navController) },
//                modifier = Modifier.padding(4.dp)
            ) {
                NavHost(navController = navController, startDestination = "RestaurantClass") {
                    composable("RestaurantClass"){ RestaurantClass.View06(navController)}
                    composable("QR"){ QR.Qr(navController)}
                    composable("ItemClass"){ ItemClass.View08(navController)}
                    composable("CartClass"){ CartClass.View10(navController)}
                    composable("Login"){ Login.Login(navController)}
                    composable("SignUp"){ SignUP.SignUP(navController)}
//                composable("Class0"){ Class0.View0()}
                }
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun BottomBar(items:List<BottomNavigationItems>,navController: NavController)
        {
            var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

            NavigationBar(
                containerColor  = Color.Black,
                modifier = Modifier.height(100.dp)

            ) {


                LaunchedEffect(totalItemInCart){
                    items[1].badgeCount= totalItemInCart;
                }


                items.forEachIndexed {
                        index, item ->

                    NavigationBarItem(
//                            colors = NavigationBarItemDefaults.colors(Color(0xFFBB6748)),
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            if(index==0){
                                navController.navigate("RestaurantClass")
                            }
                            else if(index==1){
                                navController.navigate("CartClass")
                            }
                            else{
                                navController.navigate("Login")
                            }
                            // navController.navigate(item.title)
                        },
                        label = {
                            Text(text = item.title,
//                                    fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )
                        },
//                            alwaysShowLabel = false,
                        icon = {
                            BadgedBox(
                                badge = {
                                    if(item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    }


                                    else if(item.hasNews) {
                                        Badge()
                                    }   //apatoto no needed
                                }
                            ) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = "",
                                    tint = if(index == selectedItemIndex) Color.Blue else Color(0xFFBB6748)
                                )
                            }
                        }
                    )
                }
            }
        }
    }

}