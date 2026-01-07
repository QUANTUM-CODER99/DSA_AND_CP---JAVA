## 🧠 My Core Idea While Solving This Problem

When I approached this problem, my main goal was:

> *Compute the product of all elements except the current one — **without using division** and in **O(n)** time.*

### 💡 Key Insight

For every index `i`, the result is:

```text
(product of all elements to the left of i) × (product of all elements to the right of i)
```

So instead of recalculating products again and again, I decided to:

* Compute **right products** in one pass ➡️
* Compute **left products** in another pass ⬅️
* Multiply them together for the final answer

All of this is done using **constant extra space** (excluding the output array) 🧠✨.

---

## 🔍 Explanation of Variables

```java
int output[] = new int[nums.length];
```

➡️ Stores the final result.

```java
int left = 1, right = 1;
```

➡️ Running products:

* `left` → product of elements to the **left**
* `right` → product of elements to the **right**

---

## 🔄 Step-by-Step Code Explanation

### 1️⃣ Right Product Pass (Right → Left)

```java
for (int i = nums.length-1; i > -1; i--) {
    output[i] = right;
    right *= nums[i];
}
```

* I traverse from the **end to the start**.
* `output[i]` temporarily stores the **product of all elements to the right of index i**.
* `right` keeps expanding as I move left.

---

### 2️⃣ Left Product Pass (Left → Right)

```java
for(int i=0;i<nums.length;i++) {
    nums[i] = left;
    left *= nums[i];
}
```

* I reuse the `nums` array to store **left products**.
* `nums[i]` becomes the product of all elements **to the left of index i**.
* This helps save extra space 💾.

---

### 3️⃣ Final Combination Pass

```java
for (int i = 0; i < nums.length; i++)
    output[i] = nums[i] * output[i];
```

* I multiply:

  * left product (`nums[i]`)
  * right product (`output[i]`)
* The result is the **product except self** 🎯.

---

## 📊 Example Walkthrough (Tabular Method)

### Example

**Input:**

```text
nums = [1, 2, 3, 4]
```

---

### ➡️ Right Product Pass

| Index | nums[i] | right (before) | output[i] | right (after) |
| ----- | ------- | -------------- | --------- | ------------- |
| 3     | 4       | 1              | 1         | 4             |
| 2     | 3       | 4              | 4         | 12            |
| 1     | 2       | 12             | 12        | 24            |
| 0     | 1       | 24             | 24        | 24            |

---

### ⬅️ Left Product Pass (stored in `nums`)

| Index | Original nums[i] | left (before) | nums[i] | left (after) |
| ----- | ---------------- | ------------- | ------- | ------------ |
| 0     | 1                | 1             | 1       | 1            |
| 1     | 2                | 1             | 1       | 2            |
| 2     | 3                | 2             | 2       | 6            |
| 3     | 4                | 6             | 6       | 24           |

---

### 🔗 Final Multiplication

| Index | Left (nums[i]) | Right (output[i]) | Final Output |
| ----- | -------------- | ----------------- | ------------ |
| 0     | 1              | 24                | 24           |
| 1     | 1              | 12                | 12           |
| 2     | 2              | 4                 | 8            |
| 3     | 6              | 1                 | 6            |

✔️ **Result:** `[24, 12, 8, 6]`

---

## ⏱️ Time & Space Complexity

### 🕒 Time Complexity

* Three linear passes → **O(n)**

### 💾 Space Complexity

* Output array only → **O(1)** extra space (excluding output)

---

## 🎯 Why This Approach is Efficient

* No division ❌
* No nested loops ❌
* Only prefix & suffix products ✔️
* Clean, optimal, and interview-friendly 🧠🔥

---

## 🚀 Final Takeaway

> *For each index, I split the problem into two independent parts:
> what’s on the left and what’s on the right.
> By combining both, I get the answer in linear time and constant space.*
