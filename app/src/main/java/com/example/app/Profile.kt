package com.example.app
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp





data class ProfileData(
    val name : String = "Yogesh",
    val department :String =  "Intern -",
    val email : String = "yogeshnarendratiwari@gmai.com",
    val image : Int = R.drawable.ic_launcher_background,
)
val user = ProfileData()


@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun ProfileCardComponent(heading:String, image:Int, content:String, horizontalPadding : Dp, verticalPadding : Dp,isUserData : Boolean = false,buttonText:String = "",){
    Card(modifier = Modifier
        .padding(horizontal = horizontalPadding, vertical = verticalPadding)
        .fillMaxWidth()
        .height(90.dp),colors = CardDefaults.cardColors(
        containerColor = Color.White,
    ),
        elevation = CardDefaults.cardElevation(3.dp),
        shape = RoundedCornerShape(7.dp)
    ) {
           Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
               Row{
                   Image(
                       modifier = Modifier.size(70.dp),
                       painter = painterResource(id = image),
                       contentDescription = "Image_Profile"
                   )
                   Column(
                       modifier = Modifier.padding(10.dp),
                       verticalArrangement = Arrangement.spacedBy(2.dp)
                   ) {

                       Text(text = heading, fontSize = 20.sp, fontWeight = FontWeight.Bold)

                       Text(text = content, fontSize = 12.sp, fontWeight = FontWeight.Light)
                       if (isUserData) {
                           Text(
                               text = buttonText,
                               fontSize = 12.sp,
                               fontWeight = FontWeight.Bold,
                               color = Color.Blue,
                               modifier = Modifier.clickable {}

                           )
                       }

                   }
               }

                  if(!isUserData)
                   IconButton(onClick = {}, modifier = Modifier.align(Alignment.CenterVertically)) {
                       Icon(
                           Icons.Outlined.KeyboardArrowRight,
                           contentDescription = "Lock",
                           modifier = Modifier
                               .size(15.dp)
                               .align(Alignment.CenterVertically),
                           tint = Color.Gray

                       )
                   }
               }
           }
           }



@Preview(showBackground = true)
@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun Profile() {

     Box(modifier = Modifier.fillMaxSize()){
         Column {
             Card (modifier = Modifier.fillMaxWidth(),colors = CardDefaults.cardColors(
                 containerColor = Color.White,
             ),){
                 Text(text = "Profile",Modifier.padding(30.dp), fontSize = 30.sp, fontWeight = FontWeight.Bold)
             }
             Card (modifier = Modifier
                 .fillMaxSize(),colors = CardDefaults.cardColors(
                 containerColor = Color.White,
             ),
             ){
                 Column {
                     ProfileCardComponent(user.name,R.drawable.basic,user.department+"-\n"+user.email,10.dp,10.dp,true,"View your profile ->")

                 }

                 Card (modifier = Modifier.fillMaxWidth(),colors = CardDefaults.cardColors(
                     containerColor = Color.White,
                 ),){
                     Text(text = "Your details",Modifier.padding(30.dp,30.dp,30.dp,20.dp), fontWeight = FontWeight.Bold, fontSize = 30.sp, color = Color.Gray)
                 }


                 ProfileCardComponent("Basic details",R.drawable.basic,"First name,Last name, Date of birth,\nGender,Current Address, Mobile ,\nPersonal email",10.dp,2.dp)
                 ProfileCardComponent("Additional details",R.drawable.add,"T-shirt sizes, Interests",10.dp,2.dp)
                 ProfileCardComponent("Work details",R.drawable.work,"Employee id, Team, Role, Reporting\nmanager,Employment Type, Joining Date,\nWork Email ",10.dp,2.dp)
                         Divider(modifier = Modifier.padding(top = 40.dp, start = 50.dp,end = 50.dp, bottom = 5.dp), color = Color.DarkGray, thickness = 0.2.dp)
                        Row (modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                            // Icon will be there
                            Text(text = "View your past support issues")
                        }

                         Divider(modifier = Modifier.padding(top = 5.dp, start = 50.dp,end = 50.dp,bottom = 10.dp), color = Color.DarkGray, thickness = 0.2.dp)


             }
         }
     }

}

