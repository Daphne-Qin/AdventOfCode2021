# Day 8: Seven Segment Search
I first read Part 1 once, and didn't understand what I was supposed to look for. Then I read the bottom and thought, "Alright, that's probably a Part 2 thing. I'll just complete Part 1 now."

Part 1 was extremely easy, but then came the dreaded Part 2.

It took me a couple of times to realize that each character was linked to one segment, and whether a segment was "on" or "off" determined what number the string corresponded to. Later on, I realized that you do not necessarily need to find the top segment (through the strings for 1 and 7), and that the only two segments you need to find are the top right and bottom right segments to differentiate between 2, 3, and 5.

I made a `Display` class for organizational purposes, and that's when I learned that variables that were outside of the main and helper functions can also be static (via syntax errors). I first sorted all the strings so that I could just use the String `.equals()` function with the key strings and output strings. Then I coded a `hasAllCharacters()` function to check if a string had all the characters of another, which would help with differentiating the strings of length 6.

But then, while I was coding my function to differentiate the 6, the top right segment, and the bottom right segment, I deleted it since I reasoned I could just make two separate values for the two characters in the string for 1.  I coded a bit more, and I finished coding the function to differentiate the strings of length 5, when I realized I needed my old `hasAllCharacters()` function to compare the string for 3 to the strings for 0 and 9. While going back in history to search for function, I seemed to have accidentally typed a "z" (think: `CTRL+Z`)...

There went my past 15 minutes of progress.

I had to almost completely recode my function to differentiate 6, and completely had to redo my function to differentiate the strings of length 5 from scratch. Luckily, I remembered the logic and the code wasn't very hard, but it was still a big bummer.

Then I had to debug my code runner (`Problem08.java`) since for some reason, it gave me the output for the last number, times 200. I ended up not using an ArrayList of `Display`s and just dealing with each line one by one.

I didn't really like this problem. The hard part was coming up with the logic, but I found the code itself tedious to implement (after all, my three differentiator functions look pretty similar). It wasn't annoying, but it wasn't fun, either.

Here were my answers:
| Part 1 | Part 2 |
| :---: | :---: |
| 362 | 1020159 |
