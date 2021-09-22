# Why so serious, Max?

Min is guaranteed to win here. Clearly the optimal play for Min is `1 -> 4 -> (9 | 10) -> (15 | 16)`.

## Root (Max / X)

```
1. v=-1
O|X|O
-+-+-
X| |
-+-+-
X|O|
```

## 2nd level (Min / O)

### From state 1

```
2. v=0
O|X|O
-+-+-
X|O|
-+-+-
X|O|
```
```
3. v=0
O|X|O
-+-+-
X| |O
-+-+-
X|O|
```

```
4. v=-1
O|X|O
-+-+-
X| |
-+-+-
X|O|O
```

## 3rd level (Max / X)

### From state 2
```
5. v=-1
O|X|O
-+-+-
X|O|X
-+-+-
X|O|
```
```
6. v=0
O|X|O
-+-+-
X|O|
-+-+-
X|O|X
```

### From state 3
```
7. v=-1
O|X|O
-+-+-
X|X|O
-+-+-
X|O|
```
```
8. v=0
O|X|O
-+-+-
X| |O
-+-+-
X|O|X
```

### From state 4
```
9. v=-1
O|X|O
-+-+-
X|X|
-+-+-
X|O|O
```
```
10. v=-1
O|X|O
-+-+-
X| |X
-+-+-
X|O|O
```

## 4th level (Min / O)

### From state 5
```
11. v=-1
O|X|O
-+-+-
X|O|X
-+-+-
X|O|O
```

### From state 6
```
12. v=0
O|X|O
-+-+-
X|O|O
-+-+-
X|O|X
```

### From state 7
```
13. v=-1
O|X|O
-+-+-
X|X|O
-+-+-
X|O|O
```

### From state 8
```
14. v=0
O|X|O
-+-+-
X|O|O
-+-+-
X|O|X
```

### From state 9
```
15. v=-1
O|X|O
-+-+-
X|X|O
-+-+-
X|O|O
```

### From state 10
```
16. v=-1
O|X|O
-+-+-
X|O|X
-+-+-
X|O|O
```