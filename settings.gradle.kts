pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google();
        mavenCentral();
        //noinspection JcenterRepositoryObsolete
        jcenter()
        maven { url = uri ("https://jitpack.io") };




    }
}

rootProject.name = "daneshjooyarApp"
include(":app")
 