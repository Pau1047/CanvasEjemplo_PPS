package com.example.canvasejemplo_pps

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.drawscope.Stroke

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portada(){

    Scaffold (topBar = { MyTopAppBar()},){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ){
            Canvas(modifier = Modifier.fillMaxSize()){
                val mySize = 50F
                val myMargen = 50F

                drawRect(
                    topLeft = Offset(myMargen,myMargen),
                    color = Color.Red,
                    size = Size(mySize, mySize)
                )
                drawRect(
                    topLeft = Offset(size.width - myMargen - mySize, myMargen),
                    color = Color.Blue,
                    size = Size(mySize, mySize)
                )
                drawRect(
                    topLeft = Offset(myMargen, size.width - myMargen - mySize),
                    color = Color.Green,
                    size = Size(mySize, mySize)
                )
                drawRect(
                    topLeft = Offset(size.width - myMargen - mySize, size.width - myMargen - mySize),
                    color = Color.Yellow,
                    size = Size(mySize, mySize)
                )
                drawPoints(
                    points = listOf(Offset(size.width / 2F, size.width / 2F)),
                    pointMode = PointMode.Points,
                    strokeWidth = 30f,
                    color = Color.Cyan
                )
                drawCircle(
                    color = Color.Magenta,
                    radius = (size.width /2F) - (myMargen * 3),
                    center = Offset(size.width/2F, size.width/2F),
                    style = Stroke(10f)
                )
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    var extended by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Canvas Ejemplo") },

        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            IconButton(onClick = { extended = !extended }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Back"
                )
            }
            DropdownMenu(expanded = extended, onDismissRequest = { extended = !extended}) {
                DropdownMenuItem(text = { Text(text = "Compartir") }, onClick = { /*TODO*/ }, leadingIcon = { Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Back"
                )
                })
                DropdownMenuItem(text = { Text(text = "Album") }, onClick = { /*TODO*/ }, leadingIcon = { Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Back"
                )
                })

            }

        }
    )
}


