## 🧠 My Core Idea While Solving This Problem

When I approached the **Product of Array Except Self** problem, my main goal was:

> **Calculate the product of all elements except the current one — without using division and in O(n) time.**

Instead of recalculating the product for every index (which would be slow), I broke the problem into **two simple parts**:

👉 **For any index `i`:**

```
answer[i] = (product of all elements to the LEFT of i)
          × (product of all elements to the RIGHT of i)
```

So the core concept in my mind was:

> **Precompute prefix products and suffix products, then combine them efficiently.** 🔁

---

## 🔍 Step-by-Step Thought Process

### 1️⃣ Prefix Product (Left Side)

* I created an `output` array.
* At each index `i`, `output[i]` stores the **product of all elements before index `i`**.
* Since there’s nothing before index `0`, I initialized:

```java
output[0] = 1;
```

### Prefix Product Example

For:

```
nums = [1, 2, 3, 4]
```

| Index | nums[i] | Prefix Product (`output[i]`) |
| ----- | ------- | ---------------------------- |
| 0     | 1       | 1                            |
| 1     | 2       | 1 × 1 = 1                    |
| 2     | 3       | 1 × 2 = 2                    |
| 3     | 4       | 2 × 3 = 6                    |

After prefix pass:

```
output = [1, 1, 2, 6]
```

---

### 2️⃣ Suffix Product (Right Side)

* Instead of creating another array, I used a variable `rightProduct`.
* This variable keeps track of the **product of elements to the right**.
* I traversed the array **from right to left** and multiplied `output[i]` with `rightProduct`.

### Suffix Product Walkthrough

Initial:

```
rightProduct = 1
```

| Index | nums[i] | output[i] (before) | rightProduct | output[i] (after) |
| ----- | ------- | ------------------ | ------------ | ----------------- |
| 3     | 4       | 6                  | 1            | 6 × 1 = 6         |
| 2     | 3       | 2                  | 4            | 2 × 4 = 8         |
| 1     | 2       | 1                  | 12           | 1 × 12 = 12       |
| 0     | 1       | 1                  | 24           | 1 × 24 = 24       |

Final Output:

```
[24, 12, 8, 6]
```

✅ Exactly what the problem expects!

---

## ⚡ Why This Approach Is Efficient

* I avoided division ❌
* I avoided nested loops ❌
* I reused the output array to save space 💡

This makes the solution **clean, fast, and optimal** 🚀

---

## ⏱️ Time & Space Complexity

### 🕒 Time Complexity

* Prefix loop → **O(n)**
* Suffix loop → **O(n)**
  ✅ **Total = O(n)**

### 🧠 Space Complexity

* Output array → **O(n)**
* Extra variable (`rightProduct`) → **O(1)**
  ✅ **Total = O(n)** (as required by the problem)

---

## 🎯 Final Takeaway

> I solved this problem by **breaking it into left and right products**, computing them efficiently, and combining them in a single pass — all without using division.

This approach is a **classic example of prefix & suffix optimization**, and it’s extremely useful in array-based problems 💪✨
