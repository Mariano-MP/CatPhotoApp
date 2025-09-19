package com.mexiti.catphotoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mexiti.catphotoapp.R
import com.mexiti.catphotoapp.viewmodel.CatUiState


@Composable

fun HomeScreen(
    catUiState:CatUiState,
    modifier: Modifier= Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when( catUiState){
        is CatUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is CatUiState.Success ->ResultScreen( photos = catUiState.photos,
            modifier = modifier.fillMaxWidth())
        is CatUiState.Error -> ErrorScreen(modifier =  modifier.fillMaxSize())

    }



}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.error_load)
            , contentDescription = "Error Loading" )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.loader),
            contentDescription = "Loading")
    }
}


@Composable
fun ResultScreen(photos:String, modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
        ){
        Text(text = photos )
    }
}

