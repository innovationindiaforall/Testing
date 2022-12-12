------------------------------------------------------------
INSTRUMENTATION TESTING:
------------------------------------------------------------
//Functional tests(Integration, UI)
src/androidTest/java

Instrumentation tests case run on a android device or an emulator.

In the background, out app will be installed and then a testing app will also be installed,
which will control our app, launching it and running UI tests as needed.

Instrumentation tests can be used to test none UI related logic also.

Especially useful when we need to test code that has a dependency on a context.
Especially useful to launch particular activity seperately and will test it UI related functionality.

i have used this dependencies in my Android Studio(BumbleBee) Project with Java11.
androidTestImplementation 'androidx.test.ext:junit:1.1.3'
androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
androidTestImplementation 'androidx.test:rules:1.5.0'

AndroidStudio-File-Settings-Build,Execution,Deployment-BuildTools-Gradle-we have to select 11 version Jre file from Program Files under c folder.
------------------------------------------------------------
Unit Test:
------------------------------------------------------------
//Unit tests
src/test/java

Unit Test cased runs on local JVM machine in Android Studio itself, without emulator or mobile device.
