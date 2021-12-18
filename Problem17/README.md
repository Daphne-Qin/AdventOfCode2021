# Day 17: Trick Shot
(I'm writing this on December 18.)

Seems like my break, which started on [December 16](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem16#day-16-packet-decoder), was only meant to last two days long, because I really wanted to solve yesterday's problem! I would've done it yesterday, but I had a math competition, and by the end I was somehow mentally exhausted and mentally hyper at the same time. (I was jumping around everywhere and yelling and stuff, no joke.)

I read the first paragraph of the problem description:

> You finally decode the Elves' message. HI, the message says. You continue searching for the sleigh keys.

Is topaz[^1] serious right now? [Problem 16's overly long description on how to decode a message](https://adventofcode.com/2021/day/16) was all for a "HI"? Seems like Problem 17 was the calm before the storm again, since [Problem 18](https://adventofcode.com/2021/day/18) is also long. I'm still recovering from my 4 hours of trying to understand Problem16's description. No way am I doing that *again* today.

Anyway, onto today's problem.

I knew that I could come up with a smart [triangular number](https://en.wikipedia.org/wiki/Triangular_number) solution if I wanted to, but then again, I *did* do a math competition yesterday. That still applies today, and so I don't want to come up with a smart solution... and besides, why should I come up with a smart solution when I know how to code it a different way?

It's time for brute force.

I looked at Part 1, and realized that you only needed to care about the y part. I then realized that Part 2 would probably involve x somewhere, but I ignored it for now since I didn't know what exactly it would be. The logic did not take very long to write. Then I looked at Part 2, and the logic still didn't take very long to write. The code itself, though, is some of the messiest code I've written, but what can you expect with three nested while loops?

For my brute-force algorithm, I tried x-velocities from 0 to 250 and y-velocities from 0 to 250. That's 63001 combinations, and while at the beginning I was expecting another [Hall of Shame](https://github.com/Daphne-Qin/AdventOfCode2021#longest-runtimes-hall-of-shame-fame) entry because of that, I was pleasantly surprised. If the ranges had been a bit bigger, though (so for example, x ranging from 10000 to 20000), I bet a lot of people would've had trouble. For now, though, this problem stands as an easier late problem. (Considering Problems 15 and 16, I'm kind of grateful.)


I'm noticing how this README thing is becoming less about the problem itself and more about my actual day. I kind of like it that way.

[^1]: a shortening of the AoC creator's Reddit username, topaz2078. [More about him here.](https://adventofcode.com/2021/about)
