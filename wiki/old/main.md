## Adding the API as a dependency
Because i use Maven on GitHub you need to have a GitHub Token set up.
To do that you need to create a gradle.properties file in ``~/.gradle`` on Linux and ``C:\Users\<USERNAME>\.gradle`` on Windows.

In that file you need to put your GitHub Username and Token like this:
```js
gpr.user=[username]
gpr.key=[token]
```

To get a Token visit [Make Token](https://github.com/settings/tokens) and create a classic Token with the Persmission `read:packages` and `repo` . Don't gives this Token to anyone! 

Then add to your build.gradle: 
```js
repositories {
    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/kiwicat-minecraft/KiwiCatAPI")

        credentials {
            username = project.findProperty("gpr.user")
            password = project.findProperty("gpr.key")
        }
    }
}
```

And add:
```js
dependencies {
	modImplementation "cat.kiwicat.kiwicatapi:kiwicatapi:1.1.3"
}
```
to your dependencies in build.gradle.

## Using The API
### UwUfier
To use the UwUfier you can use the uwufy method:
```java
String uwufied = UwUifier.uwuify("Hello I will be UwU!");
```

### Skin Change API
To change the Skin from a Player  just add them to the SkinChanges list:
```java
KiwiCatAPIClient.SkinChanges.add(new SkinInfo([identifier], [username], [isSlim]));
```
You need to add a new SkinInfo that contains the Identifier of the Texture for the Skin, the username of the Player you want to change and a boolean on if the Model should be Slim or Wide.

Its recommended to clear the SkinChanges list everytime before adding something. This also makes it so that for the Moment you will probably not be able to use this with another Mod that uses it.

If you want a Blacklist you simply do:
```java
KiwiCatAPIClient.blacklist = true;
```
after adding someone. This will make it so that instead of only changing the Skin of the People in the List, it changes everyone to the first Skin in the List except the client and the People in the List.
