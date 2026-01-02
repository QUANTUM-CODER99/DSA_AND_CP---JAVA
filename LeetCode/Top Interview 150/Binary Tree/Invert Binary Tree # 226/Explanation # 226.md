## 🌳 Inverting a Binary Tree (My Thought Process)

### 🔹 Core Idea Behind My Approach

When I approached this problem, the main idea in my mind was:

> *To invert a binary tree, I just need to swap the left and right child of **every node**.*

Since:

* A binary tree is made of smaller subtrees 🌱
* The same swap operation applies at every node

Recursion felt like the most natural and clean solution here.

---

## 🔁 How the Recursive Solution Works

### 🧠 Base Case

```java
if (root == null) {
    return null;
}
```

If the current node is `null`, there’s nothing to invert — so I simply return `null`.

---

### 🔄 Swap Left and Right Children

```java
TreeNode temp = root.left;
root.left = root.right;
root.right = temp;
```

At the current node:

* I store the left child in a temporary variable
* Swap the left and right pointers 🔁

This handles the inversion **locally** at the current node.

---

### 🔁 Recursive Calls

```java
invertTree(root.left);
invertTree(root.right);
```

After swapping:

* I recursively invert the left subtree
* I recursively invert the right subtree

This ensures the entire tree gets inverted from top to bottom 🌳

---

### 🏁 Final Return

```java
return root;
```

I return the root of the inverted tree.

---

## 📌 Example Walkthrough

### Original Tree

```
        4
       / \
      2   7
     / \ / \
    1  3 6  9
```

### Inverted Tree

```
        4
       / \
      7   2
     / \ / \
    9  6 3  1
```

---

## 📊 Step-by-Step Swap Table

| Current Node | Left Child (Before) | Right Child (Before) | Left Child (After) | Right Child (After) |
| ------------ | ------------------- | -------------------- | ------------------ | ------------------- |
| 4            | 2                   | 7                    | 7                  | 2                   |
| 2            | 1                   | 3                    | 3                  | 1                   |
| 7            | 6                   | 9                    | 9                  | 6                   |

Each node performs the **same swap operation**, which is why recursion works so well here 😊

---

## 🧩 Why This Approach Is Effective

✔ Directly mirrors the definition of tree inversion
✔ Simple and readable logic
✔ Uses recursion to handle subtrees naturally
✔ No extra data structures needed

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

* Performing a simple swap at each node 🔄
* Letting recursion take care of traversing the tree 🌳
* Keeping the solution clean and intuitive

This recursive approach makes tree inversion both **efficient and elegant** 🚀
