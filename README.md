# GreedyKnapsack
Greedy Knapsack Solver for CSC 370

## Introduction
There are two algorithms implemented in this greedy aproach to the knapsack problem. 

1) Best Value
2) Best Value to Weight Ratio (Value/Weight)

These algorithms may not always find the solution,
in that case you would want to use brute force.

## Example Input
This program takes in input from an input.txt file. The file has three values: name, value, and weight which are delimited by a new line charcter.
Suppose that input.txt has the following in it:

- diamond ring
- 5
- 1000
- TV
- 1000
- 400
- sandwich
- 10
- 2
- textbook
- 160
- 47
- pencils
- 10
- 1
- notebook
- 12
- 2
- stuffed animal
- 32
- 5
- filing cabinet
- 320
- 30
- stinky tennis shoes
- 16
- 4
- penny collection
- 480
- 20
- painting
- 160
- 3000
- rock collection
- 3200
- 256
- butcher knife
- 16
- 4
- lollipops
- 48
- 3
- fish tank
- 500
- 45

## Logically Stepping Through
As said in the intro, there are two different algorithms which we will step through.

### Best Value First


Let the weight of the knapsack be a given value, for simplicity sake, lets say the weight is 40.

Firstly, sort the list of inputs based on value. Once sorted, the list will look like the following:

- painting
- 3000
- 160
- diamond ring
- 1000
- 5
- TV
- 400
- 1000
- rock collection
- 256
- 3200
- textbook
- 47
- 160
- fish tank
- 45
- 500
- filing cabinet
- 30
- 320
- penny collection
- 20
- 480
- stuffed animal
- 5
- 32
- stinky tennis shoes
- 4
- 16
- butcher knife
- 4
- 16
- lollipops
- 3
- 48
- sandwich
- 2
- 10
- notebook
- 2
- 12
- pencils
- 1
- 10

Next, fill the knapsack to the given weight starting with the most valueable items still in the list.

Current Weight = 40
Current Value = 0
Painting Weight = 160
Cannot Add Painting 

Current Weigth = 40
Current Value = 0
Diamond Ring Weight = 5
Add Ring to Knapsack
New Weight = 35
New Value = 1000

Current Weight = 35
Current Value = 1000
TV Weight = 1000
Cannot Add TV

Current Weight = 35
Current Value = 1000
Rock Collection Weight = 3200
Cannot Add Rock Collection

Current Weight = 35
Current Value = 1000
Textbook Weight = 160
Cannot Add Textbook

Current Weight =  35
Current Value = 1000
Fish Tank Weight = 500
Cannot Add Fish Tank

Current Weight =  35
Current Value = 1000
Filing Cabinet Weight = 320
Cannot Add Filing Cabinet

Current Weight =  35
Current Value = 1000
Penny Collection Weight = 480
Cannot Add Penny Collection

Current Weight =  35
Current Value = 1000
Stuffed Animal Weight = 32
Add Stuffed Animal to Knapsack
New Weight = 3
New Value = 1005

...

It will continue to loop but will not find a weight less than or equal to three, so nothing will be added.

This algorithm will tell us that the best solution for weight of 40, is a weight of 37 and a value of 1005.

### Best Value to Weight Ratio First

Lets follow the precedent of the weight being 40 for comparison.

First, sort the list by the ratio of value to weight, that being the highest value of value/weight.

- diamond ring
- 1000
- 5
- painting
- 3000
- 160
- TV
- 400
- 1000
- textbook
- 47
- 160
- stinky tennis shoes
- 4
- 16
- butcher knife
- 4
- 16
- sandwich
- 2
- 10
- notebook
- 2
- 12
- stuffed animal
- 5
- 32
- pencils
- 1
- 10
- filing cabinet
- 30
- 320
- fish tank
- 45
- 500
- rock collection
- 256
- 3200
- lollipops
- 3
- 48
- penny collection
- 20
- 480

Next, fill the knapsack with the topmost item if possible

Current Weight = 40
Current Value = 0
Diamond Ring Weight = 5
Add Diamond Ring to Knapsack
New Weight = 35
New Value = 1000

Current Weight = 35
Current Value = 1000
Painting Weight = 160
Cannot Add Painting

Current Weight = 35
Current Value = 1000
TV Weight = 1000
Cannot Add TV

Current Weight = 35
Current Value = 1000
Textbook Weight = 160
Cannot Add Textbook

Current Weight = 35
Current Value = 1000
Stinky Tennis Shoes Weight = 16
Add Stinky Tennis Shoes
New Weight = 19
New Value = 1004

Current Weight = 19
Current Value = 1004
Add Butcher Knife
New Weight = 3
New Value = 1008

...

It will continue to loop but will not find a weight less than or equal to three, so nothing will be added.
This algorithm will tell us that the best solution for weight of 40, is a weight of 37 and a value of 1008.

## Analysis
The ratio algorithm found a better solution (W: 37, V: 1008) than that of the best value algorithm (W: 37, V: 1004). This suggests that one is better than another in some situations but not all situations. Also, the  
