package com.example.composenoteapp.ui.previwnote

import android.widget.EditText
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composenoteapp.R
import com.example.composenoteapp.model.Note
import com.example.composenoteapp.ui.destinations.EditNoteDestination
import com.example.composenoteapp.ui.destinations.MainScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterialApi::class)
@Destination
@Composable
fun PreviewNote(
    nav: DestinationsNavigator, viewModel: PreviewNoteViewModel = hiltViewModel()
) {
    var title = remember {
        mutableStateOf("")
    }
    var content = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.padding(30.dp, 30.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(modifier = Modifier.size(50.dp), shape = RoundedCornerShape(15.dp), onClick = {
                nav.navigate(MainScreenDestination)
            }) {
                Icon(
                    Icons.Outlined.ArrowBack,
                    modifier = Modifier.size(24.dp),
                    contentDescription = "Back"
                )
            }
            Column(
                modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End
            ) {
                val context = LocalContext.current
                Button(
                    modifier = Modifier.size(50.dp),
                    shape = RoundedCornerShape(15.dp),
                    onClick = {

                        viewModel.insert(
                            Note(
                                title = title.value, content = content.value
                            )
                        )
                        nav.navigate(MainScreenDestination)
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.save_filled_svgrepo_com),
                        modifier = Modifier.size(24.dp),
                        contentDescription = "New"
                    )
                }


            }
        }
    }
    Column(
        modifier = Modifier
            .padding(30.dp, 100.dp)
            .verticalScroll(rememberScrollState()),

        ) {
        TextField(modifier = Modifier

            .padding(0.dp, 0.dp, 23.dp, 0.dp)
            .background(color = Color.White),
            placeholder = {
                          Text(text = "Title")
            },
            value = title.value,
            onValueChange = { title.value = it })
        Spacer(
            modifier = Modifier.padding(7.dp)
        )
        TextField(modifier = Modifier.background(color = Color.White),
            placeholder = {
                Text(text = "Content")
            },
            value = content.value,
            onValueChange = { content.value = it })
    }
}


