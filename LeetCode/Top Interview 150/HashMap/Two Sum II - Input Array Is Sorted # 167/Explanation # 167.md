## 🧠 My Thought Process (Core Idea)

When I started solving the **Two Sum** problem, my main goal was to **find two numbers whose sum equals the target in the most efficient way possible**.

Instead of using a brute-force approach with two nested loops (which would be slow ⏳), I realized I could:

* **Remember numbers I’ve already seen**
* Check if the **complement** (`target - currentNumber`) already exists

This led me to use a **HashMap**, which allows **constant-time lookups** ⚡

---

## ✨ Key Idea Behind the Approach

For every number in the array:

1. I calculate the value needed to reach the target
   👉 `complement = target - currentNumber`
2. I check if this complement already exists in the map
3. If it exists, I’ve found my answer 🎯
4. If not, I store the current number with its index for future use

---

## 🗂 Why I Used a HashMap

* **Key** → Number from the array
* **Value** → Index where that number appears

This allows me to quickly check whether the needed complement has already been encountered 💡

---

## 🧪 Example Walkthrough

### Input:

```text
nums = [2, 7, 11, 15]
target = 9
```

### Step-by-Step Execution (Tabular View)

|  i | nums[i] | target - nums[i] | HashMap (pairIdx) | Match Found? |
| -: | ------: | ---------------: | ----------------: | ------------ |
|  0 |       2 |                7 |                {} | ❌            |
|    |         |                  |           {2 → 0} |              |
|  1 |       7 |                2 |           {2 → 0} | ✅            |

✔ Complement `2` exists in the map
✔ Indices found → `[0 + 1, 1 + 1]` → **[1, 2]**

---

## 🔎 Why `+1` in the Result?

I returned:

```java
{pairIdx.get(target - num) + 1, i + 1}
```

This is because:

* The problem expects **1-based indexing**, not 0-based
* So I adjusted both indices accordingly 📌

---

## ❌ What Happens If No Pair Exists?

If no two numbers add up to the target:

```java
return new int[] {};
```

This safely handles the edge case 👍

---

## ✅ Why This Approach Is Efficient

✔ Only one pass through the array
✔ No nested loops
✔ Fast lookups using HashMap
✔ Clean and readable logic ✨

---

## ⏱ Time Complexity

### **O(n)**

* Each element is processed once
* HashMap lookups are O(1) on average

---

## 💾 Space Complexity

### **O(n)**

* In the worst case, all elements are stored in the HashMap

---

## 🌟 Summary

✔ I avoided brute force
✔ Used a HashMap to track seen values
✔ Found the answer in a single pass
✔ Returned indices using 1-based indexing

This approach helped me solve the problem **efficiently and optimally** 🚀
