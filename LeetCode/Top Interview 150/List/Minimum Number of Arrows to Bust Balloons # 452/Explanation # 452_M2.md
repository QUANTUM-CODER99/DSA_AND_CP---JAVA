# 📈 Core Concept -> Intervals
## 1. Core Idea I Had While Approaching This Problem

When I looked at the problem (minimum number of arrows to burst all balloons), I realized a few key things:

* Each balloon is represented as an **interval** `[start, end]`
* One arrow can burst **multiple balloons** if it is shot at a position that lies **within all of their intervals**
* So essentially, this becomes an **interval overlapping problem**

### My main thought process was:

> “If I shoot an arrow at the **end** of a balloon, it has the maximum chance to burst other balloons that overlap with it.”

That led me to a **greedy strategy**:

* **Sort balloons by their ending position**
* Always shoot an arrow at the **earliest possible end**
* Reuse the same arrow for all balloons whose start is ≤ the arrow position

This way, I minimize the number of arrows.

---

## 2. Step-by-Step Explanation Using an Example (with Table)

### Example Input

```java
points = [[10,16], [2,8], [1,6], [7,12]]
```

---

### Step 1: Sort by Ending Point

I sort the balloons based on their `end` value:

| Balloon | Start | End |
| ------- | ----- | --- |
| B1      | 1     | 6   |
| B2      | 2     | 8   |
| B3      | 7     | 12  |
| B4      | 10    | 16  |

This sorting is done using:

```java
Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
```

---

### Step 2: Initialize First Arrow

* I **must** use at least one arrow
* I shoot the first arrow at the **end of the first balloon**

```java
int arrows = 1;
long end = points[0][1]; // end = 6
```

So:

* **Arrow #1** is shot at position **6**

---

### Step 3: Traverse Remaining Balloons

Now I check each balloon one by one.

| Balloon | Start | End | Condition (`start > end?`) | Action           |
| ------- | ----- | --- | -------------------------- | ---------------- |
| B2      | 2     | 8   | 2 > 6 ❌                    | Same arrow works |
| B3      | 7     | 12  | 7 > 6 ✅                    | New arrow needed |
| B4      | 10    | 16  | 10 > 12 ❌                  | Same arrow works |

---

### How Decisions Were Made

* **B2** overlaps with arrow at `6` → no new arrow
* **B3** starts after `6` → I need a new arrow

  * arrows = 2
  * end = 12
* **B4** overlaps with arrow at `12` → no new arrow

---

### Final Result

```java
return arrows; // 2
```

✔ **Minimum arrows required = 2**

---

## 3. Why This Greedy Approach Works

I always:

* Shoot arrows at the **earliest ending balloon**
* This ensures maximum overlap coverage
* Any later position would reduce the chance of overlapping with upcoming balloons

This is a **classic greedy interval scheduling problem**.

---

## 4. Time and Space Complexity

### Time Complexity

* Sorting balloons: **O(n log n)**
* Single traversal: **O(n)**

✅ **Overall Time Complexity:**
[
O(n \log n)
]

---

### Space Complexity

* Sorting is done in place
* Only a few variables are used

✅ **Space Complexity:**
[
O(1)
]
*(Ignoring input storage)*

---

## 5. Final Summary (In My Own Words)

* I converted the problem into an **interval overlap problem**
* I used a **greedy approach**
* By sorting based on end points, I ensured:

  * Fewer arrows
  * Maximum overlap coverage
* The solution is efficient and optimal

This approach is clean, intuitive, and works perfectly for large inputs.
