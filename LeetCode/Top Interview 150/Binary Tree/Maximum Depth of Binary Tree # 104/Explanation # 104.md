## 🌳 Understanding `maxDepth` of a Binary Tree (My Approach)

### 🔹 Core Idea Behind My Approach

When I approached this problem, my **core idea** was simple:

> *The depth of a binary tree is determined by the longest path from the root to any leaf.*

So naturally, I thought:

* If I know the **maximum depth of the left subtree**
* And the **maximum depth of the right subtree**
* Then the depth of the current node is just
  **`1 + max(leftDepth, rightDepth)`**

This immediately pointed me toward **recursion**, because:

* A tree is made of smaller trees 🌲
* The same logic applies to every node

That’s why I used a **recursive Depth-First Search (DFS)** approach.

---

## 🔁 How the Recursion Works

### 🧠 Base Case

```java
if (root == null)
    return 0;
```

If the node is `null`, it means I’ve gone past a leaf — so the depth is `0`.

### 🔁 Recursive Case

```java
int leftHeight = maxDepth(root.left);
int rightHeight = maxDepth(root.right);
```

I recursively calculate:

* The depth of the **left subtree**
* The depth of the **right subtree**

### 🏁 Final Step

```java
return Math.max(leftHeight, rightHeight) + 1;
```

I take the **maximum** of the two and add `1` for the current node 🧩

---

## 📌 Example Walkthrough

### Example Tree

```
        1
       / \
      2   3
     /
    4
```

### Step-by-Step Depth Calculation

| Node | Left Depth | Right Depth | Max + 1 | Returned Depth |
| ---- | ---------- | ----------- | ------- | -------------- |
| 4    | 0          | 0           | 1       | 1              |
| 2    | 1          | 0           | 2       | 2              |
| 3    | 0          | 0           | 1       | 1              |
| 1    | 2          | 1           | 3       | 3              |

✅ **Final Answer:** `3`

This matches the longest path: `1 → 2 → 4`

---

## 🧩 Why This Approach Works Well

✔ Clean and intuitive
✔ Uses the natural recursive structure of trees
✔ No extra data structures needed
✔ Easy to reason about and debug

---

## ⏱️ Time & Space Complexity

### ⏱️ Time Complexity

**O(n)**

* Every node is visited **once**

### 🧠 Space Complexity

**O(h)**

* Due to the recursion stack
* `h` = height of the tree

  * Best case (balanced tree): `O(log n)`
  * Worst case (skewed tree): `O(n)`

---

## 🌟 Final Thoughts

While solving this problem, I focused on:

* Breaking the tree into smaller subtrees 🌱
* Solving the same problem recursively
* Building the answer back up from the leaf nodes

This recursive DFS approach feels **natural, efficient, and elegant** for tree problems 🚀
