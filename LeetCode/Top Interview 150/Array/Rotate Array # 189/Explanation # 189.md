## 🔁 Rotate Array by *k* Steps

### 🔹 Core Idea Behind My Approach

When I approached this problem, my main thought was:

> *If an element is currently at index `i`, after rotating the array to the right by `k` steps, it should end up at index `(i + k) % n`.*

So instead of rotating the array step-by-step (which can be inefficient and messy), I:

1. Created a **new array** to store the rotated result
2. Placed each element directly into its **final position**
3. Copied the result back into the original array

This keeps the logic **simple, clean, and easy to visualize** 😊

---

## 🧠 Key Observations

```java
int index = k % nums.length;
```

* Rotating by `k` steps is the same as rotating by `k % n`
* This handles cases where `k` is larger than the array length ✔️

---

## 🔁 Step-by-Step Logic

### 🧩 Step 1: Place Elements in Their New Positions

```java
ret[(i + index) % nums.length] = nums[i];
```

For every element:

* I calculate its new index using `(i + k) % n`
* I place it directly into the correct position in the new array

---

### 🔄 Step 2: Copy Back to Original Array

```java
nums[i] = ret[i];
```

Since the problem requires modifying the original array, I copy all values back.

---

## 📌 Example Walkthrough

### Input

```text
nums = [1, 2, 3, 4, 5, 6, 7]
k = 3
```

### After Rotation

```text
[5, 6, 7, 1, 2, 3, 4]
```

---

## 📊 Index Mapping Table

| Original Index (`i`) | Value | New Index `(i + k) % n` | New Array  |
| -------------------- | ----- | ----------------------- | ---------- |
| 0                    | 1     | (0 + 3) % 7 = 3         | ret[3] = 1 |
| 1                    | 2     | 4                       | ret[4] = 2 |
| 2                    | 3     | 5                       | ret[5] = 3 |
| 3                    | 4     | 6                       | ret[6] = 4 |
| 4                    | 5     | 0                       | ret[0] = 5 |
| 5                    | 6     | 1                       | ret[1] = 6 |
| 6                    | 7     | 2                       | ret[2] = 7 |

Final array ➡️ `[5, 6, 7, 1, 2, 3, 4]` 🎉

---

## 🧩 Why This Approach Works Well

✔ Very easy to understand
✔ Direct index calculation (no repeated shifts)
✔ Handles large `k` values gracefully
✔ Clear separation of logic

---

## ⏱️ Time & Space Complexity

### ⏱️ Time Complexity

**O(n)**

* One pass to build the rotated array
* One pass to copy it back

### 🧠 Space Complexity

**O(n)**

* Extra array used to store the rotated result

---

## 🌟 Final Thoughts

While solving this problem, my focus was on:

* Placing each element **exactly where it belongs** 📍
* Avoiding unnecessary swaps or loops
* Keeping the solution readable and intuitive

This solution may use extra space, but it’s **clean, efficient, and great for explaining the idea clearly** 🚀
