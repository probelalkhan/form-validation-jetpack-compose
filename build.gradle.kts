plugins {
    id("com.android.application") version ("7.3.0") apply false
    id("com.android.library") version ("7.3.0") apply false
    id("org.jetbrains.kotlin.android") version ("1.8.10") apply false
}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions.freeCompilerArgs += listOf(
            "-Xopt-in=androidx.compose.material3.ExperimentalMaterial3Api",
            "-Xjvm-default=all"
        )
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}