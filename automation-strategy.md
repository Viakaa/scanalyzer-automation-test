# AI Warehouse Platform — Automation Testing

This repository contains the automation testing strategy and initial setup for the
AI-based warehouse inventory management platform.

The goal of this repository is to demonstrate the QA Automation approach, test
design principles, and framework structure, even though the application is still
under active development and has a minimal frontend.

---

## Project Overview

The application is a web-based platform that uses artificial intelligence to
automatically recognize, classify, and manage warehouse inventory based on
photo and video analysis.

The frontend of the application is implemented in **React**.
Automation testing is implemented using **Java**, following industry best practices.

---

## Purpose of Automation

The purpose of automation testing in this project is to:

- Cover critical user flows with automated tests
- Support manual testing and reduce regression effort
- Validate basic application stability (smoke testing)
- Provide a scalable foundation for future automation

---

## Automation Scope

### In Scope

The following features are planned to be covered by automated UI tests:

- Authentication:
    - User login (valid and invalid credentials)
    - User registration (happy path)
    - User logout
- Main Dashboard:
    - Successful dashboard load after login
    - Visibility of key UI elements (menu, scan button)

These scenarios represent **critical smoke and regression paths**.

---

### Out of Scope

The following features are intentionally excluded from automation at this stage:

- AI image and video recognition
    - Reason: AI behavior depends on camera access, image quality, and machine
      learning models, making UI automation unstable and unreliable
- Performance testing
- Security testing
- Backend and API testing

These areas are covered by **manual testing only**.

---

## Type of Automation

- UI automation testing
- Smoke testing
- Basic regression testing

No API or integration automation is included at this stage.

---

## Tools and Technologies

- Programming Language: **Java**
- Build Tool: **Maven**
- UI Automation: **Selenium WebDriver**
- Test Framework: **TestNG**
- Design Pattern: **Page Object Model (POM)**
- Version Control: **GitHub**

The automation framework is independent of the frontend implementation (React).

---

## Test Environment

- Application under test: Web application
- Frontend: React
- Browser:
    - Google Chrome (primary)
- Test execution:
    - Local environment
- Test data:
    - Static test accounts created manually

---

## Test Execution Strategy

- Automated tests are executed:
    - Locally by QA engineers
    - On demand during development
- Tests are designed to be:
    - Independent
    - Repeatable
    - Stable

CI/CD integration is not included at this stage and may be added in the future.

---

## Test Design Principles

- Tests focus on **user behavior**, not implementation details
- Page Object Model (POM) is used to separate test logic from UI locators
- Explicit waits are preferred over static waits
- Each test validates a single business scenario


## Risks and Limitations

- UI changes may require locator updates
- Limited frontend functionality may block full automation
- AI-based features are not suitable for stable UI automation

---

## Future Improvements

- Add more regression scenarios
- Introduce API automation when backend becomes available
- Integrate automation tests into a CI/CD pipeline
- Expand browser coverage

---

## Conclusion

This repository provides a foundation for scalable UI automation testing.
The strategy focuses on critical user flows and maintains a balanced approach
between manual and automated testing.

---

