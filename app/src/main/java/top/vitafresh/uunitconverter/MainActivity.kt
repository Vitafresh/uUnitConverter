package top.vitafresh.uunitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import top.vitafresh.uunitconverter.ui.theme.UUnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UUnitConverterTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
//fun UnitConverter(modifier: Modifier = Modifier) {
fun UnitConverter(
) {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val iConversionFactor = remember { mutableStateOf(1.0) }
    val oConversionFactor = remember { mutableStateOf(1.0) }

    // Styling OutlinedTextField
    val styleTextField = TextStyle(
        color = Color.Blue,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )

    fun convertUnits() {
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result =
            (inputValueDouble * oConversionFactor.value / iConversionFactor.value  )
        outputValue = String.format("%.2f", result)

    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit Converter:",
            style = MaterialTheme.typography.headlineLarge
//            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                convertUnits()
            },
            label = { Text("Enter Value") },
            textStyle = styleTextField
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            // Input box
            Box {
                //Input button
                Button(onClick = { iExpanded = true }) {
                    Text(text = "Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down (just description)"
                    )
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            inputUnit = "Centimeters"
                            iExpanded = false
                            iConversionFactor.value = 100.0
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            inputUnit = "Meters"
                            iExpanded = false
                            iConversionFactor.value = 1.0
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Melimeters") },
                        onClick = {
                            inputUnit = "Melimeters"
                            iExpanded = false
                            iConversionFactor.value = 1000.0
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            inputUnit = "Feet"
                            iExpanded = false
                            iConversionFactor.value = 3.2808399
                            convertUnits()
                        })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            // Output box
            Box {
                // Output button
                Button(onClick = { oExpanded = true }) {
                    Text(text = "Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down (just description)"
                    )
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            outputUnit = "Centimeters"
                            oExpanded = false
                            oConversionFactor.value = 100.0
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            outputUnit = "Meters"
                            oExpanded = false
                            oConversionFactor.value = 1.0
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Melimeters") },
                        onClick = {
                            outputUnit = "Melimeters"
                            oExpanded = false
                            oConversionFactor.value = 1000.0
                            convertUnits()
                        })
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            outputUnit = "Feet"
                            oExpanded = false
                            oConversionFactor.value = 3.2808399
                            convertUnits()
                        })
                }
            }


        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium
        )

//            val context = LocalContext.current
//            Button(onClick = {
//                Toast.makeText(
//                    context,
//                    "My toast text",
//                    Toast.LENGTH_LONG
//                ).show()
//            }) {
//                Text("One")
//            }
//            Button(onClick = { /* TO DO */ }) {
//                Text(text = "My Button")
//            }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    UUnitConverterTheme {
//        Greeting("Android")
//    }
//}