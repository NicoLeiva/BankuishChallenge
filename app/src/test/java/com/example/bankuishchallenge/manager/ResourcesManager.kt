package com.example.bankuishchallenge.manager

import java.io.File

object ResourcesManager {
    private const val RESOURCES_URI = "src/test/java/com/example/bankuishchallenge/resources"

    fun loadResource(filename: String): String {
        return File(
            RESOURCES_URI,
            filename
        ).readText()
    }
}