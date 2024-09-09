
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

## License

MIT