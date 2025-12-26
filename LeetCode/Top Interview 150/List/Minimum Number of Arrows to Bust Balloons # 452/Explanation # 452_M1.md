# 📈 Core Concept - Intervals
## 1. Core idea behind my approach

When I looked at this problem (Minimum Number of Arrows to Burst Balloons), I thought of it as an **interval overlapping problem**.

Each balloon is an interval:

```
[start, end]
```

An arrow shot at position `x` can burst **all balloons whose intervals include `x`**.

### What I realized

* If multiple balloons **overlap**, I can burst all of them using **one arrow**.
* So my goal became:
  **Group overlapping intervals and use one arrow per group.**

### Strategy I formed

1. **Sort the balloons by their starting point**
   This helps me process balloons from left to right.
2. Start with the **first balloon**, and assume I shoot an arrow somewhere within its range.
3. As long as the next balloon **overlaps** with the current one, I can still use the **same arrow**.
4. To keep the arrow valid for all overlapping balloons, I **shrink the arrow range** to the minimum possible end.
5. Once I find a balloon that **does not overlap**, I:

   * Increment the arrow count
   * Start a new group from that balloon

This is a **greedy approach** — at each step, I make the best local decision to minimize arrows.

---

## 2. Step-by-step explanation with example and table

### Example input

```java
int[][] points = {
    {10,16},
    {2,8},
    {1,6},
    {7,12}
};
```

---

### Step 1: Sort by starting point

After sorting:

```
[1,6], [2,8], [7,12], [10,16]
```

---

### Step 2: Walk through balloons and group overlaps

| Step | i | Current Balloon | currentPointer (end) | Next Balloon | Overlap? | Action                         |
| ---- | - | --------------- | -------------------- | ------------ | -------- | ------------------------------ |
| 1    | 0 | [1,6]           | 6                    | [2,8]        | Yes      | Shrink pointer → min(6,8)=6    |
| 2    | 0 | [1,6]           | 6                    | [7,12]       | No       | Shoot arrow (count = 1)        |
| 3    | 2 | [7,12]          | 12                   | [10,16]      | Yes      | Shrink pointer → min(12,16)=12 |
| 4    | 2 | [7,12]          | 12                   | End          | —        | Shoot arrow (count = 2)        |

---

### Final result

```
Minimum arrows needed = 2
```

---

## 3. How the code matches my thinking

### Sorting step

```java
Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
```

* I sort by start position so I can process balloons sequentially.

---

### Main loop logic

```java
for (int i = 0, j; i < points.length;) {
    long currentPointer = points[i][1];
```

* I assume I shoot an arrow at the **end of the first balloon**.

---

### Checking overlaps

```java
for (j = i + 1; j < points.length && currentPointer >= points[j][0]; j++)
    currentPointer = Math.min(currentPointer, points[j][1]);
```

* If the next balloon starts before my arrow position, it overlaps.
* I reduce the arrow position to the smallest possible end to keep it valid.

---

### Counting arrows

```java
arrrow++;
i = j;
```

* Once overlap ends, I shoot one arrow and move to the next group.

---

## 4. Time and Space Complexity

### Time Complexity

* **Sorting:** `O(n log n)`
* **Single traversal:** `O(n)`

✅ **Total Time Complexity:**

```
O(n log n)
```

---

### Space Complexity

* Sorting is done in place.
* No extra data structures are used.

✅ **Space Complexity:**

```
O(1) (excluding input array)
```

---

## 5. One-line summary (your mindset)

> *I treated the problem as overlapping intervals, sorted them, greedily grouped overlapping balloons, and minimized arrows by always keeping the arrow position as tight as possible.*
