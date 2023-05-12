# Quick start example for Android
<p>This project helps you get started integrating the current web-codeless SDK on Android.</p>

# Description
<p>The package contains a brief working example integrating the SDK with one data vendor.
Replace the values key, journey token, and journey data with the proper values relevant to your application.</p>

# Getting started
- Ensure you have Android Studio Flamingo version 2022.2.1 or above installed on your computer.<br />
- Download the Quick App Android project files from the repository.<br />
- To install the Alloy SDK package you will need to open settings.gradle and add a valid github user and a personal access token<br />
```
maven {
    url "https://maven.pkg.github.com/UseAlloy/alloy-codeless-lite-android"
    credentials {
        username = "<Your GitHub username>"
        password = "<a GitHub personal access token>"
    }
}
```
- Run the project one time without changes to be sure the package has been properly installed.<br />
- Review the code<br />
- Update the values for the key, journey token, and journey data to match your requirements <br />
- Run it on an actual device to test.<br />

# Usage
Once everything is working, change production to true before releasing your application.
