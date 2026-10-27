# PRACTICE SOFTWARE TESTING - Selenium Test Automation Framework

A Java based UI test automation framework of Practice Software Testing e-commerce application. It uses Selenium WebDriver, TestNG, Maven, Page Object Model and Apache POI to automate customer registration, login, and an end-to-end product-ordering flow.

The project is developed in Eclipse and is intended as a portfolio project demonstrating browser automation, reusable page objects, Excel-based registration data, TestNG assertions, and parallel cross-browser execution.

## Features

- **Page Object Model (POM):** Page classes encapsulate locators and page-level actions, keeping browser interactions outside the test methods.
- **Cross-browser execution:** The TestNG suite defines Chrome, Firefox, and Microsoft Edge runs using a browser parameter.
- **Parallel browser suites:** The three XML `<test>` blocks are configured to run concurrently with `parallel="tests"`.
- **Excel-driven registration data:** Apache POI reads customer details from an `.xlsx` workbook.
- **Reusable utilities:** Browser setup, dropdown selection, mouse actions & scrolling, property-file reading and Excel reading methods.
- **TestNG assertions:** Tests check login navigation, duplicate-registration validation, the add-to-cart notification, payment confirmation, and the presence of an invoice number.
- **Data-test and ID-based locators:** Locators primarily use element IDs, data-test attributes, and XPath rather than Selenium link-text locators. Visible text is used to select product & language because both remains same even after language change.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | programming language |
| Selenium WebDriver | Browser automation |
| TestNG | Test annotations, assertions & suite execution |
| Apache Maven | Dependency management & build/test execution |
| Apache POI | Reading registration data from Excel |
| Maven Surefire Plugin | Running the configured TestNG suite from Maven and producing test reports |
| Eclipse IDE | Development environment |

## Framework Structure

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
│       │   │   └── BasePage.java
│       │   └── tests/
│       │       ├── AuthenticationTest.java
│       │       └── EndToEndOrderTest.java
│       └── resources/
│           ├── propertyfiles/
│           │   └── config.properties
│           └── testdata/
│               └── userdetails.xlsx
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md


### Detailed Resources Description

- **BasePage** (`src/test/java/base/`): `@BeforeMethod` initializes the configured browser, opens the application, creates page objects, reads registration data, and registers a new user before each test method. `@AfterMethod` closes the browser with `driver.quit()`.
- **Page classes** (`src/main/java/pages/`): `HomePage`, `SignInPage`, `RegistrationPage`, and `CartPage` hold page locators and interactions for the respective parts of the application.
- **Utility classes** (`src/main/java/utilities/`): Provide browser initialization, dropdown actions, scrolling/mouse actions, property reading and Excel reading methods.
- **Test classes** (`src/test/java/tests/`): `AuthenticationTest` contains the login and duplicate-registration scenarios. `EndToEndOrderTest` contains the purchasing workflow.
- **`testng.xml`:** Defines the Chrome, Firefox, and Edge TestNG runs and passes the browser name as a parameter.
- **`pom.xml`:** Declares dependencies and configures Maven Surefire to run `testng.xml`.

## Prerequisites

- JDK 25
- Selenium WebDriver 4.51.0
- TestNG 7.12.0
- Apache POI 5.5.1
- IDE: Eclipse IDE
- Google Chrome, Mozilla Firefox and Microsoft Edge browsers

## Installation & Setup

### Step 1: Clone the Repository

```bash
git clone https://github.com/your-username/practice-software-testing-automation.git
```

### Step 2: Import Project into Eclipse IDE

1. Select **File -> Import...**
2. Select **Existing Maven Projects** -> Click **Next**.
3. Allow Maven to download and index all required dependencies specified in `pom.xml`.
4. Select **Maven -> Update Project...** (or execute `mvn clean install` in a terminal window).

## Test Scope & Test Scenarios

### A. BasePage Architecture

- **Setup:** Contains central `setup()` method annotated with `@BeforeMethod` to initialize WebDriver & implicit/explicit waits.
- **Driver Cleanup:** Implements `teardown()` annotated with `@AfterMethod` to safely close browser sessions via `driver.quit()`.
- **Inheritance:** All test classes inherit from `BasePage`.

### B. Authentication Scenarios

- **Valid Login Test:** Supplies valid credentials, submits form, and validates dashboard navigation using `Assert.assertEquals()`.
- **Duplicate Registration Test:** Attempts registration with pre-existing user details to confirm that system correctly triggers and displays duplicate account validation message.

### C. End-to-End Order Test

The core order execution is implemented in the `orderProduct()` test method annotated with `@Test`. It rigorously simulates a full customer journey from authentication to invoice retrieval:

1. **Authentication:** Performs user login with valid credentials.
2. **Login Assertion:** Validates that authentication succeeded using Assert assertions before navigating further.
3. **Navigation & Selection:** Clicks Home button, browses product catalog, and selects designated product.
4. **Add to Cart:** Clicks 'Add to Cart' button.
5. **Cart Toast Assertion:** Asserts the presence and correctness of the 'Added to cart' pop-up notification message.
6. **Cart Navigation:** Navigates to the shopping cart review screen.
7. **Payment & Checkout:** Completes billing information, selects payment method, and finalizes transaction.
8. **Payment Message Assertion:** Retrieves post-payment confirmation message and verifies using `Assert.assertEquals()`.
9. **Invoice Extraction:** Retrieves and records generated unique Invoice Number for traceability.
10. **Session Teardown:** Executes user logout to conclude clean test execution state.

## How to Run Tests

### Option 1: Execution via Eclipse IDE (TestNG XML)

1. In Eclipse Project Explorer, navigate to the root directory.
2. Right-click on `testng.xml`.
3. Select **Run As -> TestNG Suite**.
4. Inspect results, assertions, and execution timeline in Eclipse TestNG Results view.

### Option 2: Execution via Maven

From the project root, run:

```bash
mvn clean test
```

## Reports

TestNG HTML reports: `index.html`, `emailable-report.html`, `testng-results.xml` these will be present in `test-output/` directory.

## Contact Information

This section serves as a placeholder. Customize these links before publishing to your GitHub profile:

- **Author:** [Your Full Name / QA Automation Engineer]
- **Email:** [your.email@example.com]
- **LinkedIn:** https://www.linkedin.com/in/[your-profile]
- **GitHub:** https://github.com/[your-username]
