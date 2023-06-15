package com.example.ticketease.Screens.Organizer

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ticketease.MVVM.Event.EnterParam.EnterParamStateTextFields
import com.example.ticketease.MVVM.Event.EnterParam.ViewModelEnterParam
import com.example.ticketease.R
import com.example.ticketease.Screens.EnterAppByer.checkSymbols

@Composable
fun CreateEvent(navController: NavHostController, viewModel: ViewModelEnterParam = hiltViewModel()) {
    val state = viewModel.state
    val context = LocalContext.current
    val statePlace = viewModel.statePrice

    Box(
        modifier = Modifier
            .background(color = colorResource(R.color.white))
            .fillMaxWidth()
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .background(color = colorResource(R.color.white))
                    .fillMaxWidth()
                    .height(150.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(modifier = Modifier.padding(30.dp)) {
                    Text("Создать мероприятие", fontSize = 28.sp, color = Color.Black)

                }
            }
            Box(
                modifier = Modifier
                    .background(color = colorResource(R.color.white))
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter

            ) {

                Box(modifier = Modifier.padding(bottom = 70.dp).fillMaxHeight()) {
                    Column(
                        modifier = Modifier.size(800.dp, 1200.dp).offset(0.dp, -50.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        TextField(
                            value = state.name,
                            onValueChange = { viewModel.enter(EnterParamStateTextFields.Name(it)) },
                            placeholder = {
                                Text(
                                    text = "Название мероприятия",
                                    color = colorResource(R.color.black)
                                )
                            },
                            modifier = Modifier
                                .padding(5.dp).background(color = colorResource(R.color.greyfind)),
                        )

                        TextField(
                            value = statePlace.value,
                            onValueChange = { viewModel.enter(EnterParamStateTextFields.Cost(it)) },
                            placeholder = {
                                Text(
                                    text = "Стоимость мерпориятия",
                                    color = colorResource(R.color.black)
                                )
                            },
                            modifier = Modifier
                                .padding(5.dp).background(color = colorResource(R.color.greyfind)),
                        )
                        TextField(
                            value = state.type,
                            onValueChange = { viewModel.enter(EnterParamStateTextFields.Type(it)) },
                            placeholder = {
                                Text(
                                    text = "Тип мероприятия",
                                    color = colorResource(R.color.black)
                                )
                            },
                            modifier = Modifier
                                .padding(5.dp).background(color = colorResource(R.color.greyfind)),
                        )
                        TextField(
                            value = state.genre,
                            onValueChange = { viewModel.enter(EnterParamStateTextFields.Genre(it)) },
                            placeholder = {
                                Text(
                                    text = "Жанр мероприятия",
                                    color = colorResource(R.color.black)
                                )
                            },
                            modifier = Modifier
                                .padding(5.dp).background(color = colorResource(R.color.greyfind)),
                        )
                        TextField(
                            value = state.nameGroup.toString(),
                            onValueChange = { viewModel.enter(EnterParamStateTextFields.NameGroup(it)) },
                            placeholder = {
                                Text(
                                    text = "Название коллектива",
                                    color = colorResource(R.color.black)
                                )
                            },
                            modifier = Modifier
                                .padding(5.dp).background(color = colorResource(R.color.greyfind)),
                        )
                        TextField(
                            value = state.description.toString(),
                            onValueChange = {
                                viewModel.enter(
                                    EnterParamStateTextFields.Description(
                                        it
                                    )
                                )
                            },
                            placeholder = {
                                Text(
                                    text = "Описание",
                                    color = colorResource(R.color.black)
                                )
                            },
                            modifier = Modifier
                                .padding(5.dp).height(130.dp)
                                .background(color = colorResource(R.color.greyfind)),
                        )

                        Box() {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Button(
                                    onClick = {
                                        if (checkSymbols(state.name) and checkSymbols(state.genre!!) and checkSymbols(
                                                state.type!!
                                            )
                                        ) {

                                            viewModel.enter(EnterParamStateTextFields.Enter)
                                            navController.navigate("PlaceSelector")
                                        } else {
                                            Toast.makeText(context, "Error", Toast.LENGTH_LONG)
                                                .show()

                                        }
                                    },
                                    modifier = Modifier
                                        .padding(top = 30.dp)
                                        .height(50.dp)
                                        .width(300.dp),
                                    shape = RoundedCornerShape(50),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = colorResource(
                                            R.color.backgroud
                                        )
                                    ),
                                )
                                {

                                    Column {
                                        Text("Создать", fontSize = 25.sp, color = Color.White)

                                    }
                                }
                            }
                        }
                    }
                }

                        Box(
                            modifier = Modifier
                                .background(color = colorResource(R.color.white))
                                .fillMaxWidth()
                                .height(70.dp), contentAlignment = Alignment.BottomCenter
                        ) {
                            Row() {
                                Box(modifier = Modifier.size(35.dp, 30.dp)) {

                                }
                                Column() {
                                    Image(
                                        painterResource(id = R.drawable.eventblack),
                                        contentDescription = "image",
                                        modifier = Modifier
                                            .size(40.dp, 40.dp)
                                            .clickable() {
                                                navController.navigate("CreateEvent")
                                            },
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(
                                        text = "Создать мероприятие ",
                                        fontSize = 10.sp,
                                    )
                                }
                                Box(modifier = Modifier.size(25.dp, 30.dp)) {

                                }
                                Column() {
                                    Image(
                                        painterResource(id = R.drawable.avatar),
                                        contentDescription = "image",
                                        modifier = Modifier
                                            .size(35.dp, 35.dp)
                                            .clickable() {
                                                navController.navigate("PersonalOrg")
                                            },
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(
                                        text = "Личный кабинет",
                                        fontSize = 10.sp,
                                    )
                                }


                            }
                        }


                }
            }
        }

    }

