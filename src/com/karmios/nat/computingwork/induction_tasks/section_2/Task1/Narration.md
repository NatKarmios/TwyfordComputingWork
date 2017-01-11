### Data Input

The program first creates a `Scanner` object and assigns it to `input` (note that the `Scanner` class had to be imported from `java.util`):

    8   scanner input = new Scanner(System.in);

The program then prompts the user to enter their weight in pounds, calling `System.out.println()` to print a message to the console, then calling `input.nextDouble()` to wait for the user to enter a value - the result being assigned to the `weight` variable.
This is repeated for `height`, which is taken in inches.

Then, two constants are defined: `KG_PER_POUNDS` and `M_PER_INCH`, which are decimal numbers used to convert between kilograms and pounds and between meters and inches respectively. 
The `final` keyword is used here, as these variables will never be reassigned.

### BMI Calculation

The program converts the `height` and `weight` to kg and m respectively. It does this by multiplying the appropriate value with its aforementioned conversion constant. The results are assigned to `weightInKg` and `heightInMeters`.

Finally, the BMI is calculated: `weightInKg` is divided by `heightInMeters` squared, the result being assigned to `bmi`.

### Displaying the Result

Firstly, the BMI is printed by calling `System.out.println()` and passing in a string including the value of `bmi`.

Then, the program states whether the user is underweight, normal, overweight or obese by checking whether `bmi` is below three different values in an `if/else if/else if/else` statement.