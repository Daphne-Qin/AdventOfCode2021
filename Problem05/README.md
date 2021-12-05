# Day 5: Hydrothermal Venture
I said on [Day 3](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem03#day-3-binary-diagnostic) that "I've decided to not stay up until 12 AM again". And I really didn't, but I woke up at 2:30 AM and couldn't fall back asleep. Also, I don't feel tired at all.

I spent the next hour trying to sleep again, and failed, so I decided to check today's problem since I was bored. Upon first sight, I thought a HashMap would work great (I'd researched it after doing [Day 4](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem04) and thinking that mapping numbers to T/F values would work). In this case, each key would be the coordinate, and each value would be the frequency it occurred.

However, I quickly realized that:
1. I could not figure out how to properly count how many values were greater than 2.
  - I got the `local variables referenced from a lambda expression must be final or effectively final` error when trying to increment a variable while using `.forEach()`.
  - While `Collections.frequency()` could work if I incremented the second parameter to a really huge number, incrementing to a really huge number still doesn't count all possibilities, so it was a no-go for me (it still technically would've been an incorrect solution).
2. I barely understood how HashMaps worked. (Also, what was that `.stream()` thing I kept seeing on StackExchange?)
3. I could just use an ArrayList of strings, sort it, and count the number of times each coordinate occurs in a row (and that I could just modify my `lookAndSay()` method from [my solution to AoC 2015 Problem 10](https://github.com/Daphne-Qin/AdventOfCode2015/blob/main/Problem10/Problem10.java)).

Then, I thought about [counting the number of times a patch was colored in NetLogo](https://stackoverflow.com/questions/56803709/how-to-get-a-patch-to-count-the-turtles-passing-through-it), but I had already installed it and am not too familiar with it anymore.

I spent around thirty minutes testing and trying to research stuff about HashMaps, then I gave up on that route. Afterwards, I think implementing the actual solution took me about an hour. Part 1 was simple enough, but Part 2 took me a while to debug (I kept switching the coordinates incorrectly).

And honestly, I'd like to come back to this problem once I actually understand HashMaps. I liked this problem. (Or maybe I'll try my hand at NetLogo.)

Here were my answers:
| Part 1 | Part 2 |
| :---: | :---: |
| 6687 | 19851 |

## Part 1
You come across a field of [hydrothermal vents](https://en.wikipedia.org/wiki/Hydrothermal_vent) on the ocean floor! These vents constantly produce large, opaque clouds, so it would be best to avoid them if possible.

They tend to form in **lines**; the submarine helpfully produces a list of nearby lines of vents (your puzzle input) for you to review. For example:
```
0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2
```
Each line of vents is given as a line segment in the format `x1,y1 -> x2,y2` where `x1`,`y1` are the coordinates of one end the line segment and `x2`,`y2` are the coordinates of the other end. These line segments include the points at both ends. In other words:

An entry like `1,1 -> 1,3` covers points `1,1`, `1,2`, and `1,3`.
An entry like `9,7 -> 7,7` covers points `9,7`, `8,7`, and `7,7`.
For now, **only consider horizontal and vertical lines**: lines where either `x1 = x2` or `y1 = y2`.

So, the horizontal and vertical lines from the above list would produce the following diagram:
```
.......1..
..1....1..
..1....1..
.......1..
.112111211
..........
..........
..........
..........
222111....
```
In this diagram, the top left corner is `0,0` and the bottom right corner is `9,9`. Each position is shown as **the number of lines which cover that point** or `.` if no line covers that point. The top-left pair of `1`s, for example, comes from `2,2 -> 2,1`; the very bottom row is formed by the overlapping lines `0,9 -> 5,9` and `0,9 -> 2,9`.

To avoid the most dangerous areas, you need to determine **the number of points where at least two lines overlap**. In the above example, this is anywhere in the diagram with a `2` or larger - a total of **5** points.

Consider only horizontal and vertical lines. **At how many points do at least two lines overlap?**

## Part 2
Unfortunately, considering only horizontal and vertical lines doesn't give you the full picture; you need to also consider **diagonal lines**.

Because of the limits of the hydrothermal vent mapping system, the lines in your list will only ever be horizontal, vertical, or a diagonal line at exactly 45 degrees. In other words:

An entry like `1,1 -> 3,3` covers points `1,1`, `2,2`, and `3,3`.
An entry like `9,7 -> 7,9` covers points `9,7`, `8,8`, and `7,9`.
Considering all lines from the above example would now produce the following diagram:
```
1.1....11.
.111...2..
..2.1.111.
...1.2.2..
.112313211
...1.2....
..1...1...
.1.....1..
1.......1.
222111....
```
You still need to determine **the number of points where at least two lines overlap**. In the above example, this is still anywhere in the diagram with a `2` or larger - now a total of **12** points.

Consider all of the lines. **At how many points do at least two lines overlap?**
