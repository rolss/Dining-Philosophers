# Dining Philosophers Problem Animation 🍜

## How to use 🔍
1. Run main.java
2. In the GUI, select a speed with which the algorithm will run. This will make the process faster or slower
3. Click the "Iniciar" button to start the algorithm

## General information ℹ️
The menu at the left will indicate a log of what each philosopher is doing at current time
The menu at the right indicates how many times a philosopher has eaten, and how many he has to eat in total. These values are set randomly for each iteration of the algorithm
The information box at the bottom left, indicates the four possible states that a philosopher may have, explained below:

* Thinking: A philosopher is not eating, not on the table and not holding any forks.
* Waiting: A philosopher is sitting, holding a fork, and waiting for another fork to be available to him
* Eating: A philosopher is sitting, holding two forks and eating
* Satisfied: A philosopher has eaten everything he needs, he wont eat anymore and is gone
