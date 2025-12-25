# 🔹 Insert Interval — My Thought Process & Explanation

---

## 1. Core idea behind my approach

When I approached the **Insert Interval** problem, my key realization was:

> The given intervals are **already sorted and non-overlapping**.

Because of that, I didn’t need to sort again or use complex data structures.
My entire strategy was to **walk through the intervals once** and split the work into **three logical phases**:

1. **Add all intervals that end before the new interval starts**
2. **Merge all intervals that overlap with the new interval**
3. **Add all remaining intervals that come after the new interval**

This lets me handle the insertion and merging in **one linear pass**, which is both efficient and easy to reason about.

---

## 2. Data structure choice

```java
List<int[]> result = new ArrayList<>();
```

I used a list because:

* I don’t know beforehand how many intervals will be in the final result
* It allows me to append intervals dynamically
* I can easily convert it to a 2D array at the end

---

## 3. Phase 1 — Add intervals completely before `newInterval`

```java
while (i < n && intervals[i][1] < newInterval[0]) {
    result.add(intervals[i]);
    i++;
}
```

### What I’m thinking here

If an interval **ends before** `newInterval` **starts**, then:

* It cannot overlap
* It can be added directly to the result

---

### Example

```java
intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]
newInterval = [4,8]
```

### Phase 1 table

| i | Interval | Interval End < newStart? | Action |
| - | -------- | ------------------------ | ------ |
| 0 | [1,2]    | 2 < 4 ✔                  | Add    |
| 1 | [3,5]    | 5 < 4 ✘                  | Stop   |

✅ Result so far:

```
[[1,2]]
```

---

## 4. Phase 2 — Merge overlapping intervals

```java
while (i < n && intervals[i][0] <= newInterval[1]) {
    newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
    i++;
}
```

### What I’m thinking here

If an interval:

* **Starts before or at** the end of `newInterval`
* Then it overlaps and must be merged

So I:

* Expand `newInterval` to include the overlap
* Keep doing this until no overlap remains

---

### Phase 2 table

| i | Interval | Overlaps? | newStart   | newEnd     |
| - | -------- | --------- | ---------- | ---------- |
| 1 | [3,5]    | Yes       | min(4,3)=3 | max(8,5)=8 |
| 2 | [6,7]    | Yes       | 3          | 8          |
| 3 | [8,10]   | Yes       | 3          | 10         |
| 4 | [12,16]  | No        | —          | —          |

✅ Merged interval:

```
[3,10]
```

---

## 5. Insert merged interval

```java
result.add(newInterval);
```

At this point:

* All overlapping intervals have been merged
* I add the final merged interval once

---

## 6. Phase 3 — Add remaining intervals

```java
while (i < n) {
    result.add(intervals[i]);
    i++;
}
```

### What I’m thinking here

Any interval left:

* Starts after `newInterval` ends
* Cannot overlap
* Can be safely appended

---

### Phase 3 table

| i | Interval | Action |
| - | -------- | ------ |
| 4 | [12,16]  | Add    |

---

## 7. Final result

```
[[1,2],[3,10],[12,16]]
```

---

## 8. Converting List to 2D array

```java
return result.toArray(new int[result.size()][]);
```

I convert the list into a 2D array because:

* The problem requires `int[][]` output
* The internal list is only for convenience

---

## 9. Time and Space Complexity

### ⏱ Time Complexity — **O(n)**

| Operation                     | Complexity |
| ----------------------------- | ---------- |
| Single pass through intervals | O(n)       |
| **Total**                     | **O(n)**   |

---

### 💾 Space Complexity — **O(n)**

| Component       | Space    |
| --------------- | -------- |
| Result list     | O(n)     |
| Extra variables | O(1)     |
| **Total**       | **O(n)** |

---

## 10. Final summary (in my own words)

> I took advantage of the fact that intervals were already sorted and non-overlapping. By processing intervals in three clear phases—before, overlapping, and after—I was able to insert and merge the new interval efficiently in a single pass.

---
