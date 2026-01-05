## 🧠 My Thought Process (Core Idea)

When I approached the **Climbing Stairs** problem, I realized that:

* At every step, I only have **two choices**:
  👉 climb **1 step**
  👉 climb **2 steps**
* The **total number of ways** to reach the top from a given step is the **sum of ways** from the next 1 and 2 steps.

This observation naturally leads to a **recursive solution**.
However, plain recursion would recompute the same subproblems again and again 😵.

💡 **Key optimization idea:**

> Store already computed results so that each step is solved only once.

That’s why I used **Dynamic Programming with Memoization**.

---

## 🔁 How the Code Works (Step-by-Step)

### 1️⃣ State Definition

* `level` → current step I am on
* `n` → total number of steps
* `dp[level]` → number of ways to reach the top from `level`

---

### 2️⃣ Base Case

```java
if (level == n) return 1;
```

✔️ If I reach exactly the top, that means I’ve found **one valid way**.

---

### 3️⃣ Memoization Check

```java
if (dp[level] != 0) return dp[level];
```

✔️ If I’ve already calculated the number of ways from this level, I simply reuse it.
This avoids unnecessary recomputation 🚀.

---

### 4️⃣ Recursive Relation

```java
ways += rec(level + 1, n);
ways += rec(level + 2, n);
```

✔️ From the current step, I try:

* jumping **1 step**
* jumping **2 steps**

and add up all possible ways.

---

### 5️⃣ Store & Return

```java
dp[level] = ways;
return ways;
```

✔️ Save the result so it can be reused later.

---

## 📌 Example Walkthrough (n = 5)

Let’s say `n = 5`.

### Valid Ways:

```
1 1 1 1 1
1 1 1 2
1 1 2 1
1 2 1 1
2 1 1 1
2 2 1
1 2 2
```

👉 **Total = 8 ways**

---

## 📊 Tabular Representation (DP Values)

| Step (level) | Ways to reach step `n` |
| ------------ | ---------------------- |
| 5            | 1                      |
| 4            | 1                      |
| 3            | 2                      |
| 2            | 3                      |
| 1            | 5                      |
| 0            | 8                      |

🧩 Each value is calculated as:

```
dp[i] = dp[i + 1] + dp[i + 2]
```

This is why the solution behaves like a **Fibonacci sequence** 📈.

---

## ⏱️ Time Complexity

### ✅ **O(n)**

* Each step (`0` to `n`) is computed **only once**.
* Memoization removes duplicate recursive calls.

---

## 🧠 Space Complexity

### ✅ **O(n)**

* `dp[]` array of size `n + 1`
* Recursive call stack can go up to depth `n`

---

## 🎯 Final Summary

✔️ I used **recursion** to explore all possible paths
✔️ I optimized it using **memoization (DP)**
✔️ This reduced time complexity from **exponential → linear**
✔️ The problem is essentially a **Fibonacci-style DP problem**

💪 Clean, efficient, and interview-ready solution!

🚀 Happy coding! 😊
