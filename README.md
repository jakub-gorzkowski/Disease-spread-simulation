# Disease spread simulation

Java object-oriented application simulates the progress of disease spread with simplified assumptions.

## Table of Contents

1. [Features](#features)
2. [Technology Stack](#technology-stack)
3. [Design Patterns](#design-patterns)
4. [Installation](#installation)
5. [Sample simulation](#sample-simulation)
6. [Author](#author)

## Features

- **Timer**: Allows the user to keep track of the simulation time.
- **Runtime progress save**: Application saves the state of the simulation every 1 second during runtime.
- **Loadable simulation states**: User can load the simulation state from the past during runtime by entering the specified point in time.

## Technology Stack

- **Java**: Utilized for the application logic.
- **Swing**: Used for creating graphical user interface.

## Design Patterns

- **State**: Used to manage the state of the entity. Entities can have 4 of them: healthy, immune, infected, asymptomatically infected.
- **Memento**: Utilized to keep track on the simulation progress. Allows user to load the state from the past.
- **Singleton**: Implemented in `Window.java` class to prevent the occurrence of multiple windows.

## Installation

To run the application, follow these steps:

1. **Clone the Repository**:

   ```
   git clone https://github.com/jakub-gorzkowski/Disease-spread-simulation
   ```

2. **Compile and Run the Application**:
- Compile the Java files.
- Run the application's main file to start the simulation.

## Sample Simulation

### Beginning of the simulation
![First stage](/samples/1.png)

### First infections
![Second stage](/samples/2.png)

### Disease takes over the majority
![Third stage](/samples/3.png)

### Significant amount of population gains immunity
![Fourth stage](/samples/4.png)

### Majority of the population became immune
![Fifth stage](/samples/5.png)

### State after restoring simulation to its 5th second
![Sixth stage](/samples/6.png)

## Author
Jakub Gorzkowski