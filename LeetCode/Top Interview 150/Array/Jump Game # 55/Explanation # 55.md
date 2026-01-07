## 🧠 My Thought Process / Core Idea

When I approached this problem, my **main idea** was:

> *Instead of checking all possible jumps forward (which can get complicated), I decided to work **backwards** and see if I can reach the start.*

### 💡 Key Insight

* The **last index** is always my **initial goal** 🎯.
* If I can find an index from where I can **jump to the goal**, then that index becomes my **new goal**.
* I keep moving this goal **backwards**.
* If I can finally move the goal all the way back to index `0`, then the jump is possible ✅.

This greedy approach helps me avoid unnecessary checks and keeps the solution simple and efficient.

---

## 🔍 How the Code Works

```java
int goal = nums.length - 1;
```

* I start by assuming that my destination (goal) is the **last index**.

```java
for (int i = nums.length - 2; i >= 0; i--)
```

* I iterate **backwards**, starting from the second-last index.

```java
if (nums[i] + i >= goal)
    goal = i;
```

* If from index `i` I can **reach or cross the current goal**,
  then index `i` becomes my **new goal**.

```java
return goal == 0;
```

* If I can push the goal all the way back to index `0`,
  then I can reach the end from the start 🚀.

---

## 📊 Example Walkthrough (with Table)

### Example 1

**Input:**

```text
nums = [2, 3, 1, 1, 4]
```

### Step-by-step reasoning:

| Index (i) | nums[i] | nums[i] + i | Current Goal | Can Reach Goal? | New Goal |
| --------- | ------- | ----------- | ------------ | --------------- | -------- |
| 4         | 4       | —           | 4            | —               | 4        |
| 3         | 1       | 4           | 4            | ✅ Yes           | 3        |
| 2         | 1       | 3           | 3            | ✅ Yes           | 2        |
| 1         | 3       | 4           | 2            | ✅ Yes           | 1        |
| 0         | 2       | 2           | 1            | ✅ Yes           | 0        |

✔️ Final goal reaches index `0` → **Return `true`**

---

### Example 2

**Input:**

```text
nums = [3, 2, 1, 0, 4]
```

| Index (i) | nums[i] | nums[i] + i | Current Goal | Can Reach Goal? |
| --------- | ------- | ----------- | ------------ | --------------- |
| 4         | 4       | —           | 4            | —               |
| 3         | 0       | 3           | 4            | ❌ No            |
| 2         | 1       | 3           | 4            | ❌ No            |
| 1         | 2       | 3           | 4            | ❌ No            |
| 0         | 3       | 3           | 4            | ❌ No            |

❌ Goal never reaches index `0` → **Return `false`**

---

## ⏱️ Time & Space Complexity

### 🕒 Time Complexity

* I loop through the array **once**.
* **Time Complexity:** `O(n)`

### 💾 Space Complexity

* I only use a single variable (`goal`).
* **Space Complexity:** `O(1)`

---

## 🎯 Why This Approach is Efficient

* No recursion ❌
* No extra arrays ❌
* Just a single backward pass ✔️
* Clean greedy logic 🧠✨

---

## 🚀 Final Takeaway

> *I don’t try to jump forward blindly.
> Instead, I ask myself:
> “From which positions can I **reach the end**?”
> If I can move that reachability all the way back to index `0`, the answer is true.*
