# Scanalyzer — QA Automation

This repository contains the QA automation strategy and initial automation setup
for the AI-based warehouse inventory management platform.

The repository focuses on demonstrating an automation approach, framework structure,
and testing mindset, with the goal of achieving **full test coverage** across
all critical features.

---

## Project Overview

The AI Warehouse Platform is a web application designed to help businesses manage
warehouse inventory using artificial intelligence for object recognition and
classification based on photo and video analysis.

The frontend is implemented in React.
Automation testing is implemented in Java and is independent of the frontend technology.

---

## Purpose of This Repository

The purpose of this repository is to:

- Demonstrate QA automation mindset and best practices
- Define automation scope and strategy
- Provide a foundation for scalable UI test automation
- Support manual testing efforts
- Achieve **full test coverage** of all user flows over time
---

## Automation Scope

### In Scope (Planned for Automation)

- Authentication:
  - User login (happy and negative paths)
  - User registration (happy path)
  - User logout
- Main Dashboard:
  - Successful dashboard load after login
  - Visibility of core UI elements (menu, scan button)
---

### Out of Scope

- AI image and video scanning functionality  
  (covered by manual testing due to instability of UI automation for AI features)
- Security testing
---

## Tools and Technologies

- Java
- Selenium WebDriver
- TestNG
- Maven
- GitHub

---

Test strategy: https://docs.google.com/document/d/1f2UGBOk8efaOFYrL035yzzlZc7ZCoRZAXMB23Te6Nuo/edit?usp=sharing
Test Scenarios: https://docs.google.com/document/d/1Lp3rV_Tn0jOkPopfvqihdNb-I-wEVH7LMtjUSKgJjSI/edit?usp=sharing
Test Cases:https://www.notion.so/QA-Test-Cases-2c7498cabf7d806a900fca98247a0da0?source=copy_link
Bug Reports: https://www.notion.so/Bug-Tracker-2e7498cabf7d80c69a07f759585d8c7b?source=copy_link
https://qaprojectspace.atlassian.net/?continue=https%3A%2F%2Fqaprojectspace.atlassian.net%2Fwelcome%2Fsoftware%3FprojectId%3D10033&atlOrigin=eyJpIjoiN2Y3OTU2NmIwZjQ5NGRjNTkyOWI2N2RjYmM1ZWI3ODMiLCJwIjoiaiJ9
