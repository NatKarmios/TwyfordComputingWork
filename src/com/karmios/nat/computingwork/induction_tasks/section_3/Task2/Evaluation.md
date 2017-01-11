### Comments on the Question

The question given was somewhat flawed -
it claims that no pair of opposites can be shown twice in the test.
Because each question uses up 2 pairs, and 10 questions are required,
the 17 pairs provided by the question are not sufficient for the test;
I had to add 3 pairs of my own to the list for the code to work.

### Functionality

My code completes the criteria exactly, save for the above error.
It follows the same function is Task 1,
with some added checking to prevent duplicate questions.

It also outputs the test taker's name score to `output.txt`.

### Code Appearence

I believe my code is relatively clean and readable.

A change I could have made was substituting the variables
`pick1` and `pick2` for a single `int` array of length 2 -
this would save me repeating the code for selecting a
question from the list.
However, this may clutter my code with too many index references,
making it a bit less understandable.

I also chose to move sections of code to helper functions,
such as `pickedContains()` - although this could have been achieved in
one or two lines in the code, I would have to inflate both `while` loops
and give them a code body to handle this logic, bloating my code a little.