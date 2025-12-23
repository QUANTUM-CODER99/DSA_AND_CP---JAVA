## **1. My core idea while approaching this method**

When I approached this problem using arrays, my main realization was:

> **Two strings are isomorphic if their characters follow the same pattern of occurrence.**

Instead of directly mapping characters to characters, I thought:

* If `s[i]` maps to `t[i]`, then
  **both characters must have appeared at the same previous index**.
* If one character appeared earlier and the other didn’t, the mapping is broken.

So my idea was to:

* Track the **last seen index** of each character in both strings.
* Compare their histories at every step.
* If the histories ever differ, return `false` immediately.

This avoids HashMaps entirely and gives me a faster, cleaner solution.

---

## **2. Why I used arrays of size 256**

* Characters are stored as numeric values (ASCII).
* ASCII range is `0–255`.
* Using `256` ensures:

  * Every ASCII character gets its own index.
  * No collisions.
  * Constant-time access.

And since arrays default to `0`, I can use that as:

* **“not seen yet”**

---

## **3. Step-by-step example using tables**

### ✅ Example 1: `s = "egg"`, `t = "add"`

Initial state:

* `m1` and `m2` are all `0`.

| i | s[i] | t[i] | m1[s[i]] | m2[t[i]] | Check | Update   |
| - | ---- | ---- | -------- | -------- | ----- | -------- |
| 0 | e    | a    | 0        | 0        | OK    | e→1, a→1 |
| 1 | g    | d    | 0        | 0        | OK    | g→2, d→2 |
| 2 | g    | d    | 2        | 2        | OK    | g→3, d→3 |

✅ At every index, the last seen positions match → **true**

---

### ❌ Example 2: `s = "foo"`, `t = "bar"`

| i | s[i] | t[i] | m1[s[i]] | m2[t[i]] | Result |
| - | ---- | ---- | -------- | -------- | ------ |
| 0 | f    | b    | 0        | 0        | OK     |
| 1 | o    | a    | 0        | 0        | OK     |
| 2 | o    | r    | 2        | 0        | ❌ FAIL |

Here:

* `'o'` was seen before
* `'r'` was not

The histories don’t match → **not isomorphic**

---

### ❌ Example 3: `s = "ab"`, `t = "aa"`

| i | s[i] | t[i] | m1[s[i]] | m2[t[i]] | Result |
| - | ---- | ---- | -------- | -------- | ------ |
| 0 | a    | a    | 0        | 0        | OK     |
| 1 | b    | a    | 0        | 1        | ❌ FAIL |

This shows:

* Two characters from `s` trying to map to the same character in `t`
* Invalid one-to-one mapping

---

## **4. How the code works internally**

1. I create two arrays `m1` and `m2` to track last seen positions.
2. I loop through the strings index by index.
3. At each index:

   * I compare the last seen positions of `s[i]` and `t[i]`.
   * If they differ → return `false`.
4. I update both arrays with `i + 1`.
5. If the loop completes → return `true`.

---

## **5. Time and Space Complexity**

### **Time Complexity**

* Single pass through the strings → `O(n)`
* Array access is constant time

✅ **Time Complexity: `O(n)`**

---

### **Space Complexity**

* Two arrays of fixed size `256`

✅ **Space Complexity: `O(1)` (constant space)**

---

## **6. My final takeaway**

The key idea I followed was:

> **Isomorphic strings share the same “last seen index” pattern.**

By comparing character histories instead of direct mappings, I:

* Avoided HashMaps
* Eliminated object comparison bugs
* Achieved optimal performance

This solution is:
✔ Fast
✔ Safe
✔ Interview-ready

---
