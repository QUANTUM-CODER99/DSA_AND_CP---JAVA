## 1. Core Idea I Had While Approaching This Problem

When I looked at this problem, I noticed something very important:

* `nums1` already has **extra space at the end** to hold all elements of `nums2`
* Both `nums1` (first `m` elements) and `nums2` (first `n` elements) are **already sorted**

So my key realization was:

> “If I start merging from the **end** instead of the beginning, I won’t overwrite useful values in `nums1`.”

### Why merging from the end is smart

* If I start from the beginning, I would have to shift elements many times
* By starting from the end, I can safely place the **largest elements first**
* This allows me to merge **in-place**, without extra memory

That’s why I used **three pointers**:

* `p1` → last valid element of `nums1`
* `p2` → last element of `nums2`
* `i` → last index of merged array (`nums1`)

---

## 2. Understanding the Pointers

```java
int p1 = m - 1;
int p2 = n - 1;
int i = m + n - 1;
```

| Pointer | Meaning                                      |
| ------- | -------------------------------------------- |
| `p1`    | Points to last valid element in `nums1`      |
| `p2`    | Points to last element in `nums2`            |
| `i`     | Position where the next largest element goes |

---

## 3. Step-by-Step Explanation Using Example + Table

### Example Input

```java
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
```

Initial State:

| nums1 | 1 | 2 | 3 | 0 | 0 | 0 |
| ----- | - | - | - | - | - | - |
| index | 0 | 1 | 2 | 3 | 4 | 5 |

Pointers:

* `p1 = 2` (value = 3)
* `p2 = 2` (value = 6)
* `i = 5`

---

### Iteration Breakdown

| Step | nums1[p1] | nums2[p2] | Larger | Placed At | nums1 After   |
| ---- | --------- | --------- | ------ | --------- | ------------- |
| 1    | 3         | 6         | 6      | index 5   | [1,2,3,0,0,6] |
| 2    | 3         | 5         | 5      | index 4   | [1,2,3,0,5,6] |
| 3    | 3         | 2         | 3      | index 3   | [1,2,3,3,5,6] |
| 4    | 2         | 2         | 2      | index 2   | [1,2,2,3,5,6] |
| 5    | 1         | —         | 1      | index 1   | [1,2,2,3,5,6] |

---

### Loop Condition Explained

```java
while (p2 >= 0)
```

I only check `p2` because:

* If `nums2` is fully merged, `nums1` is already sorted
* Any remaining elements in `nums1` are already in correct position

---

## 4. Key Logic Explained

```java
if (p1 >= 0 && nums1[p1] > nums2[p2])
    nums1[i--] = nums1[p1--];
else
    nums1[i--] = nums2[p2--];
```

In my mind:

* I compare the **largest unmerged elements**
* Place the **larger one** at the end
* Move pointers accordingly

This guarantees correct order without overwriting data.

---

## 5. Final Result

After the loop ends:

```java
nums1 = [1,2,2,3,5,6]
```

✅ Correctly merged and sorted
✅ No extra space used
✅ Efficient and clean solution

---

## 6. Time and Space Complexity

### Time Complexity

* Each element is visited once
* Single loop

[
\textbf{O(m + n)}
]

---

### Space Complexity

* No extra array used
* Only pointers

[
\textbf{O(1)}
]

---

## 7. Final Summary (In My Own Words)

* I leveraged the **extra space in nums1**
* I merged from the **end to avoid overwriting**
* I used a **three-pointer technique**
* The solution is **in-place, optimal, and efficient**

This approach is a textbook example of **smart pointer usage** in array problems.
