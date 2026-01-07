## 🧠 My Core Idea While Solving This Problem

When I approached the **H-Index** problem, my main thought was:

> *The H-Index is all about counting how many papers have at least **h citations**.*

### 💡 Key Insight

* If the citations are **sorted**, then at index `i`:

  * There are exactly **`n - i` papers** with citations ≥ `citations[i]`
* So I just need to find the **first index** where:

```text
citations[i] ≥ number of papers to its right (including itself)
```

That value (`n - i`) is my **H-Index** 🎯.

---

## 🔍 Explanation of the Code

```java
Arrays.sort(citations);
```

* I sort the citations in **ascending order**.
* This allows me to reason about how many papers have **at least a certain number of citations**.

```java
for (int i = 0; i < citations.length; i++)
```

* I iterate from the **lowest citation count** to the highest.

```java
if (citations[i] >= citations.length - i)
```

* At index `i`:

  * `citations[i]` → citations of the current paper
  * `citations.length - i` → number of papers with citations ≥ `citations[i]`
* If this condition is satisfied, I’ve found a valid **H-Index**.

```java
return citations.length - i;
```

* I return the **maximum possible h** immediately.

```java
return 0;
```

* If no such condition is met, then the H-Index is `0`.

---

## 📊 Example Walkthrough (Tabular Method)

### Example 1

**Input:**

```text
citations = [3, 0, 6, 1, 5]
```

### After Sorting

```text
[0, 1, 3, 5, 6]
```

| Index (i) | citations[i] | Papers ≥ citations[i] (`n - i`) | Condition Met? |
| --------- | ------------ | ------------------------------- | -------------- |
| 0         | 0            | 5                               | ❌ 0 < 5        |
| 1         | 1            | 4                               | ❌ 1 < 4        |
| 2         | 3            | 3                               | ✅ 3 ≥ 3        |

✔️ **H-Index = 3**

---

### Example 2

**Input:**

```text
citations = [1, 3, 1]
```

### After Sorting

```text
[1, 1, 3]
```

| Index (i) | citations[i] | n - i | Condition |
| --------- | ------------ | ----- | --------- |
| 0         | 1            | 3     | ❌         |
| 1         | 1            | 2     | ❌         |
| 2         | 3            | 1     | ✅         |

✔️ **H-Index = 1**

---

## ⏱️ Time & Space Complexity

### 🕒 Time Complexity

* Sorting the array: **O(n log n)**
* Single pass after sorting: **O(n)**
* **Overall:** `O(n log n)`

### 💾 Space Complexity

* Sorting is done in place (for most Java implementations).
* **O(1)** extra space (ignoring sort internals).

---

## 🎯 Why This Approach Works Well

* Sorting simplifies the problem 📈
* Each index directly maps to a **potential H-Index**
* Early return ensures efficiency 🚀
* Clean and easy to reason about 🧠✨

---

## 🚀 Final Takeaway

> *Once the citations are sorted,
> I only need to check where the citation count
> is greater than or equal to the number of papers remaining.*

That’s exactly where the **H-Index** lives 😄📊🔥
