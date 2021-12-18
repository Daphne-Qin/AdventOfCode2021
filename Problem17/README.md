# Day 17: Trick Shot
(I'm writing this on December 18.)

Seems like my break, which started on [December 16](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem16#day-16-packet-decoder), was only meant to last two days long, because I really wanted to solve yesterday's problem! I would've done it yesterday, but I had a math competition, and by the end I was somehow mentally exhausted and mentally hyper at the same time. (I was jumping around everywhere and yelling and stuff, no joke.)

I read the first paragraph of the problem description:

> You finally decode the Elves' message. `HI`, the message says. You continue searching for the sleigh keys.

Is topaz[^1] serious right now? [Problem 16's overly long description on how to decode a message](https://adventofcode.com/2021/day/16) was all for a "HI"? Seems like Problem 17 was the calm before the storm again, since [Problem 18](https://adventofcode.com/2021/day/18) is also long. I'm still recovering from my 4 hours of trying to understand Problem 16's description. No way am I doing that *again* today. From now on, I might just do any problem with a long description after December 25. I already exhausted the extent of my capacity for attention on Problem 16, which I still haven't solved yet (as of when I'm writing this).

Anyway, onto today's problem.

I know that I could come up with a smart [triangular number](https://en.wikipedia.org/wiki/Triangular_number) solution if I wanted to, but then again, I *did* do a math competition yesterday. My brain wasn't interested in doing math, and so I didn't want to come up with a smart solution... and besides, why should I come up with a smart solution when I knew how to code it a different way?

It's time for brute force.

I looked at Part 1, and realized that I only needed to care about the y part. I then realized that Part 2 would probably involve x somewhere, but I ignored it for now since I didn't know what exactly it would be about. The logic for Part 1 did not take very long to write. Then I looked at Part 2, and the logic still didn't take very long to write (another nested `while` loop, plus a few extra booleans). The code itself, though, is some of the messiest code I've written, but what can you expect with three nested while loops?

For my brute-force algorithm, I tried x-velocities from 0 to 250 and y-velocities from -250 to 250. That's 125751 combinations, and while at the beginning I was expecting another [Hall of Shame](https://github.com/Daphne-Qin/AdventOfCode2021#longest-runtimes-hall-of-shame-fame) entry because of that, I was pleasantly surprised by my code's runtime of `0m 0.281s`. If the ranges had been a bit bigger, though (so for example, x ranging from 10000 to 20000), I bet a lot of people would've had trouble... or not, if they wanted to wait for their computers to finish running the program. For now, though, this problem stands as an easier late problem. (Considering Problems 15 and 16, I'm kind of grateful.)


I'm noticing how this README thing is becoming less about the problem itself and more about my actual day. I kind of like it that way.

## Part 1
You finally decode the Elves' message. `HI`, the message says. You continue searching for the sleigh keys.

Ahead of you is what appears to be a large [ocean trench](https://en.wikipedia.org/wiki/Oceanic_trench). Could the keys have fallen into it? You'd better send a probe to investigate.

The probe launcher on your submarine can fire the probe with any [integer](https://en.wikipedia.org/wiki/Integer) velocity in the `x` (forward) and `y` (upward, or downward if negative) directions. For example, an initial `x,y` velocity like `0,10` would fire the probe straight up, while an initial velocity like `10,-1` would fire the probe forward at a slight downward angle.

The probe's x,y position starts at `0,0`. Then, it will follow some trajectory by moving in **steps**. On each step, these changes occur in the following order:

- The probe's `x` position increases by its `x` velocity.
- The probe's `y` position increases by its `y` velocity.
- Due to drag, the probe's `x` velocity changes by `1` toward the value `0`; that is, it decreases by `1` if it is greater than `0`, increases by `1` if it is less than `0`, or does not change if it is already `0`.
- Due to gravity, the probe's `y` velocity decreases by `1`.

For the probe to successfully make it into the trench, the probe must be on some trajectory that causes it to be within a **target area** after any step. The submarine computer has already calculated this target area (your puzzle input). For example:

`target area: x=20..30, y=-10..-5`

This target area means that you need to find initial `x,y` velocity values such that after any step, the probe's `x` position is at least `20` and at most `30`, **and** the probe's `y` position is at least `-10` and at most `-5`.

Given this target area, one initial velocity that causes the probe to be within the target area after any step is `7,2`:

```
.............#....#............
.......#..............#........
...............................
S........................#.....
...............................
...............................
...........................#...
...............................
....................TTTTTTTTTTT
....................TTTTTTTTTTT
....................TTTTTTTT#TT
....................TTTTTTTTTTT
....................TTTTTTTTTTT
....................TTTTTTTTTTT
```

In this diagram, `S` is the probe's initial position, `0,0`. The `x` coordinate increases to the right, and the `y` coordinate increases upward. In the bottom right, positions that are within the target area are shown as `T`. After each step (until the target area is reached), the position of the probe is marked with `#`. (The bottom-right `#` is both a position the probe reaches and a position in the target area.)

Another initial velocity that causes the probe to be within the target area after any step is `6,3`:

```
...............#..#............
...........#........#..........
...............................
......#..............#.........
...............................
...............................
S....................#.........
...............................
...............................
...............................
.....................#.........
....................TTTTTTTTTTT
....................TTTTTTTTTTT
....................TTTTTTTTTTT
....................TTTTTTTTTTT
....................T#TTTTTTTTT
....................TTTTTTTTTTT
```

Another one is `9,0`:

```
S........#.....................
.................#.............
...............................
........................#......
...............................
....................TTTTTTTTTTT
....................TTTTTTTTTT#
....................TTTTTTTTTTT
....................TTTTTTTTTTT
....................TTTTTTTTTTT
....................TTTTTTTTTTT
```

One initial velocity that **doesn't** cause the probe to be within the target area after any step is `17,-4`:

```
S..............................................................
...............................................................
...............................................................
...............................................................
.................#.............................................
....................TTTTTTTTTTT................................
....................TTTTTTTTTTT................................
....................TTTTTTTTTTT................................
....................TTTTTTTTTTT................................
....................TTTTTTTTTTT..#.............................
....................TTTTTTTTTTT................................
...............................................................
...............................................................
...............................................................
...............................................................
................................................#..............
...............................................................
...............................................................
...............................................................
...............................................................
...............................................................
...............................................................
..............................................................#
```

The probe appears to pass through the target area, but is never within it after any step. Instead, it continues down and to the right - only the first few steps are shown.

If you're going to fire a highly scientific probe out of a super cool probe launcher, you might as well do it with **style**. How high can you make the probe go while still reaching the target area?

In the above example, using an initial velocity of `6,9` is the best you can do, causing the probe to reach a maximum `y` position of **45**. (Any higher initial `y` velocity causes the probe to overshoot the target area entirely.)

Find the initial velocity that causes the probe to reach the highest `y` position and still eventually be within the target area after any step. **What is the highest y position it reaches on this trajectory?**

## Part 2
Maybe a fancy trick shot isn't the best idea; after all, you only have one probe, so you had better not miss.

To get the best idea of what your options are for launching the probe, you need to find **every initial velocity** that causes the probe to eventually be within the target area after any step.

In the above example, there are **112** different initial velocity values that meet these criteria:

```
23,-10  25,-9   27,-5   29,-6   22,-6   21,-7   9,0     27,-7   24,-5
25,-7   26,-6   25,-5   6,8     11,-2   20,-5   29,-10  6,3     28,-7
8,0     30,-6   29,-8   20,-10  6,7     6,4     6,1     14,-4   21,-6
26,-10  7,-1    7,7     8,-1    21,-9   6,2     20,-7   30,-10  14,-3
20,-8   13,-2   7,3     28,-8   29,-9   15,-3   22,-5   26,-8   25,-8
25,-6   15,-4   9,-2    15,-2   12,-2   28,-9   12,-3   24,-6   23,-7
25,-10  7,8     11,-3   26,-7   7,1     23,-9   6,0     22,-10  27,-6
8,1     22,-8   13,-4   7,6     28,-6   11,-4   12,-4   26,-9   7,4
24,-10  23,-8   30,-8   7,0     9,-1    10,-1   26,-5   22,-9   6,5
7,5     23,-6   28,-10  10,-2   11,-1   20,-9   14,-2   29,-7   13,-3
23,-5   24,-8   27,-9   30,-7   28,-5   21,-10  7,9     6,6     21,-5
27,-10  7,2     30,-9   21,-8   22,-7   24,-9   20,-6   6,9     29,-5
8,-2    27,-8   30,-5   24,-7
```

**How many distinct initial velocity values cause the probe to be within the target area after any step?**

[^1]: a shortening of the AoC creator's Reddit username, topaz2078. [More about him here.](https://adventofcode.com/2021/about)
