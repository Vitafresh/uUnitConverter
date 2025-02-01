package top.vitafresh.uunitconverter

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import top.vitafresh.uunitconverter.ui.theme.UUnitConverterTheme
import kotlin.math.exp

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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit Converter:",
//            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box {
                Button(onClick = { /* TO DO */ }) {
                    Text(text = "Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down (just description)"
                    )
                }
                DropdownMenu(expanded = false, onDismissRequest = {/* TODO */ }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {})
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {})
                    DropdownMenuItem(
                        text = { Text("Melimeters") },
                        onClick = {})
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {})
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { /* TO DO */ }) {
                    Text(text = "Select")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down (just description)"
                    )
                }
                DropdownMenu(expanded = false, onDismissRequest = {/* TODO */ }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {})
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {})
                    DropdownMenuItem(
                        text = { Text("Melimeters") },
                        onClick = {})
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {})
                }
            }


        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result:")

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