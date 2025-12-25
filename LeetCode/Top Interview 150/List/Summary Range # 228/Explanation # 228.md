# Core Concept -> Intervals
## 1. Core idea behind my approach -

When I approached this problem, **my main goal was to identify continuous ranges of consecutive numbers** in the sorted array `nums` and convert each range into a string.

So my thinking process was:

* If numbers are **consecutive**, they belong to the **same range**
* If a number breaks the consecutive pattern, the **current range ends**
* I only need to store:

  * The **start of the range**
  * The **end of the range**

To do this efficiently, I decided to use **two pointers**:

* `p1` → marks the **start** of a range
* `p2` → moves forward to find how far the range goes

This allows me to scan the array **only once**, grouping consecutive numbers together.

---

## 2. Step-by-step explanation using examples and tables

### Example 1

```java
nums = [0, 1, 2, 4, 5, 7]
```

### Initial setup

```java
List<String> result = new ArrayList<>();
```

I initialize an empty list to store the final ranges.

---

### Loop structure

```java
for(int p1 = 0, p2 = 1; p1 < nums.length; p2++)
```

* `p1` → start of range
* `p2` → explores forward
* The loop continues until `p1` reaches the end of the array

---

### While condition

```java
while(p2 < nums.length && nums[p2 - 1] == nums[p2] - 1)
    p2++;
```

This checks:

* Are the current and previous numbers **consecutive**?
* If yes → extend the range by moving `p2`

---

### Iteration breakdown (tabular form)

#### First range

| Pointer | Index     | Value     |
| ------- | --------- | --------- |
| p1      | 0         | 0         |
| p2      | 1 → 2 → 3 | 1 → 2 → 4 |

* `0 → 1 → 2` are consecutive
* Stops when `4` breaks the pattern

So I form:

```
"0->2"
```

Then:

```java
p1 = p2;  // p1 = 3
```

---

#### Second range

| Pointer | Index | Value |
| ------- | ----- | ----- |
| p1      | 3     | 4     |
| p2      | 4 → 5 | 5 → 7 |

* `4 → 5` are consecutive
* Stops at `7`

Range added:

```
"4->5"
```

---

#### Third range

| Pointer | Index             | Value |
| ------- | ----------------- | ----- |
| p1      | 5                 | 7     |
| p2      | 6 (out of bounds) | —     |

* Only one number
* So I add it as a single value

Range added:

```
"7"
```

---

### Final Output

```java
["0->2", "4->5", "7"]
```

---

## 3. Single-element range logic

```java
if (p1 == p2 - 1)
    result.add("" + nums[p1]);
else
    result.add(nums[p1] + "->" + nums[p2 - 1]);
```

My logic here is:

* If `p1` and `p2 - 1` point to the **same index**, the range has **only one number**
* Otherwise, it’s a valid range with a start and end

---

## 4. Time and Space Complexity

### ⏱ Time Complexity: **O(n)**

* Each element is visited **once**
* `p2` only moves forward, never backward
* Total operations scale linearly with input size

---

### 💾 Space Complexity: **O(1)** (excluding output)

* I only use a few variables (`p1`, `p2`)
* No extra data structures besides the output list
* Output space is required by the problem itself

---

## 5. Why this approach is effective

* Clean and readable logic
* Efficient single pass
* Avoids nested loops
* Handles edge cases (single element, empty array)

---

### ✅ Final Thought (in my own words)

> I used a two-pointer approach to track the start and end of consecutive sequences. By extending the second pointer while numbers remain consecutive and then recording the range, I efficiently converted the array into summarized ranges in one pass.
