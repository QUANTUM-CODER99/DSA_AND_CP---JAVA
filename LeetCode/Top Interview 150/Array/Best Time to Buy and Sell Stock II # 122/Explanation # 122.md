## 💡 My Core Idea While Approaching This Problem

While solving this problem, my main idea was **not** to look for one single best buy and sell day.
Instead, I realized that **every time the price goes up from one day to the next, I can take that profit**.

📌 In simple words:

> *If today’s price is lower than tomorrow’s price, I buy today and sell tomorrow.*

By doing this repeatedly, I automatically capture **all profitable upward movements**, which together give me the **maximum total profit**.

This works because the problem allows **multiple transactions**, as long as I sell before buying again.

---

## 🔍 How the Code Works (Line by Line)

```java
int profit = 0;
```

* I initialize a variable to store the total profit.

```java
for(int i = 0; i < prices.length - 1; i++)
```

* I loop through the array, stopping at `length - 1` because I compare each day with the **next day**.

```java
if(prices[i] < prices[i + 1])
    profit += prices[i + 1] - prices[i];
```

* If the price increases the next day, I add that difference to my total profit.

```java
return profit;
```

* Finally, I return the accumulated profit.

---

## 📊 Example Walkthrough (Using Table)

### Example Input:

```
prices = [7, 1, 5, 3, 6, 4]
```

| Day | Price Today | Price Tomorrow | Action Taken | Profit Added |
| --- | ----------- | -------------- | ------------ | ------------ |
| 0   | 7           | 1              | Skip ❌       | 0            |
| 1   | 1           | 5              | Buy & Sell ✅ | 4            |
| 2   | 5           | 3              | Skip ❌       | 0            |
| 3   | 3           | 6              | Buy & Sell ✅ | 3            |
| 4   | 6           | 4              | Skip ❌       | 0            |

### 🧮 Total Profit:

```
4 + 3 = 7
```

✅ This matches the expected maximum profit.

---

## 🧠 Why This Greedy Approach Works

* I don’t need to predict future prices 📉📈
* I simply **take profit whenever it’s available**
* Multiple small profits = one big maximum profit 💰

This makes the solution:

* Simple
* Efficient
* Easy to implement

---

## ⏱️ Time and Space Complexity

### ⏳ Time Complexity:

```
O(n)
```

* I traverse the prices array only once.

### 🧠 Space Complexity:

```
O(1)
```

* I use only a single variable (`profit`), no extra memory.

---

## 🚀 Final Thoughts

This solution is a clean and optimized way to solve the problem by:

* Observing daily trends
* Using a greedy strategy
* Avoiding unnecessary complexity

Perfect for interviews and competitive coding 💪😄

Let me know if you want a **dry run diagram**, **edge cases**, or **interview explanation version** next!
