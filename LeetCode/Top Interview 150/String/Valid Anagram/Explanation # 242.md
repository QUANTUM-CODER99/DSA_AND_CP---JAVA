### **1. My core idea behind this approach**

When I look at the problem of checking whether two strings `s` and `t` are anagrams, the **core idea in my mind** is:

> *Two strings are anagrams if they contain exactly the same characters with the same frequency, just possibly in a different order.*

So, if I can **sort both strings** and they end up being identical, that proves they have the same characters in the same quantity. Sorting rearranges letters in order, so checking equality after sorting becomes simple.

The steps I thought of were:

1. Check if the lengths are different → if yes, they cannot be anagrams.
2. Convert the strings into character arrays because arrays are easier to sort in Java.
3. Sort both arrays.
4. Compare them element by element → if all match, return true; otherwise, return false.

---

### **2. Step-by-step example with a table**

Let's take an example:

```java
s = "listen"
t = "silent"
```

**Step 1: Check lengths**

| s.length() | t.length() | Are they equal? |
| ---------- | ---------- | --------------- |
| 6          | 6          | ✅ Yes           |

Lengths are equal, so we continue.

**Step 2: Convert to character arrays**

| s → c1                    | t → c2                    |
| ------------------------- | ------------------------- |
| ['l','i','s','t','e','n'] | ['s','i','l','e','n','t'] |

**Step 3: Sort both arrays**

| Sorted c1                 | Sorted c2                 |
| ------------------------- | ------------------------- |
| ['e','i','l','n','s','t'] | ['e','i','l','n','s','t'] |

**Step 4: Compare arrays**

| Index | c1[i] | c2[i] | Equal? |
| ----- | ----- | ----- | ------ |
| 0     | e     | e     | ✅      |
| 1     | i     | i     | ✅      |
| 2     | l     | l     | ✅      |
| 3     | n     | n     | ✅      |
| 4     | s     | s     | ✅      |
| 5     | t     | t     | ✅      |

All characters match → return **true**.

If even one character didn’t match after sorting, I would return **false**.

---

### **3. Time and space complexity**

**Time Complexity**:

1. Converting string to char array: `O(n)`
2. Sorting char arrays: `O(n log n)` for each string
3. Comparing arrays: `O(n)`

**Overall:** `O(n log n)` (sorting dominates)

**Space Complexity**:

* We create two new char arrays: `O(n + n) = O(n)`

So, extra space used is **O(n)**.

---

✅ **Summary in my mind**

* **Idea:** Sort both strings → if equal, they are anagrams.
* **Steps:** Length check → char array → sort → compare.
* **Example:** `"listen"` & `"silent"` → sorted arrays match → true.
* **Complexity:** `O(n log n)` time, `O(n)` space.

---
