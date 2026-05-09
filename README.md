# Selenium UI Test Suite

Automated end-to-end UI tests for [The Internet](https://the-internet.herokuapp.com) — a practice site built for Selenium automation.

## Tech Stack

- Java 21
- Selenium 4.43.0
- TestNG 7.12.0
- Maven
- IntelliJ IDEA

## Test Coverage

| Test Class | Scenario | Status |
|---|---|---|
| `LoginTest` | Valid login | ✅ |
| `LoginTest` | Invalid login — error message validation | ✅ |
| `CheckboxTest` | Check a checkbox | ✅ |
| `CheckboxTest` | Uncheck a checkbox | ✅ |
| `DropdownTest` | Select option by visible text | ✅ |
| `DropdownTest` | Select option by value | ✅ |
| `DragAndDropTest` | Drag column A → B | ✅ |
| `DragAndDropTest` | Drag column B → A | ✅ |

## How to Run

Open the project in IntelliJ IDEA and click the Run button on any test class, or right-click `src/test/java` and select **Run All Tests**.

## Notes

The drag-and-drop page uses HTML5 drag events which have a known incompatibility with Selenium's `dragAndDrop()` in some browser/driver versions. Both `dragAndDrop()` and the manual `clickAndHold → moveToElement → release` approach are demonstrated.