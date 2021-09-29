# Naive Bayes and Spam

```
        word    spam     ham
 ----------- ------- -------
 million         156      98
 dollars          29     119
 adclick          51       0
 conferences       0      12
 ----------- ------- -------
       total   95791  306438
```

Consider the word counts given in the table above (million, dollars, etc).

## 1. Estimate the remaining word probabilities for both classes

Using `0.000001` as a lower bound for all probability estimates.

| Word        | Spam      | Ham       |
| ----------- | --------- | --------- |
| million     | 0.0016285 | 0.0003198 |
| dollars     | 0.0003027 | 0.0003883 |
| adclick     | 0.0005324 | 0.000001  |
| conferences | 0.000001  | 0.0000391 |

## 2. Use the obtained estimates to calculate the probability `P(Word ≠ 'million')`

That is, the probability that a single word in a message is not `million` when the class of the message is unknown.

```
P(Word ≠ 'million)
= 1 - P(Word = 'million')
= 1 - (0.0016285 + 0.0003198)
= 1 - 0.0019483
= 0.9980517
```

## 3. Calculate `P(spam | 'million')`

That is, the probability that the message is spam given that its first word (or in fact, any particular word) is `million`.

Use the prior probability `P(spam) = 0.5`.

By Bayes' rule, we have

```
                      P(spam) P('million' | spam)
P(spam | 'million') = ---------------------------
                            P('million')
```

From [part 1](##1-estimate-the-remaining-word-probabilities-for-both-classes) we obtain the value of the likelihood term

```
P('million' | spam) = 0.0016285
```

and similarly

```
P('million' | ham) = 0.0003198
```

We can now skip calculating the annoying denominator by only considering the ratio of posteriors.

```
    P(spam) P('million' | spam)   0.5 * 0.0016285
R = --------------------------- = --------------- = 5.09224515322
     P(ham) P('million' | ham)    0.5 * 0.0003198
```

Therefore we have that

```
P(spam | 'million') = R / (1 + R) = 0.83585690088
```

## 4. Calculate `P(spam | 'million', 'dollars', 'adclick', 'conferences')`

That is, the probability that the message is spam when its first four words are as stated.

This one is similar to part 3, but now the likelihood terms are
```
P('million', 'dollars', 'adclick', 'conferences' | spam) 
= P('million' | spam)
  * P('dollars' | spam) 
  * P('adclick' | spam) 
  * P('conferences' | spam)
= 0.0016285 * 0.0003027 * 0.0005324 * 0.000001
```
and similarly 
```
P('million', 'dollars', 'adclick', 'conferences' | ham) 
= P('million' | ham)
  * P('dollars' | ham) 
  * P('adclick' | ham) 
  * P('conferences' | ham)
= 0.0003198 * 0.0003883 * 0.000001 * 0.0000391
```

Using the same trick, we have that
```
    P(spam) P('million', 'dollars', 'adclick', 'conferences' | spam) 
R = ---------------------------------------------------------------- = 54.0524798196
     P(ham) P('million', 'dollars', 'adclick', 'conferences' | ham) 
```

So finally we have that
```
P(spam | 'million', 'dollars', 'adclick', 'conferences')
= R / (1 + R)
= 0.98183551398
```
