## 🌳 Checking if Two Binary Trees Are the Same (My Approach)

### 🔹 Core Idea Behind My Approach

When I looked at this problem, my main thought was:

> *Two binary trees are the same if they have the same structure **and** the same values at every corresponding node.*

So for every pair of nodes `p` and `q`, I needed to check **three things**:

1. Are both nodes `null`?
2. Are both nodes non-null and their values equal?
3. Are their left subtrees the same **and** their right subtrees the same?

This naturally led me to use **recursion**, because:

* Each tree is made up of smaller subtrees 🌱
* The same comparison logic applies at every node

---

## 🔁 How the Recursive Logic Works

### 🧠 Case 1: Both Nodes Are `null`

```java
if (p == null && q == null)
    return true;
```

If both nodes are `null`, it means:

* I’ve reached the end of both trees at the same time
* Structurally and logically, they are identical here ✅

---

### 🧠 Case 2: Both Nodes Exist and Values Match

```java
if (p != null && q != null && p.val == q.val)
    return isSameTree(p.left, q.left) 
        && isSameTree(p.right, q.right);
```

Here I check:

* Both nodes exist
* Their values are equal

If that’s true, I **recursively compare**:

* Their left children 🌿
* Their right children 🌿

Both sides must return `true` for the trees to be the same.

---

### 🧠 Case 3: Any Other Situation

```java
return false;
```

If:

* One node is `null` and the other isn’t ❌
* Or the values don’t match ❌

Then the trees are **not the same**.

---

## 📌 Example Walkthrough

### Example 1: Same Trees ✅

```
Tree p:        Tree q:
    1              1
   / \            / \
  2   3          2   3
```

### Recursive Comparison Table

| Node p | Node q | Value Match | Left Same | Right Same | Result |
| ------ | ------ | ----------- | --------- | ---------- | ------ |
| 1      | 1      | ✅           | ✅         | ✅          | ✅      |
| 2      | 2      | ✅           | ✅         | ✅          | ✅      |
| 3      | 3      | ✅           | ✅         | ✅          | ✅      |

✅ **Final Output:** `true`

---

### Example 2: Different Trees ❌

```
Tree p:        Tree q:
    1              1
   /                \
  2                  2
```

| Node p | Node q | Issue              | Result |
| ------ | ------ | ------------------ | ------ |
| left   | right  | Structure mismatch | ❌      |

❌ **Final Output:** `false`

---

## 🧩 Why This Approach Is Effective

✔ Matches the recursive nature of trees
✔ Simple and clean logic
✔ Checks both **structure** and **values**
✔ No extra data structures needed

---

## ⏱️ Time & Space Complexity

### ⏱️ Time Complexity

**O(n)**

* Every node in both trees is visited once
* `n` = number of nodes (up to the smaller tree)

### 🧠 Space Complexity

**O(h)**

* Due to recursion stack
* `h` = height of the tree

  * Balanced tree: `O(log n)`
  * Skewed tree: `O(n)`

---

## 🌟 Final Thoughts

While solving this problem, I focused on:

* Comparing nodes **pairwise**
* Using recursion to mirror the tree structure 🌳
* Returning early whenever a mismatch is found 🚫

This solution is **clean, intuitive, and perfectly suited for tree comparison problems** 😊
