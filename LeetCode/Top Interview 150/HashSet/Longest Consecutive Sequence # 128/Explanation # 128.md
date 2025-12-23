### **1. My Core Idea While Writing This Code**

When I approached this problem, my main thought was:

> “I need to find the longest sequence of consecutive numbers in an array, but the numbers may not be sorted. Sorting would take O(n log n), but maybe I can do it in O(n) using a HashSet.”

Here’s my thought process step by step:

1. I know **checking existence** in a set is O(1), so a `HashSet` will help me quickly see if a number exists.
2. I insert **all numbers** into a `HashSet` so I can check any number’s presence efficiently.
3. For each number `n`, I only want to **start counting a sequence if `n` is the first number** in that sequence. That means `n-1` should not exist in the set.
4. Once I find a start of a sequence, I **count forward** (`n+1`, `n+2`, ...) until numbers stop being consecutive.
5. I keep track of the **maximum length** seen so far.
6. Finally, I return that maximum length.

Essentially, I avoid redundant work by **only starting sequences at the smallest number of each sequence**, which keeps it O(n).

---

### **2. Example with Table**

Let’s take an example:

```java
nums = [100, 4, 200, 1, 3, 2]
```

**Step 1: Put all numbers in a HashSet**

```
numSet = {1, 2, 3, 4, 100, 200}
```

**Step 2: Iterate through the set**

| n (current number) | numSet.contains(n-1)? | Start counting? | Counted sequence length | maxCount after this step |
| ------------------ | --------------------- | --------------- | ----------------------- | ------------------------ |
| 1                  | false                 | yes             | 1 → 2 → 3 → 4 = 4       | 4                        |
| 2                  | true                  | no              | skipped                 | 4                        |
| 3                  | true                  | no              | skipped                 | 4                        |
| 4                  | true                  | no              | skipped                 | 4                        |
| 100                | false                 | yes             | 1                       | 4                        |
| 200                | false                 | yes             | 1                       | 4                        |

* I only start counting from **1, 100, 200** because all other numbers have `n-1` in the set.
* Maximum consecutive sequence = **4** (`1, 2, 3, 4`).

---

### **3. Time and Space Complexity**

**Time Complexity:**

* Creating the set: O(n)
* Iterating through the set: O(n)

  * Why O(n) and not O(n²)? Because each number is **visited at most once** in the inner while loop.
    ✅ So total **Time Complexity = O(n)**

**Space Complexity:**

* I store all numbers in a HashSet: O(n)
  ✅ So **Space Complexity = O(n)**

---

### ✅ **Summary**

* I used a **HashSet** to quickly check for existence.
* I only start counting sequences from the **smallest number** in each sequence.
* I keep track of the **maximum sequence length**.
* Time Complexity = O(n), Space Complexity = O(n).

---
