# Rolling the dice

The lecturer has two dice in his office (true story). One of them is an ordinary die and will yield any result from one to six with equal probability. However, the other die is loaded (true story, again). It will yield a six with probability 1/2 and any other outcome with probability 1/10. He will roll the ordinary die first, and then the loaded one. Calculate the following probabilities. Recall that `P(A|B)` means the conditional probability of `A` given `B`.

## P("both outcomes are 6")

```
P("both outcomes are 6") 
= P("die1=6" and "die2=6")
= P("die1=6") * P("die2=6")
= (1/6) * (1/2)
= 1/12
```

## P("neither outcome is 6")

```
P("neither outcome is 6")
= P("not die1=6" and "not die2=6")
= P("not die1=6") * P("not die2=6")
= (5/6) * (1/2)
= 5/12
```

## P("the sum of the outcomes equals 9")
```
P("the sum of the outcomes equals 9")
= P(("die1=5" and "die2=4")
    or ("die1=6" and "die2=3")
    or ("die1=4" and "die2=5")
    or ("die1=3" and "die2=6"))
# Since the events are disjoint
= (P("die1=5") * P("die2=4"))
    + (P("die1=6") * P("die2=3"))
    + (P("die1=4") * P("die2=5"))
    + (P("die1=3") * P("die2=6"))
= ((1/6) * (1/10))
    + ((1/6) * (1/10))
    + ((1/6) * (1/10))
    + ((1/6) * (1/2))
= (1/60) + (1/60) + (1/60) + (1/12)
= 2/15
```

## P("the sum of the outcomes equals 9" | "at least one outcome is 6")

```
P("the sum of the outcomes equals 9" | "at least one outcome is 6")
= P("sum=9" and "at least one 6") / P("at least one 6")
= (1/10) / (2/3)
= 3/20
```

## P("at least one outcome is 6" | "the sum of the outcomes equals 9")

```
P("at least one outcome is 6" | "the sum of the outcomes equals 9")
= P("at least one 6" and "sum=9") / P("sum=9)
= (1/10) / (2/15)
= 3/4
```