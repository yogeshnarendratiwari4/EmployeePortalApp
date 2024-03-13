package com.example.app

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class AdditionalDetailsData(
    val shirtSize: String, val interest: String
)

val additionalDetailsPageData = AdditionalDetailsData("XXL", "Video, cricket")


//@Composable
//@Preview(showBackground = true)
//fun PreviewFun() {
//    AppBar(heading = "headerimg", { Text(text = "hello") })
//}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(heading: String) {

    Surface(elevation = 10.dp) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
                titleContentColor = Color.Black,
            ),
            title = {
                Text(
                    heading, maxLines = 1, overflow = TextOverflow.Ellipsis
                )
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
        )
    }
}


@Composable
fun AdditionalDetailspageUI() {
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState())
            .padding(top = 60.dp)
    ) {

        CardComponent("T-shirt size", additionalDetailsPageData.shirtSize, true)
        Divider(
            modifier = Modifier.padding(start = 6.dp, end = 6.dp),
            color = Color.LightGray,
            thickness = 0.2.dp
        )
        CardComponent("Interests", additionalDetailsPageData.interest, true)
        Divider(
            modifier = Modifier.padding(start = 6.dp, end = 6.dp),
            color = Color.LightGray,
            thickness = 0.2.dp
        )

    }

}


@RequiresApi(Build.VERSION_CODES.M)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun AddtionalDetailsPage() {
    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = {
                     AppBar(heading = "Additional Details")

            },
        ) {
            Surface(Modifier.fillMaxSize()) {
                it
                AdditionalDetailspageUI()
            }
        }


    }
}






