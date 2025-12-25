# 🔹 Merging Intervals — My Thought Process & Explanation

---

## 1. Core idea behind my approach

When I looked at the **Merge Intervals** problem, my main realization was:

> **Intervals can only be merged correctly if they are processed in sorted order.**

So my approach naturally broke into **three clear steps**:

1. **Sort the intervals** based on their start time
2. **Iterate through the intervals and merge overlapping ones**
3. **Store the merged intervals and return them in the required format**

Instead of comparing every interval with every other interval, I chose a **linear scan approach** after sorting, which makes the solution efficient and clean.

---

## 2. Why I sorted the intervals first

```java
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
```

By sorting intervals based on their starting point:

* I ensure that when I move from left to right,
* Any overlapping interval will appear **next to the current one**

### Example before sorting:

```
{3,5}, {1,2}, {4,6}
```

### After sorting:

```
{1,2}, {3,5}, {4,6}
```

This sorting makes merging possible in **one pass**.

---

## 3. Data structure choice

```java
List<List<Integer>> copyResult = new ArrayList<>();
```

I used a temporary list (`copyResult`) because:

* I don’t know in advance how many merged intervals there will be
* Lists are flexible and easy to add elements to
* Later, I convert this list into a 2D array

---

## 4. Main merging logic (outer loop)

```java
for (int i = 0, j; i < intervals.length; i = j)
```

Here:

* `i` marks the **start of a new interval group**
* `j` is used to scan forward and merge all overlapping intervals
* After merging, I jump `i` directly to `j` to skip processed intervals

---

## 5. Initializing a new merge range

```java
int st = intervals[i][0];
int end = intervals[i][1];
```

I assume:

* The current interval is the start of a new merged range
* `st` → starting point
* `end` → current maximum ending point

---

## 6. Inner loop — merging overlapping intervals

```java
for (j = i + 1; j < intervals.length && end >= intervals[j][0]; j++)
    end = Math.max(end, intervals[j][1]);
```

### What I’m checking:

* If the next interval **starts before or at the current `end`**
* Then the intervals overlap and should be merged

### What I do:

* Extend `end` to the maximum possible value

---

## 7. Step-by-step example using table

### Input:

```java
intervals = [[1,3],[2,6],[8,10],[15,18]]
```

### After sorting:

```java
[[1,3],[2,6],[8,10],[15,18]]
```

---

### Iteration 1

| i | j | Current Interval | st | end | Action           |
| - | - | ---------------- | -- | --- | ---------------- |
| 0 | 1 | [1,3]            | 1  | 3   | Start new range  |
| 0 | 2 | [2,6]            | 1  | 6   | Overlaps → merge |
| 0 | 2 | [8,10]           | —  | —   | Stop merging     |

✅ Merged range → `[1,6]`

---

### Iteration 2

| i | j | Current Interval | st | end | Action     |
| - | - | ---------------- | -- | --- | ---------- |
| 2 | 3 | [8,10]           | 8  | 10  | No overlap |

✅ Merged range → `[8,10]`

---

### Iteration 3

| i | j | Current Interval | st | end | Action     |
| - | - | ---------------- | -- | --- | ---------- |
| 3 | 4 | [15,18]          | 15 | 18  | No overlap |

✅ Merged range → `[15,18]`

---

### Stored result (`copyResult`)

```
[[1,6], [8,10], [15,18]]
```

---

## 8. Converting List to 2D array

```java
int ans[][] = new int[copyResult.size()][2];
```

I convert the list into the required output format because:

* The problem expects a `int[][]` as output
* Lists are only used internally for convenience

---

## 9. Time and Space Complexity

### ⏱ Time Complexity

| Step         | Complexity     |
| ------------ | -------------- |
| Sorting      | O(n log n)     |
| Merging scan | O(n)           |
| **Total**    | **O(n log n)** |

---

### 💾 Space Complexity

| Component       | Space    |
| --------------- | -------- |
| Result storage  | O(n)     |
| Extra variables | O(1)     |
| **Total**       | **O(n)** |

---

## 10. Final summary (in my own words)

> I first sorted the intervals to ensure overlapping intervals appear consecutively. Then, I iterated through the sorted list and merged intervals by expanding the end whenever overlap occurred. By skipping already merged intervals and storing results dynamically, I achieved an efficient and clean solution.

---
