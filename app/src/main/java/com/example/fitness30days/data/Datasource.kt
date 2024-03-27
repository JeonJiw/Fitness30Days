package com.example.fitness30days.data

import com.example.fitness30days.R
import com.example.fitness30days.model.Exercise

class Datasource() {
    fun loadExercises() : List<Exercise>{
        return listOf<Exercise>(
            Exercise(R.string.exercise1, R.drawable.image1),
            Exercise(R.string.exercise2, R.drawable.image2),
            Exercise(R.string.exercise3, R.drawable.image3),
            Exercise(R.string.exercise4, R.drawable.image4),
            Exercise(R.string.exercise5, R.drawable.image5),
            Exercise(R.string.exercise6, R.drawable.image6),
            Exercise(R.string.exercise7, R.drawable.image7),
            Exercise(R.string.exercise8, R.drawable.image8),
            Exercise(R.string.exercise9, R.drawable.image9),
            Exercise(R.string.exercise10, R.drawable.image10),
            Exercise(R.string.exercise11, R.drawable.image11),
            Exercise(R.string.exercise12, R.drawable.image12),
            Exercise(R.string.exercise13, R.drawable.image13),
            Exercise(R.string.exercise14, R.drawable.image14),
            Exercise(R.string.exercise15, R.drawable.image15),
            Exercise(R.string.exercise16, R.drawable.image16),
            Exercise(R.string.exercise17, R.drawable.image17),
            Exercise(R.string.exercise18, R.drawable.image18),
            Exercise(R.string.exercise19, R.drawable.image19),
            Exercise(R.string.exercise20, R.drawable.image20),
            Exercise(R.string.exercise21, R.drawable.image21),
            Exercise(R.string.exercise22, R.drawable.image22),
            Exercise(R.string.exercise23, R.drawable.image23),
            Exercise(R.string.exercise24, R.drawable.image24),
            Exercise(R.string.exercise25, R.drawable.image25),
            Exercise(R.string.exercise26, R.drawable.image26),
            Exercise(R.string.exercise27, R.drawable.image27),
            Exercise(R.string.exercise28, R.drawable.image28),
            Exercise(R.string.exercise29, R.drawable.image29),
            Exercise(R.string.exercise30, R.drawable.image30)
        )
    }
}