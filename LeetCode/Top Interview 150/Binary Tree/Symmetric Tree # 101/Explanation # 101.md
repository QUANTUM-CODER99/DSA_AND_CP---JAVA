## 🌳 Checking if a Binary Tree Is Symmetric (My Approach)

### 🔹 Core Idea Behind My Approach

When I tackled this problem, the key idea in my mind was:

> *A binary tree is symmetric if its left and right subtrees are mirror images of each other.*

Instead of comparing the tree with itself, I:

* Split the problem into comparing **two subtrees**
* Checked whether the **left subtree is a mirror** of the **right subtree** 🪞

This led me to use a **helper recursive function** (`isMirror`) that compares nodes in a mirrored fashion.

---

## 🔁 How the Recursive Mirror Check Works

### 🧠 Case 1: Both Nodes Are `null`

```java
if (leftTreeNode == null && rightTreeNode == null)
    return true;
```

If both nodes are `null`, it means:

* The structure matches perfectly at this level
* Symmetry is preserved ✅

---

### 🧠 Case 2: One Node Is `null`

```java
if (leftTreeNode == null || rightTreeNode == null)
    return false;
```

If only one node exists:

* The structure breaks
* The tree cannot be symmetric ❌

---

### 🧠 Case 3: Both Nodes Exist

```java
return leftTreeNode.val == rightTreeNode.val
    && isMirror(leftTreeNode.left, rightTreeNode.right)
    && isMirror(leftTreeNode.right, rightTreeNode.left);
```

Here I check **three things**:

1. Values at both nodes are equal
2. Left child of the left subtree mirrors the right child of the right subtree
3. Right child of the left subtree mirrors the left child of the right subtree

All three must be true for symmetry to hold.

---

## 📌 Example Walkthrough

### Example 1: Symmetric Tree ✅

```
        1
       / \
      2   2
     / \ / \
    3  4 4  3
```

### Mirror Comparison Table

| Left Node | Right Node | Value Match | Mirror Children Compared | Result |
| --------- | ---------- | ----------- | ------------------------ | ------ |
| 2         | 2          | ✅           | (3 ↔ 3), (4 ↔ 4)         | ✅      |
| 3         | 3          | ✅           | null ↔ null              | ✅      |
| 4         | 4          | ✅           | null ↔ null              | ✅      |

✅ **Final Output:** `true`

---

### Example 2: Non-Symmetric Tree ❌

```
        1
       / \
      2   2
       \    \
        3    3
```

| Comparison              | Observation | Result |
| ----------------------- | ----------- | ------ |
| left.right ↔ right.left | null ↔ 3    | ❌      |

❌ **Final Output:** `false`

---

## 🧩 Why This Approach Works Well

✔ Directly checks the mirror condition
✔ Clean separation using a helper method
✔ Recursion naturally handles tree structure 🌳
✔ Easy to reason about and implement

---

## ⏱️ Time & Space Complexity

### ⏱️ Time Complexity

**O(n)**

* Each node is compared once
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

* Thinking in terms of **mirror images** 🪞
* Comparing opposite children instead of the same-side children
* Using recursion to simplify repeated checks

This approach keeps the solution **intuitive, elegant, and efficient** 🚀
