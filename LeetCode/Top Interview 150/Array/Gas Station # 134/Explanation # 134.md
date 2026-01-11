## 🚗 Gas Station Problem – My Thought Process & Solution Explanation

When I approached this problem, my goal was to **avoid brute force simulation** and instead rely on **greedy logic and observations**.

---

## 🧠 1. Core Idea Behind My Approach

While thinking about this problem, I focused on **two key insights**:

### 🔑 Insight 1: Overall feasibility check

Before worrying about *where* to start, I asked:

> **Is it even possible to complete the circuit?**

If the **total gas available** is less than the **total cost required**, then **no starting point can work** ❌.

That’s why I first calculate:

```java
totalGas = sum of gas[]
totalCost = sum of cost[]
```

If `totalGas < totalCost`, I immediately return `-1`.

---

### 🔑 Insight 2: Greedy starting point selection

Once I know the journey *is possible*, I use a **greedy approach**:

* I try to move from station `0 → n-1`
* I track `currentGas`
* If `currentGas` ever becomes **negative**, it means:

  * I **cannot** start from any station between the last start and the current one
  * So I **reset** and try starting from the **next station**

This works because:

> If I fail at station `i`, then any start before `i` would fail even earlier 🚫

---

## 🔍 2. Example Walkthrough (with Table 📊)

### Example:

```text
gas  = [1, 2, 3, 4, 5]
cost = [3, 4, 5, 1, 2]
```

### Step-by-step simulation:

| Station (i) | Gas[i] | Cost[i] | Gain (Gas - Cost) | Current Gas | Start     |
| ----------- | ------ | ------- | ----------------- | ----------- | --------- |
| 0           | 1      | 3       | -2                | -2 ❌        | reset → 1 |
| 1           | 2      | 4       | -2                | -2 ❌        | reset → 2 |
| 2           | 3      | 5       | -2                | -2 ❌        | reset → 3 |
| 3           | 4      | 1       | +3                | 3           | 3         |
| 4           | 5      | 2       | +3                | 6           | 3         |

✅ I successfully complete the circuit starting at **station 3**.

---

## ⚙️ 3. Code Logic Breakdown

### Step 1: Check total feasibility

```java
if (totalGas < totalCost) {
    return -1;
}
```

👉 If this fails, no solution exists.

---

### Step 2: Find valid starting point

```java
for (int i = 0; i < gas.length; i++) {
    currentGas += gas[i] - cost[i];
    if (currentGas < 0) {
        currentGas = 0;
        start = i + 1;
    }
}
```

* I keep accumulating gas
* If it drops below zero:

  * I reset `currentGas`
  * I move the start forward

---

## ⏱️ 4. Time & Space Complexity

### ✅ Time Complexity

**O(n)**

* I traverse the arrays only once

### ✅ Space Complexity

**O(1)**

* I use only constant extra variables

---

## 🎯 Final Thoughts

* This solution is **efficient**, **clean**, and **greedy**
* It avoids unnecessary simulations
* It works because a failed segment can never be part of the final answer 🚀

💡 **Key takeaway:**

> If the total gas is sufficient, there is **exactly one valid starting point**, and this greedy method always finds it.
