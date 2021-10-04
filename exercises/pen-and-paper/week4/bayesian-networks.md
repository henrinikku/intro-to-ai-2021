# Bayesian networks

## 1

Consider a model with N=4 variables, each of which has k possible values (0,1,...,k–1). How many different elementary events are there in the domain? One less is the number of probabilities that we'd have to determine in order to fully specify the model.

It seems like there will always be `k ^ N` elementary events.

## 2

How many parameters would we have to define to specify the model using an "empty" Bayesian network, i.e, a network with no edges at all?

```
N(k - 1)
```

## 3

What is the maximum number of parameters we'd have to define in a Bayesian network in this domain (N variables with k values each)? Remember that the graph has to be a DAG, i.e., no directed cycles are allowed.

```
k - 1 + k(k - 1) + k^2(k - 1) + k^3(k - 1)
```

## 4

Generalize to arbitrary values of N. It may be helpful to recall the sum of a geometric series 1+k+k^2+...+k^N–1 = (k^N–1)/(k–1), where k≠1.

Looking at the solution to part 3, it's easy to see that the solution is

```
k - 1 + k(k - 1) + k^2(k - 1) + k^3(k - 1) + ... + k^(N - 1)(k - 1)
```

From which we get, by applying the given formula,

```
k ^ N - 1
```
