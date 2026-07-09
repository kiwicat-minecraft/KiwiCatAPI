## Adding the API as a dependency
> Old Versions of the Mod required GitHub Packages. 
> This is no longer needed.




Add to your build.gradle: 
```js
repositories {
    maven {
        url = uri("https://kiwicat.cat/")
    }
}
```

And add:
```js
dependencies {
	modImplementation("cat.kiwicat:kiwicatapi:${project.kiwi_version}")
}
```
to your dependencies in build.gradle.

Then you also need to add:
```js
kiwi_version=1.1.5
```
to your gradle.properties file

> to see the latest Version look [here](https://kiwicat.cat/cat/kiwicat/kiwicatapi/maven-metadata.xml)!
## Using The API
### UwUfier
To use the UwUfier you can use the uwufy method:
```java
String uwufied = UwUifier.uwuify("Hello I will be UwU!");
```

### Skin Change API
To change the Skin from a Player  you first need to register a Provider.

To do this add a Manager class that implements *Skin Manager*:
```java
public class TestManagerImpl implements SkinManager {
    @Override
    public List<SkinInfo> getSkins() {
        return TestModClient.testList;
    }
}
```
The Return Value can be any List with SkinInfo's in them. This will be the List the API uses and requests every Frame.

Then add a Provider Class that implements *Skin Provider*:
```java
public class TestSkinProvider implements SkinProvider {  
    @Override  
    public SkinManager create() {  
        return new TestManagerImpl();  
    }
}
```

This class gets called from the API and returns the Manager.

You need to add SkinInfo objects to the List you return in the Manager. SkinInfo objects consist of the Identifier of the Texture for the Skin, the username (String) of the affected Player and a boolean if the Model should be Slim.

If you want a Blacklist you simply do:
```java
KiwiCatAPIClient.blacklist = true;
```
after adding someone. This will make it so that instead of only changing the Skin of the People in the List, it changes everyone to the first Skin in the List except the client and the People in the List.

>Note: at this Time its not encouraged to use the Blacklist if you want better Compatibility with other Mods using the API
