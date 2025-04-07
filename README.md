# Temperature Conversion Automation Testing with Selenium

This Java project automates the process of testing a web-based Fahrenheit to Celsius/Kelvin temperature converter using Selenium WebDriver and Google Chrome.

## Description

The script performs automated tests on a public temperature conversion website (`https://cmpsprojectgroup1.com/wpdemo/`). It inputs various Fahrenheit values, selects the conversion unit (Celsius or Kelvin), and triggers the conversion process. The script also handles alert popups and opens a new browser tab after each conversion.

## Features

- Uses **Selenium WebDriver** with **ChromeDriver**.
- Tests multiple Fahrenheit values including:
  - Positive (`"100"`)
  - Negative (`"-100"`)
  - Malformed input (`"1 0 0"`, `""`)
  - Decimal (`"50.5"`)
- Tests both **Celsius** and **Kelvin** conversion options.
- Handles **JavaScript alert popups**.
- Opens a new tab after each test run to isolate test cases.

## Prerequisites

- Java JDK 8 or higher installed
- [Selenium Java bindings](https://www.selenium.dev/downloads/)
- Chrome browser installed
- Compatible **ChromeDriver** installed and path correctly set in the code

## How to Run

1. Clone or download this project.
2. Ensure you have the correct `chromedriver` path set:
   ```java
   System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
