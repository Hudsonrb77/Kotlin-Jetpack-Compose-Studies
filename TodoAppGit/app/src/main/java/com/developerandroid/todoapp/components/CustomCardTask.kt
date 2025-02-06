import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.developerandroid.todoapp.data.Task

@Composable
fun CustomCard_Task(
    taskItem: Task,
    containerColor: Color = Color.White,
    elevation: Dp = 8.dp,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = containerColor),
        elevation = CardDefaults.cardElevation(elevation),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Title
            Text(
                text = taskItem.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A90E2)
            )

            // Description
            Text(
                text = taskItem.description,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Divider
            HorizontalDivider(
                color = Color(0xFFE0E0E0),
                thickness = 3.dp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Time row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = taskItem.data,
                    fontSize = 14.sp,
                    color = Color(0xFF757575),
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${taskItem.startTime} - ${taskItem.startTime}",
                    fontSize = 14.sp,
                    color = Color(0xFF757575)
                )
            }
        }
    }
}
