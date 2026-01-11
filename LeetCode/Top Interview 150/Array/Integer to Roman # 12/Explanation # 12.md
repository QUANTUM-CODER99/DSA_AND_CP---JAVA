## 🧠 Core Idea (My Thought Process)

While solving **Integer to Roman**, I thought in the **reverse direction** of the previous problem.

👉 My main realization was:

* Roman numerals are built by **always subtracting the largest possible value**
* If I keep choosing the **maximum Roman value ≤ number**, I’ll automatically form the correct numeral

So I used a **greedy approach** where I repeatedly reduce the number until it becomes `0` 🧠✨

---

## 🔍 How I Implemented the Idea

### 1️⃣ I listed all Roman building blocks (including subtractive cases)

```java
int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
```

* I **explicitly included subtractive cases** like `900 (CM)` and `4 (IV)`
* This lets me avoid special-case logic later 🚀

---

### 2️⃣ I built the Roman numeral greedily

```java
while (num >= values[i]) {
    sb.append(symbols[i]);
    num -= values[i];
}
```

* As long as the current value fits into `num`, I:

  * Append its Roman symbol
  * Subtract it from `num`

This guarantees the numeral is constructed from **largest to smallest**, just like Roman notation 📜

---

## 📊 Example Walkthrough (Tabular Method)

### Example: `num = 1994`

| Step | Value Used | Symbol | Remaining Num | Result  |
| ---- | ---------- | ------ | ------------- | ------- |
| 1    | 1000       | M      | 994           | M       |
| 2    | 900        | CM     | 94            | MCM     |
| 3    | 90         | XC     | 4             | MCMXC   |
| 4    | 4          | IV     | 0             | MCMXCIV |

✅ Final Answer: **MCMXCIV**

---

## ⚙️ Why This Approach Works

* Roman numerals always follow a **descending value order**
* Including subtractive cases ensures correctness
* Greedy choice is always optimal here 💡

---

## ⏱️ Time & Space Complexity

### 🕒 Time Complexity

**O(1)**

* The loop runs over a fixed-size array (13 values)
* Independent of input size

### 🧺 Space Complexity

**O(1)**

* Only constant extra space is used

---

## 🎯 Final Takeaway

💡 I converted the number by **breaking it into known Roman chunks**, always taking the biggest possible piece first.

This greedy strategy keeps the solution:

* Simple
* Readable
* Interview-friendly 🚀
