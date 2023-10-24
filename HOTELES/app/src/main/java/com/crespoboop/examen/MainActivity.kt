package com.crespoboop.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.crespoboop.examen.data.HotelesDatabase
import com.crespoboop.examen.data.HotelesRepository
import com.crespoboop.examen.main.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db= Room.databaseBuilder(this, HotelesDatabase::class.java, "Hotelesdb").build()
        val dao= db.dao
        val repository= HotelesRepository(dao)
        val viewmodel = HotelesMainViewModel(repository)

        setContent {
            val navController= rememberNavController()
            NavHost(navController = navController, startDestination = "main" ){
                composable("main" ){

                    HotelesMainScreen(navController,viewmodel)

                }
                composable(route="detail"+"/{text}/{text2}/{text3}/{text4}", arguments =  listOf(navArgument(name = "text") {type= NavType.StringType }, (navArgument(name="text2") { type= NavType.StringType }),
                    (navArgument(name="text3"){
                        type= NavType.StringType }
                            ),
                    (navArgument(name="text4"){
                        type= NavType.StringType }
                            )
                )
                )
                {
                    DetailScreen(navController, it.arguments?.getString("text"),
                        it.arguments?.getString("text2"), it.arguments?.getString("text3"), it.arguments?.getString("text4"))
                }
                composable("lista"){
                    HotelesScreen(viewModel = viewmodel, navController =navController )
                }
            }
        }
    }
}