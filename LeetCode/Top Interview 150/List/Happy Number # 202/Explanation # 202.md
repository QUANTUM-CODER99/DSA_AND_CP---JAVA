### **1. My core idea behind this approach**

When I think about checking if a number is a **happy number**, the core idea in my mind is:

> *A happy number is a number that eventually reaches 1 when we repeatedly replace it with the sum of the squares of its digits. If it never reaches 1, it will eventually get stuck in a cycle.*

So, my approach here is:

1. Take the number `n`.
2. Compute the sum of squares of its digits.
3. Replace `n` with this sum.
4. Keep track of numbers I have seen in a list.
5. If I reach `1`, return `true`.
6. If I see a number repeated (cycle detected), return `false`.

Basically, I am **simulating the process** and using a `List` to **detect cycles**.

---

### **2. Step-by-step example with a table**

Let’s take an example:

```java
n = 19
```

---

**Step 1: Initialize**

* `val = []`
* `n = 19`

---

**Step 2: Compute sum of squares of digits**

| Iteration | n   | Digits | Sum of squares | New n | val (seen numbers) | Check                      |
| --------- | --- | ------ | -------------- | ----- | ------------------ | -------------------------- |
| 1         | 19  | 1,9    | 1² + 9² = 82   | 82    | []                 | Not 1, not in val → add 19 |
| 2         | 82  | 8,2    | 8² + 2² = 68   | 68    | [19]               | Not 1, not in val → add 82 |
| 3         | 68  | 6,8    | 6² + 8² = 100  | 100   | [19,82]            | Not 1, not in val → add 68 |
| 4         | 100 | 1,0,0  | 1²+0²+0² = 1   | 1     | [19,82,68]         | n==1 → return true         |

✅ The number 19 is happy.

---

**Step 3: Detect cycles**

If a number repeats in `val`, that means we are in a loop, e.g.,

```java
n = 2
```

* Sequence: 2 → 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
* `4` appears again → cycle detected → return `false`

---

### **3. Time and Space Complexity**

**Time Complexity:**

1. Each step reduces the number to the sum of squares of digits.
2. The maximum sum for any number ≤ 32-bit integer is limited (e.g., 9² * 10 = 810 for 10-digit numbers).
3. So, we eventually either reach 1 or a cycle → the loop is limited by a constant number of possibilities.

* In terms of digits `d` of `n`, each sum computation is `O(d)`
* But since the number of unique sums is limited, **time complexity is effectively O(1)** (bounded by constant max sum cycle).

**Space Complexity:**

* We store all visited numbers in `val` → in the worst case, at most **one number per unique sum**, which is bounded → O(1) space.
* If we want an exact upper bound, it's ≤ 243 (since max sum for 3-digit numbers is 243).

> ⚠️ Note: Using a `List` and `contains()` actually makes each lookup O(n), so technically **O(k²)** where `k` is number of steps, but in practice `k` is small.

---

### **4. My mental summary**

* **Idea:** Keep replacing number with sum of squares → track numbers → check for 1 or cycles.
* **Example:** 19 → 82 → 68 → 100 → 1 → happy
* **Cycle detection:** Store seen numbers → if repeated, not happy
* **Complexity:**

  * Time: O(1) (bounded by max possible sums)
  * Space: O(1) (bounded by number of unique sums)

---
