# Day 6: Lanternfish
[Some](https://github.com/Daphne-Qin/AdventOfCode2015/tree/main/Problem15) [problems](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem04) have made me grind code like there was no tomorrow. [Other](https://github.com/Daphne-Qin/AdventOfCode2015#longest-runtimes-hall-of-shame-fame) [problems](https://github.com/Daphne-Qin/AdventOfCode2021#longest-runtimes-hall-of-shame-fame) have made me wait so long that I just did other stuff while waiting for the program to finish running.

This problem, however, was neither of those. In fact, this problem was the antithesis of both.

Me being me, I checked this problem in the morning (~7:50 AM-type morning, not [3 in the morning like yesterday](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem05)), read it too quickly, and completely failed to process it. I was also sleep-deprived since my 4 hours of sleep from yesterday caught up. I put the problem off for later, then came back to it at around 7 PM, and read it a few more times before I understood what it said.

As I'm sure a lot of other people did, I first decided to use an ArrayList, check each number, count down if it was not 0, and added new fishes for each fish that reached 0. Then I ran Part 1 with no problems. So since Part 1 was easy, this was a pushover, right?

Silly me. That was *Part* 1, not Day 1.

I then tried Part 2, then saw that the demo was taking more than five seconds to return an answer. Then I was about to get ready to add another entry to the [Hall of Shame](https://github.com/Daphne-Qin/AdventOfCode2021#longest-runtimes-hall-of-shame-fame), but I got an `OutOfMemoryError` after 41.308s and after ocean day 201. Keep in mind that this is the *demo*, and I hadn't even run the code using my input. Guess I'm not adding a legitimate HoF entry yet. (Even though it's up there, Day 3 doesn't really count, in my opinion.)

I thought a bit more, realized that fish could be grouped together by day (after all they all stayed within their group while cycling through the days), and coded that solution. Then I got a negative number for my Part 2 answer (my code had a logic error), and I never subtracted anything, so I knew something was up. Then I remembered an obscure APCS lesson, and then I remembered that once Integers reached 32 bits, they would loop around to the negative numbers. So I then had to replace every instance of "Integer" or "int" with "Long" and "long", respectively.

While it may not be my absolute favorite from this year so far, I respect this problem. It had pretty simple implementation for both parts, didn't make me to search anything up on the internet, didn't take me forever to debug, and required a bit of ingenuity to solve (and honestly, I think I got pretty lucky with the logic error, as it exposed the Integer and Long thing; it would've taken me way longer to figure out the problem had it not shown up since Part 1 would've had no problems with using Integers). My only gripe with this problem is that it was hard to understand, but that's a me problem and [there have been worse problems in this regard](https://adventofcode.com/2015/day/25). This problem will definitely have its very own place on my [list of favorites](https://github.com/Daphne-Qin/AdventOfCode2021#favorite-problems).

Perhaps I'll go back to some of the [2015 HoF entries](https://github.com/Daphne-Qin/AdventOfCode2015#longest-runtimes-hall-of-shame-fame) and think up some better solutions to them. Including 2015 Problem 10.

I need some sleep.

### Answers
| Part 1 | Part 2 |
| :---: | :---: |
| 372300 | 1675781200288 |

## Part 1
The sea floor is getting steeper. Maybe the sleigh keys got carried this way?

A massive school of glowing [lanternfish](https://en.wikipedia.org/wiki/Lanternfish) swims past. They must spawn quickly to reach such large numbers - maybe **exponentially** quickly? You should model their growth rate to be sure.

Although you know nothing about this specific species of lanternfish, you make some guesses about their attributes. Surely, each lanternfish creates a new lanternfish once every **7** days.

However, this process isn't necessarily synchronized between every lanternfish - one lanternfish might have 2 days left until it creates another lanternfish, while another might have 4. So, you can model each fish as a single number that represents **the number of days until it creates a new lanternfish**.

Furthermore, you reason, a **new** lanternfish would surely need slightly longer before it's capable of producing more lanternfish: two more days for its first cycle.

So, suppose you have a lanternfish with an internal timer value of 3:

- After one day, its internal timer would become 2.
- After another day, its internal timer would become 1.
- After another day, its internal timer would become 0.
- After another day, its internal timer would reset to 6, and it would create a **new** lanternfish with an internal timer of 8.
- After another day, the first lanternfish would have an internal timer of 5, and the second lanternfish would have an internal timer of 7.

A lanternfish that creates a new fish resets its timer to 6, **not 7** (because 0 is included as a valid timer value). The new lanternfish starts with an internal timer of 8 and does not start counting down until the next day.

Realizing what you're trying to do, the submarine automatically produces a list of the ages of several hundred nearby lanternfish (your puzzle input). For example, suppose you were given the following list:

`3,4,3,1,2`

This list means that the first fish has an internal timer of 3, the second fish has an internal timer of 4, and so on until the fifth fish, which has an internal timer of 2. Simulating these fish over several days would proceed as follows:

```
Initial state: 3,4,3,1,2
After  1 day:  2,3,2,0,1
After  2 days: 1,2,1,6,0,8
After  3 days: 0,1,0,5,6,7,8
After  4 days: 6,0,6,4,5,6,7,8,8
After  5 days: 5,6,5,3,4,5,6,7,7,8
After  6 days: 4,5,4,2,3,4,5,6,6,7
After  7 days: 3,4,3,1,2,3,4,5,5,6
After  8 days: 2,3,2,0,1,2,3,4,4,5
After  9 days: 1,2,1,6,0,1,2,3,3,4,8
After 10 days: 0,1,0,5,6,0,1,2,2,3,7,8
After 11 days: 6,0,6,4,5,6,0,1,1,2,6,7,8,8,8
After 12 days: 5,6,5,3,4,5,6,0,0,1,5,6,7,7,7,8,8
After 13 days: 4,5,4,2,3,4,5,6,6,0,4,5,6,6,6,7,7,8,8
After 14 days: 3,4,3,1,2,3,4,5,5,6,3,4,5,5,5,6,6,7,7,8
After 15 days: 2,3,2,0,1,2,3,4,4,5,2,3,4,4,4,5,5,6,6,7
After 16 days: 1,2,1,6,0,1,2,3,3,4,1,2,3,3,3,4,4,5,5,6,8
After 17 days: 0,1,0,5,6,0,1,2,2,3,0,1,2,2,2,3,3,4,4,5,7,8
After 18 days: 6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8,8,8,8
```

Each day, a 0 becomes a 6 and adds a new 8 to the end of the list, while each other number decreases by 1 if it was present at the start of the day.

In this example, after 18 days, there are a total of 26 fish. After 80 days, there would be a total of **5934**.

Find a way to simulate lanternfish. **How many lanternfish would there be after 80 days**?

## Part 2
Suppose the lanternfish live forever and have unlimited food and space. Would they take over the entire ocean?

After 256 days in the example above, there would be a total of **26984457539** lanternfish!

**How many lanternfish would there be after 256 days?**
