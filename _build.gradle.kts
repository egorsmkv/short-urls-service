//import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
//import org.jetbrains.kotlin.config.KotlinCompilerVersion
//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//
//plugins {
//    id("application")
//    id("org.jetbrains.kotlin.jvm") version "1.3.61"
//    id("com.github.johnrengelman.shadow") version "5.2.0"
//}
//
//group = "com.egorsmkv.short_urls_service"
//version = "1.0.0"
//
//application {
//    mainClassName = "com.egorsmkv.short_urls_service.StartKt"
//    applicationName = "short_urls_service"
//    executableDir = "./build/install/short_urls_service"
//}
//
//repositories {
//    jcenter()
//    maven("https://jitpack.io")
//    mavenCentral()
//}
//
//dependencies {
//    val kotlin_version = "1.3.61"
//    val alpas_version = "0.13.0"
//
//    implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))
//    implementation("dev.alpas:framework:$alpas_version")
//    implementation("ch.qos.logback:logback-classic:1.3.0-alpha5")
//    implementation("mysql:mysql-connector-java:8.0.19")
//    implementation(kotlin("reflect", version = kotlin_version))
//
//    testImplementation("dev.alpas:pulsar:$alpas_version")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
//}
//
//tasks.withType<KotlinCompile> {
//    kotlinOptions.jvmTarget = "1.9"
//}
//
//tasks.withType<Test> {
//    useJUnitPlatform()
//}
//
//tasks.named<ShadowJar>("shadowJar") {
//    destinationDirectory.file("./")
//    archiveBaseName.set("short_urls_service")
//    //archiveClassifier.set(null)
//    //archiveVersion.set(null)
//
//    manifest {
//        attributes(mapOf("Main-Class" to "com.egorsmkv.short_urls_service.StartKt"))
//    }
//}
