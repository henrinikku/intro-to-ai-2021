# Bayes rule

## What is the distribution of the sum of the outcomes when rolling the ordinary die twice?

Possible events

```
{(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),
 (2,1),(2,2),(2,3),(2,4),(2,5),(2,6),
 (3,1),(3,2),(3,3),(3,4),(3,5),(3,6),
 (4,1),(4,2),(4,3),(4,4),(4,5),(4,6),
 (5,1),(5,2),(5,3),(5,4),(5,5),(5,6),
 (6,1),(6,2),(6,3),(6,4),(6,5),(6,6)}
```

We can get the distribution by simply counting the events.

```
2:  1/36
3:  2/36
4:  3/36
5:  4/36
6:  5/36
7:  6/36
8:  5/36
9:  4/36
10: 3/36
11: 2/36
12: 1/36
```

## What is the distribution of the sum of the outcomes when rolling the loaded die twice?

```
2:  1/100
3:  2/100
4:  3/100
5:  4/100
6:  5/100
7:  (4/100) + (5/100) + (5/100) = 14/100
8:  (3/100) + (5/100) + (5/100) = 13/100
9:  (2/100) + (5/100) + (5/100) = 12/100
10: (1/100) + (5/100) + (5/100) = 11/100
11: (5/100) + (5/100) = 10/100
12: 25/100
```