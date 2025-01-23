# Runnerz

This project is a Spring Boot application designed to manage running activities. It allows users to add, update, and remove run entries. The application uses Maven as its build system and H2 as an in-memory database for ease of setup and teardown.

## Features

- **Add Runs**: Users can add new running activities specifying details such as distance, duration, and date.
- **Update Runs**: Users can update existing running entries to correct or change details.
- **Delete Runs**: Users can remove run entries that are no longer needed.
- **View Runs**: Users can view a list of all recorded running activities.

## Prerequisites

Before you begin, ensure you have met the following requirements:
- Java 11 or newer
- Maven 3.6 or newer

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Installation

1. **Clone the repository:**
   ```bash
   git clone git@github.com:gomezc08/Runnerz.git
   cd runnerz
   mvnw spring-boot:run
   ```
