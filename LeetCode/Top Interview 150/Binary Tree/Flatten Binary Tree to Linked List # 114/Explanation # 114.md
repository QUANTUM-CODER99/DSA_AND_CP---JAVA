## 🌳 Flatten Binary Tree to Linked List (My Approach)

### 🔹 Core Idea Behind My Approach

When I approached this problem, the main thought in my mind was:

> *The flattened tree should follow **preorder traversal** (root → left → right) and look like a linked list using only right pointers.*

So instead of trying to rearrange pointers on the fly (which can get tricky), I decided to:

1. **Traverse the tree in preorder**
2. **Store all nodes in a list**
3. **Reconnect the nodes sequentially** to form the flattened structure

This makes the solution **clear, predictable, and easy to reason about** 😊

---

## 🔁 Step 1: Preorder Traversal

```java
private void preorder(TreeNode root, List<TreeNode> nodes)
```

In preorder traversal:

1. I visit the current node
2. Then the left subtree
3. Then the right subtree

```java
nodes.add(root);
preorder(root.left, nodes);
preorder(root.right, nodes);
```

This ensures the nodes are stored **exactly in the order** required for the final linked list ➡️

---

## 🔗 Step 2: Rewiring the Tree

After collecting all nodes in a list:

```java
for (int i = 0; i < nodes.size() - 1; i++) {
    nodes.get(i).left = null;
    nodes.get(i).right = nodes.get(i + 1);
}
```

For every node:

* I set `left = null` ❌
* I connect `right` to the next node in preorder order ➡️

This transforms the tree into a **right-skewed linked list**.

---

## 📌 Example Walkthrough

### Original Tree

```
        1
       / \
      2   5
     / \   \
    3   4   6
```

### Preorder Traversal Order

```
[1, 2, 3, 4, 5, 6]
```

---

## 📊 Pointer Rewiring Table

| Current Node | Left Pointer | Right Pointer |
| ------------ | ------------ | ------------- |
| 1            | null         | 2             |
| 2            | null         | 3             |
| 3            | null         | 4             |
| 4            | null         | 5             |
| 5            | null         | 6             |
| 6            | null         | null          |

### Final Flattened Tree

```
1 → 2 → 3 → 4 → 5 → 6
```

All nodes are connected using only `right` pointers, just like a linked list 🔗

---

## 🧩 Why I Chose This Approach

✔ Very easy to understand and implement
✔ Avoids complex pointer manipulation
✔ Preorder traversal guarantees correct order
✔ Great for learning and clarity

---

## ⏱️ Time & Space Complexity

### ⏱️ Time Complexity

**O(n)**

* Preorder traversal visits each node once
* Rewiring also takes linear time

### 🧠 Space Complexity

**O(n)**

* Extra list used to store all nodes
* Recursion stack also contributes in worst case

---

## 🌟 Final Thoughts

While solving this problem, my focus was on:

* Separating **traversal logic** from **restructuring logic**
* Using preorder traversal to preserve the required order 🌳
* Keeping the solution simple and readable

This approach may not be the most space-optimized, but it is **clean, intuitive, and perfect for explaining the idea clearly** 🚀
