# Decorator Pattern - Java Implementation

A practical implementation of the **Decorator Design Pattern** in Java, demonstrating how to dynamically add features to objects at runtime without modifying their original structure.

## What is the Decorator Pattern?

The Decorator Pattern is a structural design pattern that allows you to attach additional responsibilities to an object dynamically. It provides a flexible alternative to subclassing for extending functionality. Instead of creating multiple subclasses for different combinations of features, decorators wrap objects and add behavior.

### Key Characteristics:
- **Flexible alternative to inheritance** - Compose behavior instead of inheriting it
- **Dynamic behavior** - Add or remove features at runtime
- **Single Responsibility** - Each decorator handles one specific feature
- **Chainable** - Multiple decorators can be stacked together

## Project Structure

```
├── Car.java              # Base interface for all cars
├── BasicCar.java         # Concrete car implementation
├── CarDecorator.java     # Decorator interface extending Car
├── CarWithAC.java        # Decorator: adds AC functionality
├── CarWithGPS.java       # Decorator: adds GPS functionality
├── TestCar.java          # Demo application
└── README.md             # This file
```

## How It Works

### Core Components

**1. Car Interface**
```java
public interface Car {
    String assemble();
}
```
Defines the contract for all car types and decorators.

**2. BasicCar Class**
The basic car implementation with minimal functionality.

**3. CarDecorator Interface**
```java
public interface CarDecorator extends Car {
    void setCar(Car car);
}
```
Extends Car and adds a method to wrap another car object.

**4. Concrete Decorators**
- `CarWithAC` - Adds air conditioning feature
- `CarWithGPS` - Adds GPS navigation feature

Each decorator implements `CarDecorator` and wraps a car object to add new functionality.

## Usage Example

```java
// Create a basic car
Car basicCar = new BasicCar();

// Wrap it with AC decorator
CarWithAC acCar = new CarWithAC();
acCar.setCar(basicCar);

// Wrap the AC car with GPS decorator
CarWithGPS gpsCar = new CarWithGPS();
gpsCar.setCar(acCar);

// Get the final assembled car with all features
System.out.println(gpsCar.assemble());
// Output: Basic car assembled. AC added. GPS added.
```

## Running the Project

### Compile
```bash
javac *.java
```

### Run
```bash
java TestCar
```

### Expected Output
```
Basic car assembled. AC added. GPS added.
```

## Benefits of the Decorator Pattern

✅ **Open/Closed Principle** - Open for extension, closed for modification  
✅ **Flexibility** - Combine features in any order or quantity  
✅ **Single Responsibility** - Each decorator handles one concern  
✅ **Runtime Composition** - Decide features dynamically  
✅ **No Subclass Explosion** - Avoid combinatorial class hierarchies  

## Extending the Project

You can easily add more decorators! For example:

```java
public class CarWithSunroof implements CarDecorator {
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public String assemble() {
        return car.assemble() + " Sunroof added.";
    }
}
```

Then use it:
```java
CarWithSunroof sunroofCar = new CarWithSunroof();
sunroofCar.setCar(gpsCar);
System.out.println(sunroofCar.assemble());
```

## When to Use the Decorator Pattern

- When you need to add responsibilities to individual objects dynamically
- When creating subclasses would result in an explosion of classes
- When you want to add features independently and in any combination
- Real-world examples: UI components with borders/scrollbars, logging/compression wrappers, stream decorators

## Design Pattern Diagram

```
       ┌─────────────────────┐
       │   <<interface>>     │
       │        Car          │
       │─────────────────────│
       │ +assemble(): String │
       └─────────────────────┘
              ▲         ▲
              │         │
              │         │
       ┌──────┴─┐    ┌──┴───────────────┐
       │        │    │ <<interface>>    │
    ┌──┴──┐  ┌──┴──┐ │  CarDecorator    │
    │ ... │  │ ... │ │ ─────────────────│
    └─────┘  └─────┘ │+setCar(Car car)  │
                     └──────────────────┘
                            ▲
                            │
                ┌───────────┴───────────┐
           ┌────┴────┐           ┌──────┴───┐
           │CarWithAC│           │CarWithGPS│
           │─────────│           │──────────│
           │-car:Car │           │-car: Car │
           └─────────┘           └──────────┘
```
