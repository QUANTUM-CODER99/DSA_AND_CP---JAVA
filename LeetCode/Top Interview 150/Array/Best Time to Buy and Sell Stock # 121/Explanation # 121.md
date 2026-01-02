## 💹 Best Time to Buy and Sell Stock (My Approach)

### 🔹 Core Idea Behind My Approach

When I approached this problem, my main thought was:

> *To maximize profit, I should buy at the **lowest price seen so far** and sell at a higher price later.*

So I kept track of:

1. The **minimum price** I have seen (`buyPrice`)
2. The **maximum profit** I can achieve if I sell on the current day (`profit`)

I looped through the prices **once**, updating these values as I go — simple and efficient! 🚀

---

## 🔁 Step-by-Step Logic

### 🧠 Initialize Variables

```java
int buyPrice = prices[0];
int profit = 0;
```

* `buyPrice` starts at the first price
* `profit` starts at `0` because we haven’t sold anything yet

---

### 🔄 Traverse Prices

```java
for (int i = 1; i < prices.length; i++) {
    if (buyPrice > prices[i]) {
        buyPrice = prices[i];
    }
    profit = Math.max(profit, prices[i] - buyPrice);
}
```

For each price:

1. If the current price is **lower than `buyPrice`**, I update `buyPrice`
2. Otherwise, I calculate the potential profit (`prices[i] - buyPrice`) and update `profit` if it’s larger than before

---

### 🏁 Return the Maximum Profit

```java
return profit;
```

At the end, `profit` contains the **maximum possible profit** from a single buy-sell transaction 💰

---

## 📌 Example Walkthrough

### Input

```text
prices = [7, 1, 5, 3, 6, 4]
```

### Step-by-Step Table

| Day | Price | buyPrice (Min so far) | Potential Profit | Max Profit So Far |
| --- | ----- | --------------------- | ---------------- | ----------------- |
| 0   | 7     | 7                     | 0                | 0                 |
| 1   | 1     | 1                     | 0                | 0                 |
| 2   | 5     | 1                     | 4                | 4                 |
| 3   | 3     | 1                     | 2                | 4                 |
| 4   | 6     | 1                     | 5                | 5                 |
| 5   | 4     | 1                     | 3                | 5                 |

✅ **Final Output:** `5` (Buy at `1`, sell at `6`)

---

## 🧩 Why This Approach Works Well

✔ Only a **single pass** through the array ⏱️
✔ No nested loops, very efficient
✔ Keeps track of **minimum price dynamically**
✔ Very intuitive and easy to implement 💡

---

## ⏱️ Time & Space Complexity

### ⏱️ Time Complexity

**O(n)**

* One pass through the array

### 🧠 Space Complexity

**O(1)**

* Only two variables used (`buyPrice` and `profit`)

---

## 🌟 Final Thoughts

While solving this problem, my focus was on:

* Tracking the **lowest buying price** dynamically
* Calculating profit **on-the-fly**
* Avoiding extra loops or arrays

This makes the solution **clean, efficient, and perfect for large input arrays** 💹🔥
