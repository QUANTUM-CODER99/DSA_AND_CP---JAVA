🧠 My Core Idea While Solving This Problem

When I approached **Jump Game II**, my main realization was:

> *I don’t need to track the exact path — I just need to know the **minimum number of jumps** required to reach the last index.*

### 💡 Key Insight

* At every position, I want to know:

  * **How far can I reach with the current jump?**
  * **What is the farthest position I can reach if I take one more jump?**
* I treat the array like **levels in BFS**, where:

  * Each jump expands my reachable range.
  * When I finish exploring the current range, I **must take a jump**.

This leads to a **greedy approach** where I always choose the jump that gives me the **maximum reach** 🚀.

---

## 🔍 Explanation of Variables

```java
int jumps = 0;
```

➡️ Counts the **minimum number of jumps** needed.

```java
int longestJump = 0;
```

➡️ Stores the **farthest index** I can reach so far.

```java
int currentIndex = 0;
```

➡️ Represents the **end of the current jump range**.

---

## 🔄 How the Loop Works

```java
for (int i = 0; i < nums.length - 1; i++)
```

* I loop until the **second last index**, because once I reach or cross the last index, I’m done.

```java
longestJump = Math.max(longestJump, i + nums[i]);
```

* At each index, I calculate the **farthest position** I can reach.
* I always keep the **maximum reach** possible.

```java
if (i == currentIndex)
```

* This condition means:

  > *I have reached the end of my current jump range.*

```java
jumps++;
currentIndex = longestJump;
```

* I **take a jump** 🚀.
* I update my range to the farthest position I can now reach.

```java
if (currentIndex >= nums.length - 1)
    break;
```

* If I can already reach the last index, I stop early ✅.

---

## 📊 Example Walkthrough (Tabular Method)

### Example

**Input:**

```text
nums = [2, 3, 1, 1, 4]
```

### Step-by-step Execution

| i | nums[i] | i + nums[i] | longestJump | currentIndex | jumps | Action                   |
| - | ------- | ----------- | ----------- | ------------ | ----- | ------------------------ |
| 0 | 2       | 2           | 2           | 0            | 0     | i == currentIndex → jump |
|   |         |             |             | 2            | 1     | range updated            |
| 1 | 3       | 4           | 4           | 2            | 1     | expand range             |
| 2 | 1       | 3           | 4           | 2            | 1     | i == currentIndex → jump |
|   |         |             |             | 4            | 2     | reach end                |

✔️ **Answer:** `2` jumps
👉 Path: `0 → 1 → 4`

---

## 🧩 Why This Greedy Strategy Works

* I always **delay the jump** until I’ve explored the entire current range.
* When I jump, I choose the option that gives me the **maximum future reach**.
* This guarantees the **minimum number of jumps** 🧠✨.

---

## ⏱️ Time & Space Complexity

### 🕒 Time Complexity

* Single pass through the array.
* **O(n)**

### 💾 Space Complexity

* Only constant extra variables used.
* **O(1)**

---

## 🎯 Final Takeaway

> *I treat the array like a set of expanding ranges.
> Each jump extends my reach as far as possible,
> and I only jump when I must.*

This greedy + level-based thinking keeps the solution **fast, clean, and optimal** 🚀🔥
