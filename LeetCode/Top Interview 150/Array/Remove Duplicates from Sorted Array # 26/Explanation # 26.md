## 1. Core Idea I Had While Approaching This Problem

When I read this problem, the most important thing I noticed was:

* The array is **already sorted**
* I need to **remove duplicates in-place**
* I only care about the **first k elements** after removal

So my main realization was:

> “Since duplicates are next to each other, I don’t need extra space. I just need a way to track the last unique element.”

That naturally led me to a **two-pointer approach**.

---

## 2. What Each Pointer Represents

```java
int p = 0;
```

* `p` represents the **index of the last unique element**
* Everything from `0` to `p` is always **unique and correct**

```java
for (int i = 1; i < nums.length; i++)
```

* `i` is used to **scan the array**
* I compare the current element with the last unique one

---

## 3. Step-by-Step Explanation Using Example + Table

### Example Input

```java
nums = [1,1,2,2,3]
```

---

### Initial State

| Index | 0 | 1 | 2 | 3 | 4 |
| ----- | - | - | - | - | - |
| nums  | 1 | 1 | 2 | 2 | 3 |

* `p = 0`
* Unique part = `[1]`

---

### Iteration Breakdown

| i | nums[i] | nums[p] | nums[i] != nums[p] | Action    | p | Array State |
| - | ------- | ------- | ------------------ | --------- | - | ----------- |
| 1 | 1       | 1       | ❌                  | Skip      | 0 | [1,1,2,2,3] |
| 2 | 2       | 1       | ✅                  | p++, copy | 1 | [1,2,2,2,3] |
| 3 | 2       | 2       | ❌                  | Skip      | 1 | [1,2,2,2,3] |
| 4 | 3       | 2       | ✅                  | p++, copy | 2 | [1,2,3,2,3] |

---

### Final State

* `p = 2`
* Unique elements are in indices `0` to `2`

```java
return p + 1; // 3
```

✔ Final array (valid part): `[1,2,3]`
✔ Length of unique elements: `3`

---

## 4. Why This Approach Works

In my head, this is what’s happening:

* Because the array is sorted, duplicates are adjacent
* I only move `p` **when I find a new value**
* Every time I move `p`, I overwrite the next position with a new unique element

This ensures:

* No extra space
* No unnecessary copying
* Clean and efficient logic

---

## 5. Edge Case Handling

```java
if (nums.length == 0 || nums.length == 1)
    return nums.length;
```

I added this to handle:

* Empty array
* Single-element array

These cases already satisfy the requirement.

---

## 6. Time and Space Complexity

### Time Complexity

* Single pass through the array

[
\textbf{O(n)}
]

---

### Space Complexity

* Only pointers used

[
\textbf{O(1)}
]

---

## 7. Final Summary 

* I took advantage of the **sorted nature** of the array
* I used a **two-pointer technique**
* One pointer tracked unique elements, the other scanned the array
* I modified the array **in-place**
* The solution is optimal and interview-ready

This is a classic example of how understanding the **input constraints** leads directly to an efficient solution.
