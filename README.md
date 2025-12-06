# i75league-testing

This repo exists mainly to showcase how a team can plug into a shared Java/Selenium automation library and run UI/API tests using Selenium + JUnit.

For actual production UI testing within the I75 League ecosystem, the strongly recommended approach is to use **front-end–native E2E tools** such as Playwright, Cypress, or WDIO-style APIs in the main application—since they provide the best developer experience and the most stable results for modern React/Next.js applications.

- Framework repo: https://github.com/Afroid/automation-framework
- Front-end app: https://github.com/Afroid/i75-recap-site
- Front-end E2E test suites:
  - Playwright + WDIO: https://github.com/Afroid/i75-recap-site/tree/main/tests/e2e
  - Cypress: https://github.com/Afroid/i75-recap-site/tree/main/cypress

---

## How it consumes `automation-framework`

`pom.xml` includes:

```
<dependency>
  <groupId>com.afroid</groupId>
  <artifactId>automation-framework</artifactId>
  <version>0.2.0</version>
</dependency>
```
Key pieces from the framework that are used here:
- UiTestBase – base class for UI tests (driver setup/teardown)
- WebDriverFactory – multi-browser WebDriver creation
- TestConfig – shared config: baseUrl, apiBaseUrl, browser, headless, timeoutSeconds

UI tests in this project extend `UiTestBase` and use `TestConfig.getBaseUrl()` to open the site.
API tests use the same `TestConfig.getApiBaseUrl()` value.

## Running tests
**Default (Chrome, headless)**
```
mvn clean test
```

**Defaults (from the framework)**:
- browser=chrome
- headless=true
- baseUrl=https://www.i75league.com
- apiBaseUrl=https://jsonplaceholder.typicode.com

**Show the browser (non-headless)**
```
mvn clean test -Dheadless=false
```

**Run against a different browser**
Firefox (requires Firefox installed):
```
mvn clean test -Dbrowser=firefox -Dheadless=true
```

**Edge (Windows runners / local Edge install)**:
```
mvn clean test -Dbrowser=edge
```

**Override the base URL (local dev, etc.)**
```
mvn clean test -DbaseUrl=http://localhost:3000
```

## Requirements
- Java 17
- Maven
- Access to GitHub Packages (for the automation-framework dependency)
- Browsers installed locally if you want to run UI tests for that browser (Chrome/Edge/Firefox)

CI (e.g., GitHub Actions) can run these tests headless using the same mvn clean test commands with appropriate -D overrides.
