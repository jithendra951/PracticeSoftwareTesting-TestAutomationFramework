# PRACTICE SOFTWARE TESTING - Selenium Test Automation Framework

A Java-based UI test automation framework for the Practice Software Testing an e-commerce application. The project uses Selenium WebDriver, TestNG, Maven, Page Object Model (POM), Apache POI and Allure to automate authentication, product ordering, payment workflows, and localization checks.

This repository is a portfolio project demonstrating reusable page objects, Excel-based test data, TestNG assertions, cross-browser execution, failure-screenshot support, and Allure test reporting.

## Features

- **Page Object Model (POM):** Page classes encapsulate locators and page-level interactions, keeping browser operations separate from test methods.
- **Cross-browser execution:** `testng.xml` configures Chrome, Firefox, and Microsoft Edge using TestNG browser parameters.
- **Parallel browser suites:** The three browser `<test>` blocks use `parallel="tests"` with a thread count of three.
- **Excel-based test data:** Apache POI reads registration and localization data from `testdata.xlsx`.
- **Reusable utilities:** Browser initialization, dropdown selection, mouse actions and scrolling, property-file reading, Excel reading, and screenshot capture.
- **Authentication coverage:** Valid login and duplicate-registration validation.
- **Negative login coverage:** Invalid email, Invalid password, empty email field, empty password field, and both fields empty.
- **End-to-end order coverage:** Registration, login, product selection, add-to-cart validation, checkout, cash-on-delivery payment, payment confirmation, and invoice validation.
- **Payment coverage:** Bank transfer, credit card, buy now pay later, and gift card workflows.
- **Localization coverage:** Complete ordering in German, Greek, Spanish, French, Dutch, and Turkish, using expected values from Excel.
- **Failure screenshots:** The base test class attempts to capture a browser screenshot when a test fails.
- **Allure reporting:** The Allure TestNG integration generates result files in `allure-results/` when the TestNG suite is executed. Allure Commandline can serve these results as an interactive report.

## Technology Stack

| Technology / Tool | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test annotations, assertions and suite execution |
| Apache POI OOXML | Reading `.xlsx` test data |
| Apache Maven | Dependency management and test execution |
| Maven Compiler Plugin | Compiles the project for the configured Java release |
| Maven Surefire Plugin | Runs the TestNG suite configured in `testng.xml` |
| Allure TestNG | Collects TestNG execution results and writes them as raw files to the allure-results folder |
| Allure Commandline | Generates and serves the interactive Allure report from the generated results |
| Eclipse IDE | Development environment |

## Framework Structure

```
PracticeSoftwareTesting/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/
│   │       │   ├── CartPage.java
│   │       │   ├── HomePage.java
│   │       │   ├── RegistrationPage.java
│   │       │   └── SignInPage.java
│   │       └── utilities/
│   │           ├── BrowserUtility.java
│   │           ├── DropdownUtility.java
│   │           ├── MouseActionsUtility.java
│   │           ├── ReadDataUtility.java
│   │           ├── ReadPropertyUtility.java
│   │           └── ScreenshotUtility.java
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java
│       │   └── tests/
│       │       ├── AuthenticationTest.java
│       │       ├── EndToEndOrderTest.java
│       │       ├── InvalidLoginTest.java
│       │       ├── LocalizationTest.java
│       │       └── PaymentsTest.java
│       └── resources/
│           ├── propertyfiles/
│           │   └── config.properties
│           └── testdata/
│               └── testdata.xlsx
├── .gitignore
├── pom.xml
├── README.md
└── testng.xml
```

## Detailed Framework Description

- **`BaseTest`** (`src/test/java/base/`): Its `@BeforeMethod` setup initializes the browser specified in the suite, maximizes the window, opens the application URL and initializes the page objects. Its `@AfterMethod` teardown attempts to capture a screenshot on failure and closes the browser using `driver.quit()`. The `completeRegistration()` method performs the complete registration workflow.
- **Page classes** (`src/main/java/pages/`): `HomePage`, `SignInPage`, `RegistrationPage`, and `CartPage` encapsulates page locators and interactions for navigation, authentication, registration, products, cart, checkout, and payment.
- **Utility classes** (`src/main/java/utilities/`): Provides browser initialization, dropdown operations, mouse actions and scrolling, reading configuration properties, reading Excel data, and screenshot capture.
- **Test classes** (`src/test/java/tests/`): Contains authentication, end-to-end ordering, invalid-login, localization, and payment scenarios.
- **`config.properties`**: Stores the application URL, Excel sheet names, product name, and product quantity.
- **`testdata.xlsx`**: Contains the `UserRegistrationDetails` and `LanguageProperties` worksheets.
- **`testng.xml`**: Defines Chrome, Firefox, and Edge test runs and supplies the browser parameter to the test classes.
- **`pom.xml`**: Declares project dependencies, configures Java 25 compilation, and configures Maven Surefire to run `testng.xml`.

