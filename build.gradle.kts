plugins {
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    kotlin("js") version "1.7.21"
    kotlin("plugin.serialization") version "1.7.21"
}

group = "com.ecosave.watch"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

fun kotlinw(target: String): String =
    "org.jetbrains.kotlin-wrappers:kotlin-$target"

dependencies {
    testImplementation(kotlin("test"))
    implementation(enforcedPlatform(kotlinw("wrappers-bom:1.0.0-pre.456")))
    implementation(kotlinw("react"))
    implementation(kotlinw("react-dom"))
    implementation(kotlinw("react-router-dom"))
    implementation(kotlinw("emotion"))
    implementation(kotlinw("mui"))
    implementation(kotlinw("mui-icons"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")

    implementation(npm("recharts", "2.1.16"))
    implementation(npm("validator", "13.7.0"))
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport(Action { true })
            }
        }
    }
}