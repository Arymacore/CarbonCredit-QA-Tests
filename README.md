# Carbon Credit Marketplace - SQA Test Suite

This repository contains the automated test suite for the Carbon Credit Marketplace (Phase 2 Deliverables).

## Project Structure
- **POM Automation:** `src/main/java/edu/clark/sqa/pages/CheckoutPage.java` demonstrates the Page Object Model and Explicit Waits for handling blockchain transaction latency.
- **API Mocking & Integration Tests:** `src/test/java/edu/clark/sqa/tests/TransactionServiceTest.java` demonstrates isolating core transaction logic from external regulatory APIs using **JUnit 5** and **Mockito**.

## Execution Status (Review 1)
The JUnit Mockito tests are fully functional and pass locally, proving the core logic handles external API responses correctly. Full Selenium E2E execution is pending local WebDriver configuration.