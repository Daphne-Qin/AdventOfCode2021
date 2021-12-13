# Day 12: Passage Pathing
"Oh gosh. Oh, no." That was the first thing I thought when I saw this problem. Because not only would I have to use recursion again (and I did not like either Problems [9](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem09) or [11](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem11)), but I also had zero ideas of how to implement the solution itself.

I pulled up the [G4G DFS page](https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/) again (seems like I've been on there quite a bit in the last four days), read it again, then found a link to [LinkedLists](https://www.geeksforgeeks.org/linked-list-in-java/). Then I read about LinkedLists for the next fifteen minutes or so before realizing that trying to crash course new data structures would probably be a waste of time. After all, the only three things I learned were (1) that linked lists exist, (2) that they linked elements to each other, and (3) they used nodes to do so. But from what I read, it seemed like it couldn't really make a tree, which is what I needed.

An ArrayList would do, as always. Perhaps one of all the paths, in both directions.

I was scared.

Cue me actually coding the solution to Part 1, though, and it's actually not as bad as I originally thought it was. It was a lot better than Day 11's recursion, and in my opinion was more intuitive. I did have a bit of trouble with the list of small caves already visited for Part 1, then realized that I had to delete caves off the list since it interfered with the count (my actual input gave me 6... which I actually tried).

Part 2 was a bit harder and I actually had to store the current path (which I'd avoided in Part 1... I ended up storing the current path in Part 1 as well to help debug Part 2), but I got to use the `Collections.frequency()` method that I'd researched on [Day 5](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem05#day-5-hydrothermal-venture) at 3:30 AM! I guess my HashMap research wasn't in vain after all. The debugging process wasn't too bad once I figured out how to organize my code so that it more or less neatly printed out the current paths and the caves that were restricted. I had trouble with the list of restricted caves since my cave restriction code would only kick in after a cave had been visited twice, meaning that if I had visited caves c, b, and d but then visited c, caves b and d wouldn't be restricted. (I had interesting incorrect cases such as [start, A, c, A, b, d, b, A, c, A, end]).

While I could merge the functions for Parts 1 and 2 (I had two seperate but very similar functions for both), I feel like my code would actually be more organized if they're separate. So I'll keep it that way.

I actually really, really liked this problem! It gave me quite the scare at the beginning, but as I coded it, it gradually became less and less intimidating. I do see how it could quickly become a very annoying problem when trying to debug logic errors, but for me, it wasn't really a grind and it wasn't terrible to fix them. I feel like this problem belongs to the type of problems that seem intimidating, but aren't actually intimidating and are pretty straightforward once you start doing everything out, and I love that.

This belongs at the top of my [favorite problems list](https://github.com/Daphne-Qin/AdventOfCode2021#favorite-problems), for sure. Well, unless a later AoC problem takes its spot. Hey, we're almost halfway done!

Here were my answers:
| Part 1 | Part 2 |
| :---: | :---: |
| 4707 | 130493 |

## Part 1
With your submarine's subterranean subsystems subsisting suboptimally, the only way you're getting out of this cave anytime soon is by finding a path yourself. Not just **a** path - the only way to know if you've found the **best** path is to find **all** of them.

Fortunately, the sensors are still mostly working, and so you build a rough map of the remaining caves (your puzzle input). For example:

```
start-A
start-b
A-c
A-b
b-d
A-end
b-end
```

This is a list of how all of the caves are connected. You start in the cave named `start`, and your destination is the cave named `end`. An entry like `b-d` means that cave `b` is connected to cave `d` - that is, you can move between them.

So, the above cave system looks roughly like this:

```
    start
    /   \
c--A-----b--d
    \   /
     end
```

Your goal is to find the number of distinct **paths** that start at `start`, end at `end`, and don't visit small caves more than once. There are two types of caves: **big** caves (written in uppercase, like `A`) and **small** caves (written in lowercase, like `b`). It would be a waste of time to visit any small cave more than once, but big caves are large enough that it might be worth visiting them multiple times. So, all paths you find should **visit small caves at most once**, and can **visit big caves any number of times**.

Given these rules, there are **10** paths through this example cave system:

```
start,A,b,A,c,A,end
start,A,b,A,end
start,A,b,end
start,A,c,A,b,A,end
start,A,c,A,b,end
start,A,c,A,end
start,A,end
start,b,A,c,A,end
start,b,A,end
start,b,end
```

(Each line in the above list corresponds to a single path; the caves visited by that path are listed in the order they are visited and separated by commas.)

Note that in this cave system, cave `d` is never visited by any path: to do so, cave `b` would need to be visited twice (once on the way to cave `d` and a second time when returning from cave `d`), and since cave `b` is small, this is not allowed.

Here is a slightly larger example:

```
dc-end
HN-start
start-kj
dc-start
dc-HN
LN-dc
HN-end
kj-sa
kj-HN
kj-dc
```

The `19` paths through it are as follows:

```
start,HN,dc,HN,end
start,HN,dc,HN,kj,HN,end
start,HN,dc,end
start,HN,dc,kj,HN,end
start,HN,end
start,HN,kj,HN,dc,HN,end
start,HN,kj,HN,dc,end
start,HN,kj,HN,end
start,HN,kj,dc,HN,end
start,HN,kj,dc,end
start,dc,HN,end
start,dc,HN,kj,HN,end
start,dc,end
start,dc,kj,HN,end
start,kj,HN,dc,HN,end
start,kj,HN,dc,end
start,kj,HN,end
start,kj,dc,HN,end
start,kj,dc,end
```

Finally, this even larger example has `226` paths through it:

```
fs-end
he-DX
fs-he
start-DX
pj-DX
end-zg
zg-sl
zg-pj
pj-he
RW-he
fs-DX
pj-RW
zg-RW
start-pj
he-WI
zg-he
pj-fs
start-RW
```

**How many paths through this cave system are there that visit small caves at most once?**

## Part 2
After reviewing the available paths, you realize you might have time to visit a single small cave **twice**. Specifically, big caves can be visited any number of times, a single small cave can be visited at most twice, and the remaining small caves can be visited at most once. However, the caves named `start` and `end` can only be visited **exactly once each**: once you leave the `start` cave, you may not return to it, and once you reach the `end` cave, the path must end immediately.

Now, the `36` possible paths through the first example above are:

```
start,A,b,A,b,A,c,A,end
start,A,b,A,b,A,end
start,A,b,A,b,end
start,A,b,A,c,A,b,A,end
start,A,b,A,c,A,b,end
start,A,b,A,c,A,c,A,end
start,A,b,A,c,A,end
start,A,b,A,end
start,A,b,d,b,A,c,A,end
start,A,b,d,b,A,end
start,A,b,d,b,end
start,A,b,end
start,A,c,A,b,A,b,A,end
start,A,c,A,b,A,b,end
start,A,c,A,b,A,c,A,end
start,A,c,A,b,A,end
start,A,c,A,b,d,b,A,end
start,A,c,A,b,d,b,end
start,A,c,A,b,end
start,A,c,A,c,A,b,A,end
start,A,c,A,c,A,b,end
start,A,c,A,c,A,end
start,A,c,A,end
start,A,end
start,b,A,b,A,c,A,end
start,b,A,b,A,end
start,b,A,b,end
start,b,A,c,A,b,A,end
start,b,A,c,A,b,end
start,b,A,c,A,c,A,end
start,b,A,c,A,end
start,b,A,end
start,b,d,b,A,c,A,end
start,b,d,b,A,end
start,b,d,b,end
start,b,end
```

The slightly larger example above now has `103` paths through it, and the even larger example now has `3509` paths through it.

Given these new rules, **how many paths through this cave system are there?**
