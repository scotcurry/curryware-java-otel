# Overview

REST API service.  Calls the Chuck Joke Database and builds out telemetry.

## Project Structure - (i.e. files you might find interesting)
```
build.gradle (See Versioning)
|
. -./scr/main/java/org.currywarejavaotel
. -- CurrywareJavaOtelApplication (application launch)
. -- build.gradle (need to update the version for source code integration)
. -/src/main/java/resources
. -- logback-spring.xml (logging configuration)
```

## Interesting points
### Versioning
* Pass the version in with the gradlew build command.  Going to need this with the build
```
./gradlew -PprojVersion=0.23.6 build
```
This goes with the code in the build.gradle file.
```
if (project.hasProperty('projVersion')) {
    project.version = project.projVersion
} else {
    project.version = '1.2.3'
}
```

## Running the app from the IDE
```
./gradlew bootRun
```

## Changes from the base Intellij Project
* Add implementation dependencies for:
  * gson
  * logstash encoder
  * spring-boot-starter-web