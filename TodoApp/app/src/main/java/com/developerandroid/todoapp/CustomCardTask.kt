package com.developerandroid.todoapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomCard_Task(
    title : String,
    description: String,
    startTime: String,
    endTime: String,
    //endData: String
    containerColor: Color = Color(0xFFF0F0F0),
    elevation: Dp = 10.dp
) {
    Card(
        modifier = Modifier.fillMaxWidth().height(130.dp).padding(horizontal = 20.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Column {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp),
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(20.dp))
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 2.dp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row{
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = "Today",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "$startTime-",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = endTime,
                    fontSize = 14.sp,
                    color = Color.Gray
                )

            }
        }
    }
}