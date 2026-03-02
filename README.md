# Horse Race Simulator

A simple yet engaging horse race simulation game built with Java Swing. The application allows users to select race distances, start a race, and watch horses move randomly towards the finish line. The first horse to cross (or go beyond) the finish line wins.

## Features

- **Race Distance Selection**: Choose between Short (100m), Medium (200m), and Long (300m) circuits.
- **Random Movement**: Each horse moves a random distance (0–3 meters) per turn, making every race unpredictable.
- **Graphical Interface**: A custom-built Swing GUI displays the race track, horses as colored ovals, and a finish line.
- **Real-time Animation**: A timer updates horse positions every 500 milliseconds, creating a smooth race animation.
- **Winner Detection**: The horse with the highest position after reaching or exceeding the finish line is declared the winner.
- **Standalone JAR**: The game can be packaged as an executable JAR file for easy distribution.

## Technologies Used

- **Java 17** (or higher)
- **Swing** for GUI
- **Maven** for build automation
- **Lombok** to reduce boilerplate code
- **Git** for version control

## Project Structure

```
horses-run/
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── zemu/
│                   └── horsesrun/
│                       ├── model/
│                       │   ├── Horse.java
│                       │   └── Race.java
│                       ├── service/
│                       │   └── RaceService.java
│                       └── view/
│                           └── MainWindow.java
└── target/                 (generated after build)
```

## How to Compile and Run

### Prerequisites

- Java Development Kit (JDK) 17 or later
- Apache Maven
- (Optional) Git to clone the repository

### Steps

1. **Clone the repository** (or download the source code):

```bash
git clone https://github.com/JRodZemu/horses-run.git
cd horses-run
```

2. **Build the project**:

```bash
mvn clean package
```

3. **Run the application**:

```bash
java -jar target/horses-run-0.0.1-SNAPSHOT.jar
```
