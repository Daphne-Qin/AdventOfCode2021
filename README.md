# AdventOfCode2021
You are currently viewing the **AdventOfCode2021** repository.

## About this Repository
The original problems can be found [here](https://adventofcode.com/2021 "Advent of Code 2021"). All code found here are solutions to those questions.

### Folder Content
Most of the solutions are written in Java, although Problems 1 and 2 contain solutions in Python ~~from the one time I wanted to prove a point but proved the other person's point instead but that's another story~~.

It also includes an `input.txt` file.

Lastly, there's a README file with my thoughts on the problem at the very top, my solutions, and then the problems themselves.

### Running the Code
- I put my site-generated puzzle inputs either in `input.txt` or near the top of the code.
- The general syntax is `java ProblemXX`.
  - However, if you wish to run Problems 1 or 2 in Python, run `python3 Problem0X.py`.
  - Java code for Problems 1 through 7 use the old format: `java Problem0X input.txt [1/2]`.

## Extras
### Longest Runtimes Hall of ~~Shame~~ Fame
*Mainly so I can laugh at myself. I'm surprised there aren't more entries.*
1. *Problem 03 Part 2*: 15m 5.521s (when running a while loop that never incremented and thus could never satisfy the ending condition, corrected code takes <0.3s)

### Favorite Problems
1. [**Problem 24**](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem24): it could be either very annoying or very interesting to solve, depending on your tastes. You do have to notice quite a few things, though!
2. [**Problem 12**](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem12): a recursion problem, but a nice recursion problem! Seemed scary at the beginning, but got pretty straightforward once I started coding everything out.
3. [**Problem 06**](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem06): simple yet deceptive.

### Most Annoying Problems
1. [**Problem 16**](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem16): I know a lot of people (specifically, Redditors) liked this problem. But this problem made me reread the question for more than four hours and wrecked my confidence in myself (after all, how come everyone else understood the problem and I couldn't understand it after my best shot). And even after all that, I *still* didn't understand the problem. I know the algorithm has simple implementation, I just can't understand the specifics of what I am supposed to do. I have not fully solved this problem yet.
2. [**Problem 18**](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem18): this took ***forever*** to debug, for both Parts 1 and 2. Also, if you miss one key sentence in the directions... have fun scratching your head at why your code won't work even though your logic seems correct. Also, if you're doing the snail numbers as objects, watch out for shallow copying.
3. [**Problem 11**](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem11): coming up with the solution wasn't easy. Debugging my logic errors was super duper annoying. I *hated* looking through thirty-something maps to check the difference between each iteration (and this was from octopus to octopus, so there were 100 maps per iteration).
4. [**Problem 04**](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem04): this took ~2.5h to implement, and I'm pretty sure it would've taken less time to do it by hand.

### Spoilers
<details>
  <summary>Image Comments</summary>
  I haven't finished the calendar yet, but if you've been following along with the story, you should notice that the full image corresponds to the ocean and its locations. For example, the cave is from rows 8 to 15 (which is when you're in the cave in the storyline), and the trench is from rows 17 to 25.
</details>

<details>
  <summary>Other Goodies</summary>
  There are small Easter eggs in each of the problems. You reveal them by hovering over the target phrase.
</details>

## Future Plans
- Edit Problems 1 through 7 so they no longer need arguments.
- To work on the following problems:

### Unsolved Problems
- Problem 15
- Problem 16
- Problem 19
- Problem 20
- Problem 21
- Problem 22
- Problem 23

### Problems to Redo
- Problem 12 (BFS)
- Problem 24 (solution that doesn't involve pen and paper)
