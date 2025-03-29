# **Demoblaze Test Automation Project**

## **📌 Overview**

This project automates test scenarios for the Demoblaze website using **Java, Selenium, Cucumber, and TestNG**. The tests validate critical user workflows, including login, adding products to the cart, and price verification.

---

## **🛠 Tech Stack & Tools**

- **Java 11+**
- **Selenium WebDriver**
- **Cucumber (BDD Framework)**
- **TestNG (Test Execution & Reporting)**
- **Maven (Dependency Management & Execution)**
- **IntelliJ IDEA (Recommended IDE)**

---

## **📥 Installation & Setup**

### **1️⃣ Prerequisites**

Ensure the following are installed on your system:

- **Java 11+** ([Download & Install](https://adoptopenjdk.net/))
- **Maven** ([Download & Install](https://maven.apache.org/download.cgi))
- **IntelliJ IDEA** ([Download](https://www.jetbrains.com/idea/download/))
- **Google Chrome** (Latest version)
- **ChromeDriver** ([Download matching version](https://chromedriver.chromium.org/downloads))

### **2️⃣ Clone the Repository**

```sh
git clone https://github.com/Dor951/demoblaze-automation.git
cd demoblaze-automation
```

### **3️⃣ Configure WebDriver**

Ensure the **ChromeDriver** binary is correctly placed and accessible in the project.

- Option 1: Add the driver to the system path
- Option 2: Place the driver in `src/test/resources/drivers` and update test configuration

---

## **🚀 Running the Tests**

### **1️⃣ Execute All Tests**

```sh
mvn test
```

### **2️⃣ Run a Specific Feature**

```sh
mvn test -Dcucumber.options="src/test/resources/features/login.feature"
```

### **3️⃣ Run Only Failed Tests**

```sh
mvn test -Dsurefire.rerunFailingTestsCount=1
```
---

## **📂 Project Structure**

```
src
├── main/java/pages
│ ├── CartPage.java
│ ├── CheckoutPage.java
│ ├── HomePage.java
│ ├── LoginPage.java
├── test/java
│ ├── resources/features
│ │ ├── cart.feature
│ │ ├── checkout.feature
│ │ ├── login.feature
│ ├── runners
│ │ ├── TestRunner.java
│ ├── steps
│ │ ├── BaseTest.java
│ │ ├── CartSteps.java
│ │ ├── CheckoutSteps.java
│ │ ├── LoginSteps.java
├── README.md
└── pom.xml
```

---

## **🔹 Contributing**

- Fork the repository and create a new branch.
- Commit your changes and push to your branch.
- Create a Pull Request (PR) for review.

---

## **📧 Support**

For issues or questions, feel free to open an **Issue** or reach out via GitHub.

