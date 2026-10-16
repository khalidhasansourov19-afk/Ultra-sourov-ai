package com.ultrasourov.ai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ultrasourov.ai.data.AppLanguage
import com.ultrasourov.ai.ui.screens.DeviceControlScreen
import com.ultrasourov.ai.ui.screens.MediaEditorScreen
import com.ultrasourov.ai.ui.screens.SecurityShieldScreen
import com.ultrasourov.ai.ui.screens.UniversalSolverScreen
import com.ultrasourov.ai.ui.screens.VisionSolverScreen
import com.ultrasourov.ai.ui.screens.VoiceAssistantScreen
import com.ultrasourov.ai.ui.theme.HiOSDarkBackground
import com.ultrasourov.ai.ui.theme.UltraSourovAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UltraSourovAITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = HiOSDarkBackground
                ) {
                    val navController = rememberNavController()
                    var currentLanguage by remember { mutableStateOf(AppLanguage.BENGALI) }

                    Scaffold { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = "voice_assistant",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable("voice_assistant") {
                                VoiceAssistantScreen(
                                    language = currentLanguage,
                                    onLanguageChange = { currentLanguage = it },
                                    onNavigate = { route -> navController.navigate(route) }
                                )
                            }
                            composable("vision_solver") {
                                VisionSolverScreen(
                                    language = currentLanguage,
                                    onNavigateBack = { navController.popBackStack() }
                                )
                            }
                            composable("device_control") {
                                DeviceControlScreen(
                                    onNavigateBack = { navController.popBackStack() }
                                )
                            }
                            composable("security_shield") {
                                SecurityShieldScreen(
                                    onNavigateBack = { navController.popBackStack() }
                                )
                            }
                            composable("media_editor") {
                                MediaEditorScreen(
                                    onNavigateBack = { navController.popBackStack() }
                                )
                            }
                            composable("universal_solver") {
                                UniversalSolverScreen(
                                    language = currentLanguage,
                                    onNavigateBack = { navController.popBackStack() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
