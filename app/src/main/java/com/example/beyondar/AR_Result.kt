package com.example.beyondar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.beyondar.databinding.ActivityArResultBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode

class AR_Result : AppCompatActivity() {

    private lateinit var binding: ActivityArResultBinding
    private lateinit var sceneView: ArSceneView
    private lateinit var placeButton: ExtendedFloatingActionButton
    private lateinit var modelNode: ArModelNode
    private lateinit var floatingTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityArResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sceneView = findViewById(R.id.sceneView)
        placeButton = findViewById(R.id.place)
        floatingTextView = findViewById(R.id.floatingTextView)

        val result = intent.getStringExtra("result")
        val url = intent.getStringExtra("url")


        val topic = url?.substringAfter("https://en.wikipedia.org/wiki/")

        val resultText_ = result?.let { displayFirst5Sentences(it) }
        val resultText = "\n\n" + resultText_
        binding.floatingTextView.text = resultText

        // Set OnClickListener for "Read More" link
        binding.floatingTextView.setOnClickListener {
            if (!url.isNullOrEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }



        if(topic =="Ball") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/ball.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }

            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Big Ben") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/big_ben.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Eiffel Tower") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/eiffel_tower.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Stonehenge") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/stonehenge.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Furniture") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/table.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Boat") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/boat.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Food") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/Donut.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Fork") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/fork.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Door") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/door.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Egg") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/egg.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Emoji") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/emoji.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="House Plant") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/flower pot.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Grass") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/grass.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Lamp") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/lamp.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="TableWare") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/mug.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Pillow") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/pillow.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else if(topic =="Plate") {
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = "models/plate.glb"
                ) {
                    sceneView.planeRenderer.isVisible = true
                }
                onAnchorChanged = {
                    placeButton.isGone = true
                }
            }
            placeButton.setOnClickListener {
                placeModel()
            }
        }
        else{
            modelNode = ArModelNode().apply {
                loadModelGlbAsync(
                    glbFileLocation = ""
                ) {
                    sceneView.planeRenderer.isVisible = true
                }

                placeButton.isVisible = false

            }
        }

        sceneView.addChild(modelNode)
    }

    private fun placeModel() {
        modelNode?.anchor()
        sceneView.planeRenderer.isVisible = false
    }

    private fun displayFirst5Sentences(text: String): String {
        val sentences = text.split("\\.\\s+".toRegex())
        val sentenceCount = minOf(3, sentences.size)
        val first3Sentences = sentences.subList(0, sentenceCount).joinToString(".\n\n")
        return "$first3Sentences." + "\n\n\nClick Here Read More!!"
    }
}