## Prerequisites

- JDK 25
- Selenium WebDriver 4.51.0
- TestNG 7.12.0
- Apache POI OOXML 5.5.1
- Maven Compiler Plugin 3.14.1
- Maven Surefire Plugin 3.5.5
- Allure TestNG 3.0.1
- Apache Maven
- Google Chrome, Mozilla Firefox, and Microsoft Edge installed
- Allure Commandline
- Eclipse IDE

## Installation and Setup

### Step 1: Clone the repository

```bash
git clone https://github.com/jithendra951/PracticeSoftwareTesting-TestAutomationFramework.git
```

### Step 2: Import into Eclipse

1. Select **File → Import…**.
2. Choose **Maven → Existing Maven Projects** and click **Next**.
3. Select the project directory and finish the import.
4. Right-click the project and select **Maven → Update Project…** to resolve dependencies.

### Step 3: Check configuration and test data

Review `src/test/resources/propertyfiles/config.properties`. The current properties are:

```properties
url:https://practicesoftwaretesting.com/
registrationsheet:UserRegistrationDetails
languagesheet:LanguageProperties
productname:Claw Hammer with Shock Reduction Grip
productquantity:2
```

The Excel workbook is located at `src/test/resources/testdata/testdata.xlsx`. It contains the `UserRegistrationDetails` and `LanguageProperties` worksheets.

Create a directory named `screenshot` in the project root before running tests.

## Test Scope and Scenarios

The current `testng.xml` includes all five test classes in each of the three browser suites. There are 18 `@Test` methods per browser, giving 54 configured test-method executions overall when all tests run once without retries or data-provider expansion. The three browser suites are configured to run in parallel.

### A. Authentication — `AuthenticationTest`

- **`validLogin`**: Registers a new user, logs in with the generated credentials, validates the `My account` page title, and logs out.
- **`duplicateUserRegistration`**: Attempts registration again using the same generated email and password then validates the duplicate registration error message.

### B. End-to-End Ordering — `EndToEndOrderTest`

- Registers a new user and logs in.
- Selects the product and quantity configured in `config.properties`, then adds the product to the cart.
- Validates the added to cart notification.
- Proceeds to checkout and does payment through cash on delivery.
- Validates the payment success message, validates the invoice number, and logs out.

### C. Negative Login — `InvalidLoginTest`

- Login with an invalid email.
- Login with an invalid password.
- login with an empty email.
- login with an empty password.
- login with both email and password empty.

### D. Localization — `LocalizationTest`

Runs a product ordering workflow with language specific expected values for: German, Greek, Spanish, French, Dutch, and Turkish.
Language, expected account title, and cart messages are read from the `LanguageProperties` worksheet in `testdata.xlsx`.

### E. Payment Methods — `PaymentsTest`

Each test completes registration, login, product selection, cart navigation, and checkout by all of these payment methods:
- Bank transfer
- Credit card
- Buy now pay later
- Gift card

## How to Run Tests

### Option 1: Run through Eclipse

1. In Project Explorer, right-click `testng.xml`.
2. Select **Run As → TestNG Suite**.
3. Review the execution in Eclipse's TestNG Results view.

### Option 2: Run through Maven

From the project root, compile the main and test sources without executing tests:

```bash
mvn clean test-compile
```

Execute the full suite configured in `testng.xml`:

```bash
mvn clean test
```

## Screenshots and Reports

### Failure Screenshots

When a test fails, `BaseTest` attempts to capture a browser screenshot. Screenshots are saved as PNG files in the `screenshot/` directory in the project root.

### TestNG and Maven Reports

- **Eclipse TestNG results:** Available in the TestNG Results view after running `testng.xml` as a TestNG Suite.
- **Maven Surefire reports:** Generated under `target/surefire-reports/` after running `mvn clean test`.
- **TestNG output:** TestNG report files may be generated in `test-output/` when the suite is run directly through Eclipse.

### Allure Reports

The project includes the `allure-testng` dependency. After running `testng.xml` as a TestNG Suite in Eclipse, the Allure integration generates raw test result files in the `allure-results/` directory in the project root.

To open the interactive Allure report:

1. Make sure Allure Commandline is installed
2. Open a terminal in the project root, where the `allure-results/` directory is located.
3. Run:

```bash
allure serve allure-results
```

Allure serves the report locally and opens it in a browser. Keep the terminal running while viewing the report.