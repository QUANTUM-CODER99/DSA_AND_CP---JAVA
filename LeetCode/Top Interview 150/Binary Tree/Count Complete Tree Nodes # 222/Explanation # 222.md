## 🌳 Counting Nodes in a Binary Tree (My Approach)

### 🔹 Core Idea Behind My Approach

When I approached this problem, my thinking was very straightforward:

> *The total number of nodes in a binary tree is equal to the number of nodes in the left subtree + the number of nodes in the right subtree + 1 (for the current node).*

Since:

* A binary tree is made up of smaller subtrees 🌱
* The same logic applies at every node

Recursion felt like the most natural and clean solution.

---

## 🔁 How the Recursive Logic Works

### 🧠 Base Case

```java
if (root == null)
    return 0;
```

If the current node is `null`, it means:

* There are no nodes here
* So I return `0`

---

### 🔁 Recursive Case

```java
return countNodes(root.left) 
     + countNodes(root.right) 
     + 1;
```

At each node:

* I recursively count nodes in the left subtree 🌿
* I recursively count nodes in the right subtree 🌿
* I add `1` for the current node itself

This builds the total count bottom-up.

---

## 📌 Example Walkthrough

### Example Tree

```
        1
       / \
      2   3
     / \
    4   5
```

---

## 📊 Step-by-Step Counting Table

| Node | Left Subtree Count | Right Subtree Count | +1 (Current Node) | Total Returned |
| ---- | ------------------ | ------------------- | ----------------- | -------------- |
| 4    | 0                  | 0                   | 1                 | 1              |
| 5    | 0                  | 0                   | 1                 | 1              |
| 2    | 1                  | 1                   | 1                 | 3              |
| 3    | 0                  | 0                   | 1                 | 1              |
| 1    | 3                  | 1                   | 1                 | 5              |

✅ **Final Output:** `5`

---

## 🧩 Why This Approach Works Well

✔ Extremely simple and intuitive
✔ Leverages the recursive structure of trees 🌳
✔ No extra data structures needed
✔ Easy to implement and explain

---

## ⏱️ Time & Space Complexity

### ⏱️ Time Complexity

**O(n)**

* Every node is visited exactly once
* `n` = number of nodes in the tree

### 🧠 Space Complexity

**O(h)**

* Due to recursion stack
* `h` = height of the tree

  * Balanced tree → `O(log n)`
  * Skewed tree → `O(n)`

---

## 🌟 Final Thoughts

While solving this problem, my focus was on:

* Applying the most basic property of trees 🌱
* Breaking the problem into smaller subproblems
* Letting recursion naturally combine the results

This solution is **clean, efficient, and perfectly fits the recursive nature of binary trees** 🚀
