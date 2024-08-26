package com.example.kotlincalculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlincalculatorapp.calculator.Interpreter
import com.example.kotlincalculatorapp.databinding.ActivityMainBinding
import com.example.kotlincalculatorapp.ui.theme.KotlinCalculatorAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
    }

    fun numberAction(view: View) {
        if (view is Button) {
            if (view.text == ".") {
                    binding.workingsTextView.append(view.text)
            } else {
                binding.workingsTextView.append(view.text)
            }
        }
    }

    fun operatorAction(view: View) {
        if (view is Button) {
            binding.workingsTextView.append(view.text)
        }
    }

    fun allClearAction(view: View) {
        binding.workingsTextView.text = ""
        binding.resultsTextView.text = ""
    }

    fun backSpaceAction(view: View) {
        val length = binding.workingsTextView.length()
        if (length > 0)
            binding.workingsTextView.text = binding.workingsTextView.text.subSequence(0, length - 1)
    }

    fun equalsAction(view: View) {
        val inputString: String = binding.workingsTextView.text.toString()
        binding.resultsTextView.text = Interpreter.interp(inputString)
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinCalculatorAppTheme {
        Greeting("Android")
    }
}