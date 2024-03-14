package com.example.app
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class BasicDetailsData(
    val first_name : String,
    val last_name : String,
    val dob : String,
    val gender : String,
    val currentAddress : String,
    val mobileNumber : String,
    val personalEmail : String,
)
val basicDetailsPageData = BasicDetailsData("Yogesh","Tiwari","1-10-2002","Male","Mama bhanja ka talab,Naini Prayagraj UttarPradesh","+916306373605","yogesh@gmail.com")
@Composable
fun CardComponent(heading :String,content : String,isEditable : Boolean = true,onClickFunction : (() -> Unit)? = null){
    Card (modifier = Modifier
        .padding(vertical = 2.dp)
        .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
    ),
    shape = RoundedCornerShape(7.dp)
    )

    {
       Row (modifier = Modifier.padding(vertical = 24.dp, horizontal = 20.dp)){
           Column(modifier = Modifier.fillMaxWidth(),
               verticalArrangement = Arrangement.spacedBy(4.dp)) {
               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceBetween)
               {
                   Text(text = heading,color = Color.Gray)
                   if (isEditable) {
                           Text(text = "Edit", color = Color.Gray, modifier = Modifier.clickable {onClickFunction})
                   } else {
                       Icon(
                           Icons.Outlined.Lock,
                           contentDescription = "Lock",
                           modifier = Modifier.size(15.dp),
                          tint = Color.Gray

                       )
                   }

               }
               Text(text = content,modifier = Modifier.padding(bottom =5.dp, end = 20.dp), fontWeight = FontWeight.SemiBold,color = Color.Black)
           }
       }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicDetailsPage() {
    Box(modifier = Modifier.fillMaxSize()){

        Scaffold(
            topBar = {
                AppBar(heading = "Basic Details")
            },
        ) {
            it
            Column (modifier = Modifier
                .padding(horizontal = 10.dp)
                .verticalScroll(rememberScrollState())
                .padding(top = 60.dp)){
                CardComponent("First Name", basicDetailsPageData.first_name)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp)
                CardComponent("Last Name",basicDetailsPageData.last_name)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp)
                CardComponent("Date of Birth",basicDetailsPageData.dob)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp)
                CardComponent("Gender",basicDetailsPageData.gender)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp)
                CardComponent("Current Address", basicDetailsPageData.currentAddress)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp)
                CardComponent("Mobile", basicDetailsPageData.mobileNumber)
                Divider(modifier = Modifier.padding(start = 6.dp,end = 6.dp), color = Color.LightGray, thickness = 0.2.dp,)
                CardComponent("Personal Email", basicDetailsPageData.personalEmail,false)

            }
        }

    }
}

