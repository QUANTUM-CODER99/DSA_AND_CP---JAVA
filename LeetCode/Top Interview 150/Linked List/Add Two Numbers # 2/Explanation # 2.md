### 🧠 My Thought Process (Core Idea)

When I approached this problem, my **core idea** was:

> “I need to add two numbers represented as **linked lists**, where each node contains a single digit. The digits are stored in **reverse order**, so the 1’s place comes first. I want to traverse both lists simultaneously, sum their values along with any carry from the previous step, and construct a new linked list to store the result.”

Basically, I treated it like **element-wise addition** we do by hand 🖊️, starting from the least significant digit and moving to the most significant one, carrying over extra digits when necessary.

---

### 🔍 Step-by-Step with Example

Let’s say I have two linked lists:

```
l1: 2 -> 4 -> 3   (represents 342)
l2: 5 -> 6 -> 4   (represents 465)
```

I want to get a new linked list representing `342 + 465 = 807`, so the result should be:

```
7 -> 0 -> 8
```

---

### 📝 Tabular Addition

| Step | l1.val | l2.val | Carry | Sum | Node Value | New Carry |
| ---- | ------ | ------ | ----- | --- | ---------- | --------- |
| 1    | 2      | 5      | 0     | 7   | 7          | 0         |
| 2    | 4      | 6      | 0     | 10  | 0          | 1         |
| 3    | 3      | 4      | 1     | 8   | 8          | 0         |

✅ After all steps, I attach nodes `7 -> 0 -> 8` to the dummy head and return it.

---

### 💡 How the Code Works

1. I create a **dummy head** node (`dummyHead`) to simplify edge cases like empty lists.
2. I use `currNode` to keep track of the last node in the result list.
3. I keep a `carry` variable to store any value > 10 during addition.
4. I loop **while any list still has nodes OR carry is non-zero**, and at each step:

   * Add the values from `l1` and `l2` (if present) and the `carry`.
   * Create a new node with `sum % 10` (the digit for this place).
   * Update `carry = sum / 10` for the next iteration.
5. At the end, `dummyHead.next` points to my final summed list.

---

### ⏱ Time and Space Complexity

* **Time Complexity:** `O(max(m, n))`

  * I traverse both lists once. Here `m` and `n` are lengths of `l1` and `l2`.

* **Space Complexity:** `O(max(m, n))`

  * I create a new linked list to store the result, which in the worst case has length `max(m, n) + 1` (if there’s a final carry).

---

### ✨ Summary

* I thought like **manual addition with carry**.
* I used a **dummy node** to simplify list building.
* I iterated until **both lists are done and no carry remains**.
* Works for any length of numbers and automatically handles **carry overs**.

🚀 Very clean and easy to understand, and it’s exactly how I would do addition on paper.
