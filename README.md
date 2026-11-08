# Scientific Calculator – Java Swing

A Java desktop calculator built with Swing. It supports basic arithmetic and common scientific functions through a simple button-based interface.

## Features

- Basic operations: addition, subtraction, multiplication, division
- Decimal numbers
- Scientific functions: `sin`, `cos`, `tan`, `sqrt`, `log`, `x^2`, and `%`
- **C** button to clear the display and reset the calculator
- Error messages for division by zero and invalid input

## Functions

| Button | Operation |
|--------|-----------|
| `+` `-` `*` `/` | Basic arithmetic between two numbers |
| `=` | Calculates the result |
| `C` | Clears everything and resets the display to `0` |
| `sin` `cos` `tan` | Trigonometric functions, with the input in **degrees** |
| `sqrt` | Square root (shows `Invalid input` for negative numbers) |
| `log` | Base-10 logarithm (shows `Invalid input` for zero or negative numbers) |
| `x^2` | Squares the number on the display |
| `%` | Divides the number on the display by 100 |

## Requirements

- Java Development Kit (JDK) 8 or higher (Swing is included in the JDK)

## Getting Started

### Clone the repository

```bash
git clone https://github.com/<your-username>/<your-repo-name>.git
cd <your-repo-name>
```

### Compile

```bash
javac ScientificCalculator.java
```

### Run

```bash
java ScientificCalculator
```

## How to Use

**Basic arithmetic:** enter the first number, press an operator, enter the second number, then press `=`.

```
7  *  6  =   →  42.0
```

**Scientific functions:** enter a number, then press the function button. The result replaces the number on the display.

```
90  sin   →  1.0
16  sqrt  →  4.0
100 log   →  2.0
5   x^2   →  25.0
```

Dividing by zero shows `Cannot divide by zero`.

## How It Works

- The window uses absolute positioning (`setLayout(null)` with `setBounds`) to place a read-only display and the buttons.
- Number buttons share one listener that appends digits to the display, or replaces it when a new number starts.
- Operator buttons store the first number and the chosen operator. `=` reads the second number and calculates the result with a `switch` statement.
- Scientific buttons call a shared `scientific()` method that uses `Math.sin`, `Math.cos`, `Math.tan`, `Math.sqrt`, `Math.log10`, and `Math.pow`.
- Trigonometric functions convert degrees to radians with `Math.toRadians()` before calculating.

## Known Limitations

- Results are shown as plain `double` values, for example `42.0`, and can show floating-point artifacts such as `0.9999999999999999` for some trigonometric results.
- There is no button for entering a negative number directly; a negative value only appears as the result of a calculation.
- Operations are not chained: press `=` to finish one calculation before starting the next.
- There is no backspace button.

## Project Structure

```
.
├── ScientificCalculator.java
└── README.md
```

## Possible Improvements

- Add a `+/-` button and a backspace button
- Support chained operations (for example, `2 + 3 + 4 =`)
- Round or format the result to remove trailing `.0` and floating-point noise
- Add more functions such as `ln`, powers, and constants like π
- Use a layout manager such as `GridLayout` instead of absolute positioning
- Add keyboard input support
