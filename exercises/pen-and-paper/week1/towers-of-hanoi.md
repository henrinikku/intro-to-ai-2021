# Towers of Hanoi

## Search space
![Diagram](https://raw.githubusercontent.com/henrinikku/intro-to-ai-2021/main/exercises/pen-and-paper/week1/img/towers-of-hanoi.png)

## BFS
1. `[SML-- --]`
1. `[ML-- --S, ML--S--]`
1. `[ML--S--, L--M--S]`
2. `[L--M--S, L--S--M]`
2. `[L--S--M, L--SM--, SL--M--]`
3. `[L--SM--, SL--M--, SL-- --M, L-- --SM]`
4. `[SL--M--, SL-- --M, L-- --SM, --SM--L]`
5. `[SL-- --M, L-- --SM, --SM--L]`
6. `[L-- --SM, --SM--L]`
7. `[--SM--L, --L--SM]`
8. `[S--M--L, --M--SL, --SL--M, S--L--M]`
9. `[--M--SL, --SL--M, S--L--M, S-- --ML]`
10. `[--SL--M, S--L--M, S-- --ML, M-- --SL]`
11. `[S--L--M, S-- --ML, M-- --SL, M--SL--]`
12. `[S-- --ML, M-- --SL, M--SL--, S--ML--]`
13. `[M-- --SL, M--SL--, S--ML--, -- --SML, --S--ML]`
14. `[M--SL--, S--ML--, -- --SML, --S--ML, M--S--L, SM-- --L]`
15. `[S--ML--, -- --SML, --S--ML, M--S--L, SM-- --L, SM--L--, M--L--S]`
16. `[-- --SML, --S--ML, M--S--L, SM-- --L, SM--L--, M--L--S, --ML--S, --SML--]`
17. Found `-- --SML`

## DFS
1. `[SML-- --]`
1. `[ML-- --S, ML--S--]`
1. `[ML-- --S, L--S--M]`
2. `[ML-- --S, SL-- --M, L-- --SM]`
2. `[ML-- --S, SL-- --M, --L--SM]`
2. `[ML-- --S, SL-- --M, --SL--M, S--L--M]`
2. `[ML-- --S, SL-- --M, --SL--M, S--ML--]`
2. `[ML-- --S, SL-- --M, --SL--M, --ML--S, --SML--]`
3. `[ML-- --S, SL-- --M, --SL--M, M--L--S]`
3. `[ML-- --S, SL-- --M, --SL--M, M--SL--, SM--L--]`
3. `[ML-- --S, SL-- --M, --SL--M, M--SL--, SM-- --L]`
3. `[ML-- --S, SL-- --M, --SL--M, M--SL--, M-- --SL, M--S--L]`
4. `[ML-- --S, SL-- --M, --SL--M, M--SL--, M-- --SL, --S--ML]`
4. `[ML-- --S, SL-- --M, --SL--M, M--SL--, M-- --SL, S-- --ML, -- --SML]`
4. Found `-- --SML`

## Comparisation of the search methods

- BFS found the shortest path (7), which is much shorter than the path found by DFSs
- BFS found the path in 20 steps whereas DFS needed only 15 steps -- DFS was clearly faster in this regard
- The traversal was done by adding leftmost neighbours of each node to the list first.
- The order in which the neighbors of each node are added into the queue can greatly affect the path found and the steps taken by DFS.
- BFS, on the other hand, will always find the shortest path, altough the ordering of the edges of the graph still has an impact on the total steps taken by the algorithm.