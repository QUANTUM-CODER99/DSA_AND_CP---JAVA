### **1. My Core Idea While Writing This Code**

When I wrote this solution, my main thought process was:

> “I want to check if any number in the array repeats within a distance of `k`. If I remember the last position where I saw each number, I can quickly check if the new occurrence is close enough.”

So, the steps in my mind were:

1. I need a way to **remember the last index** where each number appeared.
2. A `HashMap` is perfect because it lets me **store the number as key** and **its last index as value**.
3. As I traverse the array, for each number:

   * If it exists in my map already, I check the distance: `current_index - last_index <= k`.
   * If it satisfies the condition, I **return true** immediately.
   * If not, or if it’s the first time seeing the number, I **update the map** with the current index.
4. If I finish the loop without finding any duplicates within `k`, I **return false**.

Essentially, I’m trading some **extra space** to save **time**, making it O(n) instead of using a nested loop O(n²).

---

### **2. Example with Table**

Let’s take an example:

```java
nums = [1, 2, 3, 1, 4, 2], k = 3
```

Now, I’ll go step by step and maintain the map:

| i (index) | nums[i] | Map before operation  | Condition checked? | Map after operation   | Return? |
| --------- | ------- | --------------------- | ------------------ | --------------------- | ------- |
| 0         | 1       | {}                    | No                 | {1 → 0}               | false   |
| 1         | 2       | {1 → 0}               | No                 | {1 → 0, 2 → 1}        | false   |
| 2         | 3       | {1 → 0, 2 → 1}        | No                 | {1 → 0, 2 → 1, 3 → 2} | false   |
| 3         | 1       | {1 → 0, 2 → 1, 3 → 2} | 3 - 0 = 3 ≤ k ✅    | {1 → 3, 2 → 1, 3 → 2} | true    |

At `i = 3`, I found `1` again and the distance is `3`, which is ≤ k. So I return **true**.

If no match had been found in the loop, I would have returned **false**.

---

### **3. Time and Space Complexity**

**Time Complexity:**

* I traverse the array **once**, so O(n).
* For each number, `HashMap` operations (`containsKey` and `put`) are O(1) on average.

✅ So total **Time Complexity = O(n)**

**Space Complexity:**

* I store each unique number in the `HashMap`.
* In the worst case, all numbers are unique, so I store **n entries**.

✅ So **Space Complexity = O(n)**

---

### ✅ **Summary**

* I used a **HashMap to track last seen indices**.
* I check **if the current number appeared within k indices**.
* I update the map with the **current index** each time.
* Time Complexity = O(n), Space Complexity = O(n).
* This is much faster than checking every pair (O(n²)).

---
