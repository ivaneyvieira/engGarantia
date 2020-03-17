import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val vaadinonkotlin_version = "0.8.1"
val vaadin10_version = "14.1.16"

plugins {
  kotlin("jvm") version "1.3.61"
  id("org.gretty") version "3.0.1"
  war
  id("com.vaadin") version "0.6.0"
}

defaultTasks("clean", "vaadinBuildFrontend", "build")

repositories {
  mavenCentral()
  jcenter() // for Gretty runners
  maven {
    url = uri("https://maven.vaadin.com/vaadin-addons")
  }
}

gretty {
  contextPath = "/"
  servletContainer = "jetty9.4"
}
val staging by configurations.creating

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    // to see the exceptions of failed tests in Travis-CI console.
    exceptionFormat = TestExceptionFormat.FULL
  }
}

dependencies {
  // Vaadin-on-Kotlin dependency, includes Vaadin
  implementation("eu.vaadinonkotlin:vok-framework-v10-vokdb:$vaadinonkotlin_version")
  // Vaadin 14
  implementation("com.vaadin:vaadin-core:$vaadin10_version") {
    // Webjars are only needed when running in Vaadin 13 compatibility mode
    listOf("com.vaadin.webjar", "org.webjars.bowergithub.insites",
           "org.webjars.bowergithub.polymer", "org.webjars.bowergithub.polymerelements",
           "org.webjars.bowergithub.vaadin", "org.webjars.bowergithub.webcomponents")
      .forEach {exclude(group = it)}
  }
  providedCompile("javax.servlet:javax.servlet-api:3.1.0")
  
  implementation("com.zaxxer:HikariCP:3.4.1")
  // logging
  // currently we are logging through the SLF4J API to LogBack. See src/main/resources/logback.xml file for the logger configuration
  implementation("ch.qos.logback:logback-classic:1.2.3")
  implementation("org.slf4j:slf4j-api:1.7.30")
  
  implementation(kotlin("stdlib-jdk8"))
  // db
  implementation("mysql:mysql-connector-java:5.1.48")
  implementation("org.apache.commons:commons-dbcp2:2.3.0")
  implementation("org.sql2o:sql2o:1.5.4")
  implementation("com.zaxxer:HikariCP:3.4.1")
  // test support
  testImplementation("com.github.mvysny.kaributesting:karibu-testing-v10:1.1.19")
  testImplementation("com.github.mvysny.dynatest:dynatest-engine:0.15")
  //Plugin vaadin
  //implementation("com.flowingcode.addons.applayout:app-layout-addon:3.0.0")
  implementation("com.github.appreciated:app-layout-addon:4.0.0.rc5")
  compile("org.claspina:confirm-dialog:2.0.0")
  //Util
  compile("org.sql2o:sql2o:1.6.0")
  compile("mysql:mysql-connector-java:5.1.48")
  compile("com.zaxxer:HikariCP:3.4.1")
  compile("org.imgscalr:imgscalr-lib:4.2")
  compile("com.jcraft:jsch:0.1.55")
  compile("org.cups4j:cups4j:0.7.6")
  // heroku app runner
  staging("com.github.jsimone:webapp-runner-main:9.0.27.1")
}

vaadin {
  if(gradle.startParameter.taskNames.contains("stage")) {
    productionMode = true
  }
}
