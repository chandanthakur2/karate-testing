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