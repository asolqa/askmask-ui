# Web UI test automation project for [AskMask.ru](http://askmask.ru)

---

AskMask is a large online store for Asian cosmetics and official distributor for top Korean and Japanese 
brands in Russia

<a href="http://askmask.ru"><img src="./media/askmask_logo.png"/></a>

---


## Content:

- <a href="#tools">Tools and technologies</a>
- <a href="#facts">Project features</a>
- <a href="#scenarios">Test scenarios</a>
- <a href="#cli">Launch from the CLI</a>
- <a href="#jenkins">CI/CD with Jenkins</a>
- <a href="#allure">Allure reporting</a>
- <a href="#allure-testops">Integration with Allure TestOps</a>
- <a href="#jira">Integration with JIRA</a>
- <a href="#telegram">Bot notifications in Telegram</a>
- <a href="#video">Examples of test execution</a>


<a id="tools"></a>
## Tools and technologies
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="./media/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="./media/logo/java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="./media/logo/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="./media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="./media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="./media/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="./media/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="https://github.com/allure-framework/allure2"><img src="./media/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="./media/logo/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="./media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="./media/logo/JIRA.svg" width="50" height="50"  alt="Jira"/></a>
</p>

<a id="facts"></a>
## Project features
* `Page Object` pattern
* Config with `Owner` library
* Tests parametrization
* `Allure` reporting with logged tests information
* Manual tests in code for future automation
* Launch all or separate tests from `Allure TestOps` directly
* `JIRA` integration
* Telegram notifications

<a id="scenarios"></a>
## Test Scenarios
* [x] Verify main page elements
* [x] Verify official brands are shown in the brand menu (parametrized)
* [x] Verify contact page contains actual information
* [x] Verify subscription is available
* [x] Verify subscription error without e-mail
* [x] Verify search for product works as expected
* [x] Verify empty search for brand which is not presented 
* [x] Verify blog page contains article about niacinamide
* [x] Verify basket is empty when no products were added (manual)
* [x] Verify auth error with incorrect password (manual in code)



<a id="cli"></a>
## <img alt="cli" height="25" src="./media/logo/run.png" width="25"> Launch from the CLI

**Local launch:**
```bash  
./gradlew clean askmask_smoke_test Denv=local
```

**Remote launch:**
```bash  
./gradlew clean askmask_smoke_test Denv=remote
```

All browser configurations are described in the `common-config.propeties`, `local.properties` and `remote.properties` files.
If needed configurations could be changed in those files.

Properties file config explanation:
- `browser` (browser for UI tests, chrome is supported)
- `browser.version` (version of browser for UI tests)
- `browser.size` (size of browser for UI tests)
- `base.url` (URL for UI tests)
- `page.load.strategy` (how web driver handles the loading of new page, by default is `eager`)
- `remote.url` (URL for remote WebDriver)
- `remote.mode.enabled` (defines local or remote environments)

<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="./media/logo/Jenkins.svg" width="25"/></a><a name="CI/CD with Jenkins"></a>CI/CD with [Jenkins](https://jenkins.autotests.cloud/job/26-asolqa-allure-example/)</a>
<img alt="Jenkins" src="./media/reports/Jenkins.png"> 

### Jenkins job parameters:

- `COMMENT` (by default @asolqa is tagged)

After the build is done the test results are available in `Allure`, `Allure TestOps` and `JIRA`

<a id="allure"></a>
## <img alt="Allure" height="25" src="./media/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [reporting](https://jenkins.autotests.cloud/job/26-asolqa-allure-example/allure/)</a>
<img alt="Allure" src="./media/reports/AllureReportExample.png"> 

`Allure` report includes:
- Test steps
- Screenshot of the page at the last step
- Page Source
- Browser console logs
- Video of execution for automated tests

<img alt="Allure2" src="./media/reports/AllureReportExample2.png">

<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="./media/logo/AllureTestOps.svg" width="25"/></a> Integration with <a target="_blank" href="https://allure.autotests.cloud/project/4237/dashboards">Allure TestOps</a>

`Allure TestOps` processes tests as a documentation and synchronizes automated and manual verifications. 
Here all test cases execution results are available. 

Dashboard contains test runs statistics:
<img alt="Dashboard" src="./media/reports/Dashboard.png">

There is custom Dashboard data:
<img alt="Launch" src="./media/reports/TestOpsCustomDashboard.png">

Automated cases:
<img alt="Cases1" src="./media/reports/TestOpsAutomated.png">

Manual cases:
<img alt="Cases2" src="./media/reports/TestOpsManual.png">

Manual cases added from the code for future automation:
<img alt="Cases2" src="./media/reports/TestOpsManualCode.png">

Launches:
<img alt="Launch" src="./media/reports/Launches.png">



<a id="jira"></a>
## <img alt="Allure" height="25" src="./media/logo/JIRA.svg" width="25"/></a> Integration with <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1202">Jira</a>

`Jira` has information about all related test launches results from `Allure TestOps`:

<img alt="JIRA" src="./media/reports/JIRA.png">

<a id="telegram"></a>
## <img alt="Allure" height="25" src="./media/logo/Telegram.svg" width="25"/></a> Bot notifications in Telegram
After every build Telegram bot sends notification with `Allure` report:
<img alt="Bot" src="./media/reports/Telegram_screen.png"> 

<a id="video"></a>
## <img alt="Selenoid" height="25" src="./media/logo/Selenoid.svg" width="25"/></a> Examples of test execution
<img alt="Video" src="./media/video/Subscription_video.gif"> 








