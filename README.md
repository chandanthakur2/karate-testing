# Karate API Testing with Allure Reporting

This project uses Karate for API testing and Allure for reporting. It's configured with a Makefile for easy execution of tests and report generation across different environments.

## Prerequisites

- Java JDK 17 or higher
- Maven
- Make (optional, as bash commands are also provided)

## Setup

1. Clone this repository
2. Navigate to the project directory

## Running Tests
1.Run for the development environment.
```bash
make all
```

2. Run for the staging environment.
```bash
make all ENV=staging
```

## Usage

The project uses a Makefile to simplify the execution of tests and report generation. Here are the available commands with both Makefile and equivalent bash commands:

```makefile
# Makefile for Karate API testing with Allure reporting

# Variables
MAVEN = mvn
ENV ?= dev

# Default target
all: test report serve

# Run tests
test:
    $(MAVEN) clean test -Prun-tests-and-report -Dkarate.env=$(ENV)

# Generate Allure report
report:
    $(MAVEN) allure:report

# Serve Allure report
serve:
    $(MAVEN) allure:serve

# Clean up
clean:
    $(MAVEN) clean

# Help
help:
    @echo "Available targets:"
    @echo "  all    : Run tests, generate and serve Allure report (default)"
    @echo "  test   : Run Karate tests"
    @echo "  report : Generate Allure report"
    @echo "  serve  : Serve Allure report"
    @echo "  clean  : Clean up build artifacts"
    @echo ""
    @echo "To specify an environment, use: make <target> ENV=<environment>"
    @echo "Example: make all ENV=staging"

.PHONY: all test report serve clean help