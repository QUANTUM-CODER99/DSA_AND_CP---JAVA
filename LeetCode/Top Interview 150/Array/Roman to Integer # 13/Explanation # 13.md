## 🧠 Core Idea (My Thought Process)

While solving **Roman to Integer**, I focused on **how Roman numerals are added or subtracted** based on order.

👉 My key realization was:

* **If a symbol is smaller than the one after it, I subtract it**
* **Otherwise, I add it**

So instead of checking all special cases like `IV`, `IX`, `XL`, etc., I relied purely on **relative ordering** of symbols. This makes the solution clean and scalable 🚀

---

## 🔍 How I Implemented the Idea

### 1️⃣ I standardized the input

```java
s = s.trim() + " ";
```

* I remove extra spaces
* I add a **dummy space** at the end so I can safely compare `s[i]` with `s[i+1]` without worrying about out-of-bounds

---

### 2️⃣ I mapped Roman symbols to values using index positions

```java
String sign = "MDCLXVI ";
int value[] = {1000, 500, 100, 50, 10, 5, 1, 0};
```

Here:

* The **index of a character in `sign`** directly maps to its numeric value
* This avoids using HashMaps and keeps space constant 🧠

---

### 3️⃣ I compared adjacent characters

```java
if (sign.indexOf(s.charAt(i)) > sign.indexOf(s.charAt(i+1)))
    sum -= value[sign.indexOf(s.charAt(i))];
else
    sum += value[sign.indexOf(s.charAt(i))];
```

* Smaller index → larger value
* Larger index → smaller value

So:

* If current symbol is **smaller than the next**, I subtract ❌
* Otherwise, I add ✅

---

## 📊 Example Walkthrough (Tabular Method)

### Example: `s = "MCMIV"`

| i | Current | Next    | Comparison | Action | Sum  |
| - | ------- | ------- | ---------- | ------ | ---- |
| 0 | M       | C       | M > C      | +1000  | 1000 |
| 1 | C       | M       | C < M      | -100   | 900  |
| 2 | M       | I       | M > I      | +1000  | 1900 |
| 3 | I       | V       | I < V      | -1     | 1899 |
| 4 | V       | (space) | V > space  | +5     | 1904 |

✅ Final Answer: **1904**

---

## ⚙️ Why This Approach Works Well

* No need to handle special Roman cases separately
* Pure comparison-based logic
* Clean and elegant greedy strategy ✨

---

## ⏱️ Time & Space Complexity

### 🕒 Time Complexity

**O(n)**

* I traverse the string once

### 🧺 Space Complexity

**O(1)**

* Fixed-size arrays and variables only

---

## 🎯 Final Takeaway

💡 Instead of memorizing Roman numeral rules, I let **ordering do the work**.
By comparing each symbol with the next one, I naturally handle both **addition and subtraction cases** without extra conditions
