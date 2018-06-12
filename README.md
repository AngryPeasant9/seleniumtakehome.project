# SeleniumFacebook
Take home selenium eval.
Note this only confirmed to work for Widows OS.

Dependencies:
1. Java Version 1.8.0_91
  * You can download and install from here - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
2. Latest version of Gradle
  Since we are on Windows OS:
  If you have chocolatey simply run: "choco install gradle" with elevated priveleges from the cmdprompt.
  Otherwise you'll need to follow the instructions here to install manually. https://docs.gradle.org/current/userguide/installation.html#sec:prerequisites

To Run:
 * Simply download, extract, and cd to the project directory with cmdprompt and run "gradle build" and "gradle test".
 * By default, since the original json usernames and passwords are all failing logins you won't be able to login and it will fail.
 * To Test real functioning logins just replace the example usernames and passwords or add more in the tests.json file located in the root of the project.

