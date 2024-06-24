package com.example.beyondar

import android.content.Intent
import android.content.pm.PackageManager
import android.os.AsyncTask
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.core.content.ContextCompat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import com.example.object_detection_final.data.TfliteLandmarkClassifier
import com.example.object_detection_final.domain.Classification
import com.example.object_detection_final.presentation.CameraPreview
import com.example.object_detection_final.presentation.LandmarkImageAnalyzer
import org.jsoup.Jsoup
import java.io.IOException
import androidx.compose.runtime.remember as remember1

class Location : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!hasCameraPermission()) {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.CAMERA), 0
            )
        }

        setContent {
            var classifications by remember {
                mutableStateOf(emptyList<Classification>())
            }
            val analyzer = remember1 {
                LandmarkImageAnalyzer(
                    classifier = TfliteLandmarkClassifier(
                        context = applicationContext
                    ),
                    onResults = {
                        classifications = it
                    }
                )
            }
            val controller = remember {
                LifecycleCameraController(applicationContext).apply {
                    setEnabledUseCases(CameraController.IMAGE_ANALYSIS)
                    setImageAnalysisAnalyzer(
                        ContextCompat.getMainExecutor(applicationContext),
                        analyzer
                    )
                }
            }

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CameraPreview(controller, Modifier.fillMaxSize())

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                ) {
                    classifications.forEach {
                        val topic = it.name
                        Text(

                            text = it.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.primaryContainer)
                                .padding(8.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            color = MaterialTheme.colorScheme.primary
                        )


                        Button(
                            onClick = {
                                FetchDataAsyncTask().execute(topic)
                            },
                            content = {
                                Text(text = "Next Page")
                            }
                        )
                    }
                }
            }
        }
    }

    private fun hasCameraPermission() =
        ContextCompat.checkSelfPermission(
            this, android.Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED

    inner class FetchDataAsyncTask : AsyncTask<String, Void, Pair<String, String>>() {
        override fun doInBackground(vararg params: String): Pair<String, String> {
            val topic = params[0]
            try {
                val url = "https://en.wikipedia.org/wiki/$topic"
                val document = Jsoup.connect(url).get()
                val paragraphs = document.select("p") // Select all <p> elements
                val textBuilder = StringBuilder()
                var wordCount = 0
                for (p in paragraphs) {
                    val words = p.text().split("\\s+".toRegex())
                    for (word in words) {
                        if (wordCount < 100) {
                            textBuilder.append(word).append(" ")
                            wordCount++
                        } else {
                            break
                        }
                    }
                    if (wordCount >= 100) break
                }
                val remainingText = if (wordCount >= 100) "..." else ""
                val fullText = textBuilder.toString().trim() + remainingText
                val readMoreUrl = url
                return Pair(fullText, readMoreUrl)
            } catch (e: IOException) {
                e.printStackTrace()
                return Pair("Error: ${e.message}", "")
            }
        }

        override fun onPostExecute(result: Pair<String, String>) {
            super.onPostExecute(result)
            val intent = Intent(this@Location, AR_Result::class.java)
            intent.putExtra("result", result.first)
            intent.putExtra("url", result.second)
            startActivity(intent)
        }
    }
}
