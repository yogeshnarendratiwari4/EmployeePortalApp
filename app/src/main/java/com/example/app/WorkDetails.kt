package com.example.app
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class WorkDetailsData(
    val employeeId : String,
    val team : String,
    val role : String,
    val reportingManager: String,
    val employementType : String,
    val joiningDate : String,
    val workEmail : String,
)

val workDetailsPageData = WorkDetailsData("3144","Android","Intern","Gibson S","","7 January 2024","yogeshnarendratiwari4@gmail.com");


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun WorkDetailsPage() {
    Box(modifier = Modifier.fillMaxSize()){

        Scaffold(
            topBar = {
                AppBar("Work Details")
            },
        ) {
            it
            Column (modifier = Modifier
                .padding(horizontal = 10.dp)
                .verticalScroll(rememberScrollState())
                .padding(top = 60.dp)){
                CardComponent("Employee Id",workDetailsPageData.employeeId,false)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp)
                CardComponent("Team", workDetailsPageData.team,false)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp)
                CardComponent("Role", workDetailsPageData.role,false)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp)
                CardComponent("Reporting Manager", workDetailsPageData.reportingManager,false)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp)
                CardComponent("Employement Type", workDetailsPageData.employementType,false)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp)
                CardComponent("Joining Date", workDetailsPageData.joiningDate,false)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp,)
                CardComponent("Work Email", workDetailsPageData.workEmail,false)

            }
        }

    }
}

