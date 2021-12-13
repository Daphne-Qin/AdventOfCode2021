# Day 11: Dumbo Octopus
No. Just, no. This problem 100% earns its place at the top of my [most annoying problems list](https://github.com/Daphne-Qin/AdventOfCode2021#most-annoying-problems).

This was another problem that fit well with recursive [DFS](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/). I got to copy a lot of my procedures and methods from [Problem 9](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem09), but that was the end of the easy portion. After that, however, I didn't realize I was supposed to keep a list of octopi that had already flashed until I ran the sample input (the 10x10 one, not the small 5x5 one; they give you two this time). Speaking of logic errors, you'll have a fun time trying to debug them if you're not careful. Oh, and the console *really* spams if you're trying to see what happens to the board at each octopus (although I was able to find my error using this way), so make sure to use `clear`.

<details>
  <summary>Additional Comments (Spoilers!)</summary>
  If you complete Part 1 and have debugging print statements, you won't necessarily have to write new code for Part 2. You can just increment your steps from 100 to a bigger number (for example, 500), then go searching for the first instance where all the octopi are flashing. This is how I first completed Part 2.
  <br><br>
  If you don't have debugging print statements, it's not too hard to make one (although by then it's not really worth it to make a `mapToString()` function and you should just write code to find the answer).
</details>

Here were my answers:
| Part 1 | Part 2 |
| :---: | :---: |
| 1705 | 265 |

## Part 1
I'm not going to try to copy this one down, just [read Part 1 on AoC](https://adventofcode.com/2021/day/11). There's too much formatting that I can't replicate on GitHub (or haven't learned how to replicate), it's too long, and Part 1 is available for everyone anyway. Although, hey, [dumbo octopi](https://www.youtube.com/watch?v=eih-VSaS2g0) are actually kind of cute.

## Part 2
It seems like the individual flashes aren't bright enough to navigate. However, you might have a better option: the flashes seem to be **synchronizing**!

In the example above, the first time all octopuses flash simultaneously is step **195**:

```
After step 193:
5877777777
8877777777
7777777777
7777777777
7777777777
7777777777
7777777777
7777777777
7777777777
7777777777

After step 194:
6988888888
9988888888
8888888888
8888888888
8888888888
8888888888
8888888888
8888888888
8888888888
8888888888

After step 195:
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
0000000000
```

If you can calculate the exact moments when the octopuses will all flash simultaneously, you should be able to navigate through the cavern. **What is the first step during which all octopuses flash?**
