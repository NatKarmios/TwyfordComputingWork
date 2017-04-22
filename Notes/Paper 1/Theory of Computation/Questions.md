## Problem Solving

#### Page 357

1\)
<br>
(a) If the wind blows from the north, then it snows.
<br>
(b) If not exercising enough, then get unfit.
<br>
(c) If it is autumn, then the leaves on the trees turn brown.
<br>
(d) `if (temperature=100) water.boil();`
<br>
(e) If the goods were bought within the last 2 weeks, a refund can be obtained.


#### Page 358

2\)
- Major proposition: *If it is cold, he wears a hat*
- Minor proposition: *It is cold*
- **Conclusion:** *He wears a hat*

3\) No; he could wear a hat when it isn't cold.

4\) Taxes will be lowered.

5\) No; the politician could have lowered taxes without having been elected.

6\) No.

7\) Both Alice and Ben must be telling the truth.


#### Page 359

8\)

| Elected | Taxes Lowered | *"If I am elected, I will lower taxes"* |
|:------- |:------------- |:--------------------------------------- |
| `true`  | `true`        | `true`                                  |
| `true`  | `false`       | `false`                                 |
| `false` | `true`        | `true`                                  |
| `false` | `false`       | `true`                                  |


#### Page 360

9\) P => Q; P ∴ Q

10\) The initial proposition is wrong.

11\) Yes.

12\) Yes.


#### Page 361

13\) *"If it snows today, I can catch up on my homework."*

14\) *If the train arrives early, Jamin can call in on his friend John.*

15\) *"If I don't watch the late night film, I will wake up feeling refreshed."*

16\) *If Alex is allowed a TV in his bedroom, he will neglect his homework.*

17\) *There were taxis at the airport.*

18\) *Isla had her raincoat with her.*

19\) U and 3. 
If U has an odd number on the other side, 
or 3 has a vowel on the other side, 
then the rule is false.


#### Page 363

20\)  P(3) == false, P(7) == true

21\) *Gerry drinks coffee.*

22\) *Deemei has learned at least one programming language.*

23\) Both of them must be lying.




## Following and Writing Algorithms

#### Page 365

1\) There are an infinite number of possible outcomes.


#### Page 367

1\) `Product <- Product + y`; `NoOfTimes <- NoOfTimes + 1`

2\) `Power <- Power * x`; `Count <- Count + 1`

3\)
```
Input: N    [Integer > 0]

Algorithm:
    Count <- 0
    While 2^(Count+1)
        Count <- Count + 1
    EndWhile

Output: m, where 2^m < N and 2^(m+1) > N 
```

4\)
```
Input: n    [Integer > 0]

Algorithm:
    Total <- 0
    Count <- 1
    While Count <= n
        Total <- Total + Count
        Count <- Count + 1
    EndWhile

Output: Sum of the first n natural numbers 
```

5\)
```
Input: n    [Integer > 0]

Algorithm:
    Total <- 1
    Count <- 1
    While Count <= n
        Total <- Total * Count
        Count <- Count + 1
    EndWhile

Output: Product of the first n natural numbers 
```


#### Page 368 - 369

2\)

| *Dividend x* | *Dividend y* | *Quotient q* | *Remainder r* |
|:------------:|:------------:|:------------:|:-------------:|
| **5**        | **2**        | **2**        | **1**         |
| **6**        | **3**        | **2**        | **0**         |
| **25**       | **4**        | **6**        | **1**         |
| **36**       | **6**        |            6 |             0 |
| **121**      | **7**        |           17 |             2 |
| **23**       | **3**        |            7 |             2 |
| **1**        | **3**        |            0 |             3 |
| **5**        | **10**       |            0 |             5 |

3\)

| *Iteration No.* | *x*   | *y*   | *r*   | *q*   | *r > y*  |
|:---------------:|:-----:|:-----:|:-----:|:-----:|:--------:|
| **0**           | **6** | **3** | **6** | **0** | **True** |
| 1               |     6 |     3 |     3 |     1 | False    |
| 2               |     - |     - |     - |     - | False    |

4a\) Yes
<br>
4b\) No: q should be 2, y should be 0. Change `r > y` to `r >= y`.

5\)

| *Iteration No.* | *x*   | *y*   | *r*   | *q*   | *r > y*  |
|:---------------:|:-----:|:-----:|:-----:|:-----:|:--------:|
| **0**           | **6** | **0** | **6** | **0** | **True** |
| 1               |     6 |     0 |    12 |     1 | True     |
| 2               |     6 |     0 |    18 |     2 | True     |
| 3               |     6 |     0 |    24 |     3 | True     |
| 4               |     6 |     0 |    30 |     4 | True     |
| 5               |     6 |     0 |    36 |     5 | True     |

6\) No.


#### Page 370

7\)

| *Iteration No.* | *x*    | *y*   | *r*   | *q*   | *r >= y* |
|:---------------:|:------:|:-----:|:-----:|:-----:|:--------:|
| **0**           | **-2** | **1** |    -2 |     0 | False    |

8\) Yes

9\) No