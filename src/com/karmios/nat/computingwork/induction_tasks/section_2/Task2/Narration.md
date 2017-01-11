### Initial Declarations

Firstly, a random number generator is created by assigning a new instance of `Random` (imported from `java.util`) to the `rng` variable.
An integer array of length seven is created, to store all six lottery numbers as well as the bonus ball, and is assigned to `pickedNumbers`.

### Generating Numbers

To generate the lottery numbers, the program enter a `for` loop, incrementing the variable `i` from 0 to 7, for each value in `pickedNumbers`.
In each iteration, a local variable - `picked` - is created, and the program enters a `do/while` loop, in which `picked` is set to `rng.nextInt(49) + 1`, which will generate a random number between 1 and 49 inclusive.

The `do/while` loop's boolean condition creates an integer stream of `pickedNumbers`, and calls `anyMatch(new Integer(picked)::equals)` on it.
This boxes `picked` into an `Integer` object, and then iterates over the aforementioned integer stream, calling `equals()` on said object to check if any of the integers are the same as `picked`.
If any integer in `pickedNumbers` equal to `picked`, then `anyMatch()` returns new, and a new number is generated for that index in `pickedNumbers`.

### Displaying Numbers

After printing `"Lottery numbers:"`, the program iterates over each int in `pickedNumbers` and prints them on new lines.
Finally, `"Bonus ball: "` is printed along with the last value in `pickedNumbers`.