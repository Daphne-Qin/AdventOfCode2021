# Day 16: Packet Decoder
I started to read the problem at 12 AM, got as far as the literal value explanation, and mentally ran away after 5 minutes.

So I spent 5 minutes reading the question at midnight, and couldn't understand it. That's understandable.

Now, I feel like I either have a very good attention span or a very terrible attention span. I also know that I definitely have a good dose of impatience, so most of the time I default to the terrible attention span.

Then during APCS, since I already did the classwork for homework (I didn't properly read the directions saying it wasn't homework), I spent another 20 minutes trying to understand the problem. My heart wasn't really in it, though, and I was pretty frivolous about the whole thing.

So I spent 20 minutes reading the question while joking around, and couldn't understand it. That's understandable.

I came home, and I finished my homework pretty quickly (I finished most of it on the way home). Then at 7 PM, I came back to this problem. Even though I'd already tried twice before and couldn't understand it, I still wanted to give my best shot at this problem.

I took notes like a good student. They were colored and everything so that I could visualize everything better, and I drew a partial flowchart for the packet structure algorithm while taking said notes. After I finished taking notes and thinking I understood the problem, it was 8 PM.

Due to my notes, I had a very good idea of what I wanted my general algorithm to be: recursion through the binary string until the code reached a literal packet.

I coded the solution, and it actually was quite fun for a while. I easily implemented the case for a literal packet, but then came time to implement the cases for operator packets...

That's when I realized I still didn't fully understand the problem.

I reread the problem, and made sure I didn't miss anything from my notes. At around 9:30 PM, I caved and searched Reddit for other people's answers (which I did ***not*** want to do) just so I could understand what the question was asking for. I wanted to understand this problem, but I couldn't for some reason. I still can't find a good explanation for where 11 and 16 come from for the sample input for `38006F45291200`, and where the three 11s come from for the sample input for `EE00D40C823060`. Am I supposed to find these numbers myself, iterate through all the cases? From what I saw of other people's solutions, it doesn't look like that's what I'm supposed to do. But if I were to run the rest of the packet (after the length type ID) recursively, that wouldn't give me two packets, that would give me one.

I stopped trying at 11 PM. I started feeling very uncomfortable (yes, me being upset makes me uncomfortable) at around 10:30 PM, and still trucked on. I couldn't understand what I had missed that everyone else had seen, even after having checked the problem description and other people's logic so many times. There have been jokes of my reading comprehension being subpar since I often don't read any instructions carefully, but a part of me wonders if that those jokes tell the truth. After all, this time, I really had read the problem carefully, very carefully.

I need a break from AoC.
