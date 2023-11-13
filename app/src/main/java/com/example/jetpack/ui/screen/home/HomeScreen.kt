package com.example.jetpack.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack.model.FakeDataSource
import com.example.jetpack.model.Item

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
//    println("I'm in home screen")
    HomeContentWithoutViewModel(
        listData = FakeDataSource.dummyStories,
        modifier = modifier,
        navigateToDetail = navigateToDetail,
    )
}

@Composable
fun HomeContentWithoutViewModel(
    listData: List<Item>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
//    println("I'm in the content listData:${listData}")
    LazyVerticalGrid(
        columns = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(listData) { data ->
            StoriesItem(
                image = data.image,
                title = data.title,
                requiredPoint = data.requiredPoint,
                modifier = Modifier.clickable {
                    navigateToDetail(data.id)
                    println(data.id)
                }
            )
        }
    }
}

@Composable
fun StoriesItem(
    image: Int,
    title: String,
    requiredPoint: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Display the image (you may use Image composable here)
            // Assuming R.drawable.reward_1 is the actual image
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Display the title
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Display the requiredPoint
            Text(
                text = "Required Point: $requiredPoint",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.White
                )
            )
        }
    }
}