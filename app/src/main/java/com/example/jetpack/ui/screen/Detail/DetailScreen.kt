package com.example.jetpack.ui.screen.Detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpack.R
import com.example.jetpack.model.FakeDataSource
import com.example.jetpack.ui.theme.JetpackTheme

data class Reward(
    val image: Int,
    val title: String,
    val requiredPoint: Int
)

//@Composable
//fun DetailScreen(
//    storyId: Long,
//    navigateBack: () -> Unit,
//) {
//    val reward = Reward(
//        image = R.drawable.reward_4,
//        title = "Jaket Hoodie Dicoding",
//        requiredPoint = 7500
//    )
//
//    DetailContent(
//        image = reward.image,
//        title = reward.title,
//        basePoint = reward.requiredPoint,
//        onBackClick = navigateBack,
//        modifier = Modifier.fillMaxSize()
//    )
//}

@Composable
fun DetailScreen(
    storyId: Long,
    navigateBack: () -> Unit,
) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val arguments = navBackStackEntry?.arguments
//    val storyId = arguments?.getLong("storyId") ?: -1L

    val reward = FakeDataSource.dummyStories.find { it.id == storyId }

    if (reward != null) {
        DetailContent(
            image = reward.image,
            title = reward.title,
            basePoint = reward.requiredPoint,
            onBackClick = navigateBack,
            modifier = Modifier.fillMaxSize()
        )
    } else {
        println("failed to get data")
    }
}

@Composable
fun DetailContent(
    @DrawableRes image: Int,
    title: String,
    basePoint: Int,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .height(400.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                )
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { onBackClick() }
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Text(
                    text = stringResource(R.string.app_name, basePoint),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = stringResource(R.string.lorem_ipsum),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify,
                )
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
            .background(Color.LightGray))
        Column(
            modifier = Modifier.padding(16.dp)
        ) {}
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DetailContentPreview() {
//    JetpackTheme {
//        DetailScreen(
//
//        )
//    }
//}


