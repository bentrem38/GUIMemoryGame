# Java GUI Memory Game

This is a graphical Memory Game application developed in Java using the Swing library. The project was created as part of a software development course at William & Mary.

Players try to match pairs of Unicode symbols. The game includes adjustable difficulty levels, real-time scoring, and a persistent leaderboard system.

## Features

- GUI-based memory game using Java Swing
- Difficulty selection (Easy, Normal, Hard)
- Unicode symbol sets (Arabic alphabet used)
- Leaderboard system with persistent storage
- Play-again and restart logic
- MVC-style code structure

## How to Run

1. **Clone this repository**
   ```bash
   git clone https://github.com/bentrem38/GUIMemoryGame
   cd GUIMemoryGame

    Compile the source code

javac -d bin src/edu/wm/cs/cs301/guimemorygame/**/*.java

Run the game

java -cp bin edu.wm.cs.cs301.guimemorygame.Main

Make sure the following exists at runtime:

Resources/LeaderBoard.txt