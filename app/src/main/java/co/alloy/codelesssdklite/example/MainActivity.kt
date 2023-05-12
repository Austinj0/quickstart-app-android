package co.alloy.codelesssdklite.example

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import co.alloy.codelesssdklite.Alloy
import co.alloy.codelesssdklite.AlloySettings
import co.alloy.codelesssdklite.example.ui.theme.AlloyCodelessSDKLiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val journeyData = AlloySettings.JourneyData(
            entities = listOf(
                AlloySettings.Entity(
                    branchName = "vouched",
                    entityType = "person",
                    entityData = AlloySettings.Entity.EntityData(
                        firstName = "Mary",
                        lastName = "Vouched",
                    ),
                ),
                AlloySettings.Entity(
                    branchName = "veriff",
                    entityType = "person",
                    entityData = AlloySettings.Entity.EntityData(
                        firstName = "Katelyn",
                        lastName = "Veriff",
                    ),
                ),
                AlloySettings.Entity(
                    branchName = "persona",
                    entityType = "person",
                    entityData = AlloySettings.Entity.EntityData(
                        firstName = "Erik",
                        lastName = "Persona",
                    ),
                ),
            ),
            doAwaitAdditionalEntities = false,
            externalGroupId = null,
            externalProductId = null,
        )

        val settings = AlloySettings(
            apiKey = "9ca83767-f213-4aaf-bc1b-1ed0a89eaf23",
            production = false,
            isNext = true,
            journeyToken = "J-UMEhLDP3p759425pz1uP",
            journeyApplicationToken = "JA-1Xdb27UFRmv2wpkRTF0g",
            journeyData = journeyData,
        )

        Alloy.listener = object : Alloy.Listener {
            override fun onCancelled() {
                Log.d("AlloyDemo", "onCancelled")
            }

            override fun onDenied() {
                Log.d("AlloyDemo", "onDenied")
            }

            override fun onManualReview() {
                Log.d("AlloyDemo", "onManualReview")
            }

            override fun onSuccess() {
                Log.d("AlloyDemo", "onSuccess")
            }

            override fun journeyApplicationTokenCreated(token: String) {
                Log.d("AlloyDemo", "journeyApplicationTokenCreated: $token")
            }

            override fun gotError(error: String) {
                Log.d("AlloyDemo", "gotError: $error")
            }
        }

        setContent {
            AlloyCodelessSDKLiteTheme {
                // A surface container using the 'background' color from the theme
                Box(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {
                                Alloy.start(this@MainActivity, settings)
                            }
                        ) {
                            Text(text = stringResource(R.string.main_start_sdk))
                        }

                        Button(
                            onClick = {
                                Alloy.createApplication(this@MainActivity, settings)
                            }
                        ) {
                            Text(text = stringResource(R.string.main_create_journey_application))
                        }
                    }
                }
            }
        }
    }
}
