# Day 14: Extended Polymerization
Today's problems were rip-offs of [Day 6's problems](https://github.com/Daphne-Qin/AdventOfCode2021/tree/main/Problem06). I didn't hate them, but didn't really enjoy them, either. I feel like we all got familiar with the `OutOfMemoryError` tactic back then, so it wasn't as fun this time. Also, the logic itself was more tedious to code and way easier to make logic errors on.

<details>
  <summary>Solution Logic (Spoilers!)</summary>
  Instead of calculating the string itself and iterating, count the number of pairs instead. So for example, if you had `CH -> B` and you had two `CH` pairs, you would then have two `CB` and two `BH` pairs after a step.
  <br><br>
  That's not the bad part, though. The part where you have to calculate the range is where things get tricky. You have to realize that (1) you count each middle character is counted twice and the two outer characters are counted twice minus one times (so in the sample input, `N` and `B` are counted one less time than double), and (2) some pairs have the same character (for example, `NN`). This made the code extremely annoying to debug.
</details>

I wonder if my computer would've been able to handle the naïve solution without a memory error. The [Hall of Shame](https://github.com/Daphne-Qin/AdventOfCode2021#longest-runtimes-hall-of-shame-fame) feels pretty empty, and while that's a good thing, I'm now worried that the entries will appear *en masse* later in the month.

Here were my answers:
| Part 1 | Part 2 |
| :---: | :---: |
| 2602 | 2942885922173 |
