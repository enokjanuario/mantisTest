
## _A test case suite for the Mantis task management system._

<p align="center">
  <a href="https://www.selenium.dev/">
    <img src="https://media.dev.to/cdn-cgi/image/width=1000,height=420,fit=cover,gravity=auto,format=auto/https%3A%2F%2Fdev-to-uploads.s3.amazonaws.com%2Fuploads%2Farticles%2Fznde9s4sx4iysia7doil.png" alt="Selenium" width="15%" />
  </a>
  <a href="https://www.oracle.com/java/technologies/javase-downloads.html">
    <img src="https://files.tecnoblog.net/wp-content/uploads/2016/01/java_capa.jpg" alt="Java" width="11%" />
  </a>
  <a href="https://maven.apache.org/">
    <img src="https://miro.medium.com/v2/resize:fit:1400/1*cLum_fHzsp_7mx29fHw-nA.png" alt="Maven" width="18%" />
  </a>
  <a href="https://www.jetbrains.com/idea/">
    <img src="https://miro.medium.com/v2/resize:fit:1144/1*Xhct1rcbMzmbedNWfwLxIw.png" alt="IntelliJ IDEA" width="15%" />
  </a>
</p>


## Installation Guide for Dependencies and Tools

### 1.  **Java JDK Installation** The test project uses Java as the main programming language. Follow these steps to configure it:
1. Download the latest version of the [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Install the JDK according to your operating system (Windows, macOS, or Linux).
3. Verify the installation by opening the terminal and typing the command:

   `bash java -version`

If Java is correctly installed, the command will return the installed version.

### 2. **Maven Setup**

Maven is used to manage project dependencies. Follow these steps to install it:

1.  Download [Apache Maven](https://maven.apache.org/download.cgi).
2.  Extract the downloaded file and configure the environment variables by adding the Maven path to the `PATH` variable.
3.  Verify the installation by running:

    `mvn -version`

### 3. **GeckoDriver/ChromeDriver Installation**

The project uses Selenium WebDriver for browser automation. Depending on the browser used, install the corresponding driver:

-   **GeckoDriver (Firefox)**

    1.  Download the latest version of [GeckoDriver](https://github.com/mozilla/geckodriver/releases).
    2.  Extract the executable and add it to your system `PATH`.
-   **ChromeDriver (Google Chrome)** [USED]

    1.  Download the ChromeDriver. [as needed]
    2.  Extract the executable and add it to your system `PATH`.

Ensure the Selenium WebDriver can control the browser by verifying the browser version and ensuring the driver is compatible.

### 4. **IDE Installation**

The recommended IDE for this project is **IntelliJ IDEA**, which natively supports Java projects and integrates well with Maven:

1.  Download and install [IntelliJ IDEA](https://www.jetbrains.com/idea/).
2.  Open the IDE and import the project as a **Maven** project.
3.  Ensure that dependencies from `pom.xml` are automatically downloaded.

### 5. **Project Dependencies**

The project is configured with Maven, so all dependencies will be automatically resolved and downloaded by running:

`mvn clean install`

Key dependencies include:

-   **Selenium**: For browser automation.
-   **JUnit/TestNG**: For running unit tests.
-   **Allure** (optional): For generating test reports.

### 6. **Additional Configuration**

-   Ensure the environment variables `MANTIS_USERNAME`, `MANTIS_PASSWORD`, and `USER` are correctly set, as described earlier.
-   Adjust automatic download permissions in the browser used for tests (for Firefox, these permissions can be managed through the Firefox profile).

### 7. **Running the Tests**

To run the project's tests, use the following command in the terminal, from the project's root directory:

`mvn test`

# Automation Framework Documentation

## Project Architecture

The automation framework uses the **Page Object Model (POM)** pattern, where each page of the web application is represented by a class. This pattern organizes the code in a modular way, keeping the navigation/interaction logic separate from the test logic. This approach makes the maintenance and scalability of automated tests easier, allowing for the reuse of page methods across different test scenarios.

## File Structure

- **CreateIssuePage**: Contains methods to interact with the issue creation page, including functions to select the category, enter a summary and description, and create a new issue.
- **DashboardPage**: Provides interactions with the main dashboard of the application, such as navigating between sections like "My Vision", issue creation, changelog, and planning.
- **LoginPage**: Allows the user to log into the system, with additional options like "Forgot Password" and creating new accounts.
- **MyAccountPage**: Displays user account information and associated projects.
- **RegisterPage**: Implements the functionality for user registration in the system.
- **ViewIssuesPage**: Implements functionalities related to viewing issues, such as displaying the priority of the first issue and exporting data to Excel.

## Patterns Used

1. **Page Object Model (POM)**:  
   All interactions with the user interface (UI) are encapsulated within page classes, promoting code reuse and simplifying future changes in the page structure without directly impacting the tests.

2. **Use of `WebDriverWait`**:  
   The code utilizes explicit waits to ensure elements are visible or clickable before interacting with them. This improves test stability by avoiding intermittent failures due to synchronization issues between Selenium and the web application.

3. **`@FindBy` Annotations**:  
   All page elements are located using the `@FindBy` annotations, utilizing various selectors such as `xpath`, `id`, and `css`. This keeps the code clean, improves readability, and centralizes the points where elements are mapped.

4. **Exception Handling**:  
   Exceptions such as `NoSuchElementException` are properly handled in cases where elements may not be present on the page, preventing unexpected failures from interrupting tests.

5. **Use of `Select`**:  
   Interaction with dropdowns is handled using the `Select` class, allowing values to be selected by index or visible text. This makes the code more flexible and adaptable to different test scenarios.

## Decision Making

1. **Use of XPath and CSS Selectors**:  
   Element selectors such as XPath were used in some cases, while others use IDs or classes. XPath is helpful when IDs or classes are unavailable, but whenever possible, more robust selectors such as `id` and `name` should be preferred.

2. **Handling Conditional Elements**:  
   To manage elements that may not be present, as seen in the `getPriorityOfFirst()` method of the `ViewIssuesPage`, a `try-catch` block was implemented to capture missing element exceptions. This prevents unnecessary failures and allows for a smoother test flow.

3. **Modularity**:  
   The separation of responsibilities into different page classes enhances code maintainability. Each class deals exclusively with a specific page or part of the application, promoting cohesion and simplifying debugging.

## Code Highlights


1. **Stability**:  
   The use of `WebDriverWait` to ensure elements are ready for interaction significantly reduces the chance of intermittent test failures, promoting greater stability.

2. **Code Reusability**:  
   The POM pattern allows for the reuse of interaction methods across different test scenarios, reducing code duplication and making the framework easier to maintain.

3. **Ease of Maintenance**:  
   The `@FindBy` annotations centralize the location of elements, making it easy to modify the code if the page layout changes. Simply update the selector in the appropriate location without needing to alter all the tests.

4. **Clear Separation of Responsibilities**:  
   Each class represents a specific page or functionality, promoting code organization and making the logic easier to understand. This also makes the code more scalable, as new functionalities can be easily added without interfering with existing ones.

## Future Improvements

- **Standardizing Wait Times**:  
  Currently, different wait times are configured (`Duration.ofSeconds(5)` and `Duration.ofSeconds(10)`). Standardizing these values or using a global configuration to define ideal wait times can improve the framework's consistency.

- **Using More Robust Selectors**:  
  Whenever possible, prefer selectors that are less prone to changes, such as `id`, `name`, or `cssSelector`, to avoid the fragility that XPath can introduce in scenarios where the page layout changes.

- **Centralizing Wait Logic**:  
  Creating a utility class for explicit waits or an abstraction layer for common conditions can reduce code repetition and improve maintainability.

## Conclusion

The automation framework implements good testing practices, being modular, reusable, and stable. The decisions made in the implementation aim to ensure flexibility and ease of long-term maintenance, allowing tests to adapt to changes in the application efficiently.


## License

MIT