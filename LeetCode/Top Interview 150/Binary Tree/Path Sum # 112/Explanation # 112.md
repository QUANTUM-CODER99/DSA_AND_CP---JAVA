## 🌳 Path Sum in a Binary Tree (My Approach)

### 🔹 Core Idea Behind My Approach

When I approached this problem, the main idea in my mind was:

> *I need to check if there exists **at least one root-to-leaf path** such that the sum of node values along that path equals the given `targetSum`.*

So at every node, I:

* Subtract the node’s value from `targetSum`
* Pass the remaining sum down the tree
* Only check for equality **when I reach a leaf node** 🍃

This naturally led me to use **recursion**, because each subtree represents a smaller version of the same problem.

---

## 🔁 How the Recursive Logic Works

### 🧠 Base Case: Empty Node

```java
if (root == null)
    return false;
```

If I reach a `null` node:

* There’s no valid path here
* I return `false`

---

### 🍃 Leaf Node Check

```java
if (targetSum - root.val == 0 && 
    (root.left == null && root.right == null))
    return true;
```

At a leaf node:

* I subtract the current node value
* If the remaining sum becomes `0`
* And I’m at a leaf 🍃

Then I’ve found a **valid root-to-leaf path** ✅

---

### 🔁 Recursive Step

```java
targetSum -= root.val;
return hasPathSum(root.left, targetSum) 
    || hasPathSum(root.right, targetSum);
```

If I’m not at a leaf:

* I reduce `targetSum` by the current node’s value
* Recursively check **either subtree**
* If **any path** returns `true`, the answer is `true`

---

## 📌 Example Walkthrough

### Example Tree

```
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \       \
  7    2       1
```

### Target Sum = `22`

### Path Being Checked

```
5 → 4 → 11 → 2
```

---

## 📊 Recursive Sum Table

| Node | Node Value | Remaining Sum |
| ---- | ---------- | ------------- |
| 5    | 5          | 22 → 17       |
| 4    | 4          | 17 → 13       |
| 11   | 11         | 13 → 2        |
| 2    | 2          | 2 → 0 ✅       |

At node `2`, I reach a leaf and the remaining sum becomes `0`, so I return `true` 🎉

---

## 🧩 Why This Approach Works Well

✔ Checks only **root-to-leaf** paths
✔ Stops early when a valid path is found 🚦
✔ Clean recursive structure
✔ No extra data structures needed

---

## ⏱️ Time & Space Complexity

### ⏱️ Time Complexity

**O(n)**

* In the worst case, I may visit every node once
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

* Passing the remaining sum down the tree ➕
* Only validating the sum at leaf nodes 🍃
* Using recursion to naturally explore all paths 🌳

This approach is **simple, efficient, and very intuitive** for path-based tree problems 🚀
