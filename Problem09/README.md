# Day 9: Smoke Basin
I saw Part 1 at 12 AM, then remembered [what happened the last time I did a problem at 12 AM](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem03). And yes, I did stay up until 12 AM this time... it took 6 days for me to stay up until 12 AM again. I was correct, but not for the reason I predicted, as I was doing my homework instead of killing time like I did on Day 3. So I just went to sleep.

<details>
  <summary>Coming Up with Solution Logic (Spoilers!)</summary>
  I'd thought of a solution for Part 1 on the way to school, but it didn't involve storing the locations of the low points themselves. However, at school, I figured out the description for Part 2, then realized that I should keep the low point locations. I also learned about [BFS](https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/) and [DFS](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/) while talking to another AoC participant, so now I knew that I should probably recursively solve the problem, presumably using the low points.
</details>

I spent a decent amount of time writing the helper `adjacentCoords()` function and the recursive `basinSize()` function (I hadn't used recursion in a while), and I definitely saved a lot of time. I do wonder, however, if this problem would've made the [annoying problems list](https://github.com/Daphne-Qin/AdventOfCode2021#most-annoying-problems) had I done it on my own.

I surprisingly ran Part 2 correctly on my first try, and without syntax errors.

Here were my answers:
| Part 1 | Part 2 |
| :---: | :---: |
| 516 | 1023660 |

## Part 1
These caves seem to be [lava tubes](https://en.wikipedia.org/wiki/Lava_tube). Parts are even still volcanically active; small hydrothermal vents release smoke into the caves that slowly settles like rain.

If you can model how the smoke flows through the caves, you might be able to avoid it and be that much safer. The submarine generates a heightmap of the floor of the nearby caves for you (your puzzle input).

Smoke flows to the lowest point of the area it's in. For example, consider the following heightmap:

2**1**9994321**0**\
3987894921\
98**5**6789892\
8767896789\
989996**5**678

Each number corresponds to the height of a particular location, where `9` is the highest and `0` is the lowest a location can be.

Your first goal is to find the **low points** - the locations that are lower than any of its adjacent locations. Most locations have four adjacent locations (up, down, left, and right); locations on the edge or corner of the map have three or two adjacent locations, respectively. (Diagonal locations do not count as adjacent.)

In the above example, there are **four** low points, all highlighted: two are in the first row (a `1` and a `0`), one is in the third row (a `5`), and one is in the bottom row (also a `5`). All other locations on the heightmap have some lower adjacent location, and so are not low points.

The **risk level** of a low point is **1 plus its height**. In the above example, the risk levels of the low points are `2`, `1`, `6`, and `6`. The sum of the risk levels of all low points in the heightmap is therefore **15**.

Find all of the low points on your heightmap. **What is the sum of the risk levels of all low points on your heightmap?**

## Part 2
Next, you need to find the largest basins so you know what areas are most important to avoid.

A **basin** is all locations that eventually flow downward to a single low point. Therefore, every low point has a basin, although some basins are very small. Locations of height `9` do not count as being in any basin, and all other locations will always be part of exactly one basin.

The **size** of a basin is the number of locations within the basin, including the low point. The example above has four basins.

The top-left basin, size `3`:

**21**99943210\
**3**987894921\
9856789892\
8767896789\
9899965678

The top-right basin, size `9`:

21999**43210**\
398789**4**9**21**\
985678989**2**\
8767896789\
9899965678

The middle basin, size `14`:

2199943210\
39**878**94921\
9**85678**9892\
**87678**96789\
9**8**99965678

The bottom-right basin, size `9`:

2199943210\
3987894921\
9856789**8**92\
876789**678**9\
98999**65678**

Find the three largest basins and multiply their sizes together. In the above example, this is `9 * 14 * 9 = 1134`.

**What do you get if you multiply together the sizes of the three largest basins?**
