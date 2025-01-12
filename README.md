
# JavaFXCalculator

## Requirements
- **Java**: 21+
- **Maven**: 3.6.0+
- **[SDKMAN](http://sdkman.io)**

---

## Setting Up the Environment with SDKMAN

1. Install Java and Maven:
    ```bash
    sdk install java 21.0.5-amzn
    sdk install maven 3.6.0
    ```

2. Set the installed versions:
    ```bash
    sdk use java 21.0.5-amzn
    sdk use maven 3.6.0
    ```

---

## Running the Project

1. Clean and compile the project:
    ```bash
    mvn clean compile
    ```

2. Run the application using the JavaFX Maven Plugin:
    ```bash
    mvn javafx:run
    ```
![imagen](https://github.com/user-attachments/assets/4dac66cc-3d78-41e7-b343-369c48e92202)


---

## Distributing the Application

To create a platform-specific package (such as `.app` for macOS or `.exe` for Windows), use the `jlink` goal:

   ```bash
   mvn javafx:jlink
   ```

The generated package can be found in the `target` directory (e.g., `target/app.zip`).

---

## Manual Executable JAR

To run the application as an executable JAR, you will need to download JavaFX from [Gluon](https://gluonhq.com/products/javafx/) for your platform.
1. Setup JAVAFX_SDK
   ```bash
   cd $HOME/Downloads
   wget https://download2.gluonhq.com/openjfx/23.0.1/openjfx-23.0.1_osx-aarch64_bin-sdk.zip
   unzip openjfx-23.0.1_osx-aarch64_bin-sdk.zip
   export JAVAFX_SDK=$HOME/Downloads/javafx-sdk-23.0.1
   ```

2. Build the JAR:
    ```bash
    mvn clean package
    ```

3. Run the application with the following command, making sure to specify the JavaFX SDK path:
    ```bash
    java --add-modules javafx.controls,javafx.fxml --module-path $JAVAFX_SDK/lib -jar target/JavaFXCalculator-1.0.jar
    ```

---

## References
- [JavaFX (Gluon)](https://gluonhq.com/products/javafx/)
