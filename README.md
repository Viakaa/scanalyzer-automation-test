# Scanalyzer — QA Automation

This repository contains the QA automation strategy and initial automation setup
for the AI-based warehouse inventory management platform.

The repository focuses on demonstrating automation approach, framework structure,
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
  - Inventory search functionality
  
These scenarios represent **critical smoke and regression paths** and will eventually
be included in the full automated coverage.


---

### Out of Scope

- AI image and video scanning functionality  
  (covered by manual testing due to instability of UI automation for AI features)
- Security testing
- Backend / API testing

---

## Automation Strategy


Automation is focused on:

- Smoke and regression scenarios
- User behavior validation rather than implementation details
- Maintainable and scalable framework design

Detailed automation strategy is described directly in this repository.

---

## Tools and Technologies

- Java
- Selenium WebDriver
- TestNG
- Maven
- GitHub

---

## Project Status

- Manual test cases and documentation: **Completed (maintained in Notion)**
- Automation framework setup: **In progress**
- Automated test implementation: **Planned**
- Goal: **Full test coverage** for all key features
- 
---

## Repository Structure
src/test/java

├── base – Base test setup

├── pages – Page Object classes

└── tests – Automated test classes
