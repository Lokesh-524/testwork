Framework Main Components:

       1.  testng.xml (Path - testSuites)
       2.  BaseRunner -> setEnvDetails (Path - src/test/java/testRunner)
       3.  Tags -> Tags mentioned in 'CucumberOptions' (Path - src/test/java/testRunner)
       4.  BaseRunner -> Initiate test cases (Path - src/test/java/testRunner)
       5.  ExtentReports -> generates execution report  (Path Reports/ExtentReport)
       6.  Hooks -> beforeScenario (Path - src/test/java/steps)
       7.  BrowserFactory -> creates browser driver (Path - src/main/java/base)
       8.  Feature files -> create scenarios (Path - src/test/resources/features)
       9.  Step Definitions -> create step definition (Path - src/test/java/steps)
       10. Pages -> page locators and methods/ actions for pages (Path - src/test/java/com.qt.pages)
       11. ExtentLogger -> generates extent log (Path - Reports/ExtentLoggerReport)
       
       
       Execution:
       You can run using just Maven command as "mvn clean install"
       
       OR
       
       Right click on the project -> Run As -> 3Maven build and set the goal as "clean install"
       
       
       *On test failure, screenshot will be automatically captured and added to extent report
       *Extent report will contain all the screenshots including log messages
       
       

 