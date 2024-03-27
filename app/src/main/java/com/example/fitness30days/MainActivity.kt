package com.example.fitness30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitness30days.data.Datasource
import com.example.fitness30days.model.Exercise
import com.example.fitness30days.ui.theme.Fitness30DaysTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Fitness30DaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Fitness30DaysApp()
                }
            }
        }
    }
}

@Composable
fun Fitness30DaysApp() {
    ExerciseList(exerciseList = Datasource().loadExercises())
}

@Composable
fun ExerciseList(exerciseList: List<Exercise>, modifier : Modifier = Modifier) {
    Scaffold(
        topBar = {
            FitnessAppTopBar()
        }
    ) {
        it -> LazyColumn(contentPadding = it, modifier = modifier) {
        itemsIndexed(exerciseList) { index, exercise ->
            ExerciseCard(
                dayNumber = index + 1,
                exercise = exercise,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
    }

}

@Composable
fun ExerciseCard(dayNumber: Int, exercise: Exercise, modifier: Modifier = Modifier) {

    var isVisible by remember { mutableStateOf(false) }

    Card(
        modifier = modifier.clickable { isVisible = !isVisible }
    ) {
        Column {
            Text(
                text = "Day $dayNumber",
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium)),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = LocalContext.current.getString(exercise.stringResourceId).substringBefore(":"),
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium)),
                style = MaterialTheme.typography.displayLarge
            )
            Image(
                painter = painterResource(exercise.imageResourceId),
                contentDescription = stringResource(exercise.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                contentScale = ContentScale.Crop,

            )

            AnimatedVisibility(
                visible = isVisible,
                enter = fadeIn(initialAlpha = 0.0f),
                exit = fadeOut(targetAlpha = 0.0f)
            ) {
                Text(
                    text = LocalContext.current.getString(exercise.stringResourceId),
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium)),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessAppTopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.fitness_app_logo),

                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Fitness30DaysTheme {
        Fitness30DaysApp()
    }
}