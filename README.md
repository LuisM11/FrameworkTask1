## Versions 
* Chrome 119.0.6045.199
* Firefox 115.5.0
* Selenium 4.15.0
* Java 17

## How to run?
```
 mvn clean test
```
Some system properties are set using surefire plugin, these are:
  - **browser**: default to 'chrome' (the others are 'firefox', 'edge')
  - **env**: default to 'prod' (the other is 'qa').

> [!NOTE]
> *  Production environment is the current context which is being tested, but it implies impredictable ads in some pages like Yopmail, so to avoid this, an adblocker was only added to chrome in the prod environment.

It's possible to specify a path with a concrete test suit, for example with smoke tests.

```
  mvn -Dbrowser=firefox -Denv=qa -Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml clean test

```

> [!CAUTION]
> Some errors or bugs appear when executing the project.
> *  An exception is always thrown at the end of the program  with Firefox (it doesn't interfer with the script or test)
>   ```
>   Dec 07, 2023 1:05:28 AM org.openqa.selenium.os.ExternalProcess$Builder lambda$start$0
>    WARNING: failed to copy the output of process 12322
>    java.io.IOException: Stream closed
>   
>   ```

