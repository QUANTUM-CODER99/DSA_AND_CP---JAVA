## **1. My core idea while approaching this problem**

When I approached this problem, the key thought in my mind was:

> **If string `s` is isomorphic to string `t`, then the mapping must work BOTH ways.**

That means:

* Every character in `s` must map to **only one** character in `t`.
* At the same time, every character in `t` must map to **only one** character in `s`.

If I only check one direction, I might miss cases where:

* Two different characters in `s` map to the **same** character in `t` (which is invalid).

So my idea was:

* Use **two HashMaps**:

  * `a` → mapping from `s` → `t`
  * `b` → mapping from `t` → `s`
* While iterating, I validate consistency in **both directions** at the same time.
* If I ever see a mismatch, I immediately return `false`.

In short, my mental rule was:

> **One-to-one mapping must exist in both directions.**

---

## **2. Step-by-step example using tables**

### ✅ Example 1: `s = "egg"`, `t = "add"` (Valid)

#### Initial state:

* `a = {}`
* `b = {}`

| i | s[i] | t[i] | Map `a` (s → t) | Map `b` (t → s) | Result |
| - | ---- | ---- | --------------- | --------------- | ------ |
| 0 | e    | a    | e → a           | a → e           | OK     |
| 1 | g    | d    | g → d           | d → g           | OK     |
| 2 | g    | d    | g → d (same)    | d → g (same)    | OK     |

✅ All mappings are consistent → return **true**

---

### ❌ Example 2: `s = "foo"`, `t = "bar"` (Invalid)

| i | s[i] | t[i] | Map `a` (s → t) | Issue    |
| - | ---- | ---- | --------------- | -------- |
| 0 | f    | b    | f → b           | OK       |
| 1 | o    | a    | o → a           | OK       |
| 2 | o    | r    | o → a ❌         | Conflict |

At index `2`, `'o'` was already mapped to `'a'`, but now it’s trying to map to `'r'`.

❌ Mapping breaks → return **false**

---

### ❌ Example 3: `s = "ab"`, `t = "aa"` (Invalid)

This is where **two maps are crucial**.

| i | s[i] | t[i] | Map `a` (s → t) | Map `b` (t → s) | Issue    |
| - | ---- | ---- | --------------- | --------------- | -------- |
| 0 | a    | a    | a → a           | a → a           | OK       |
| 1 | b    | a    | b → a           | a → a ❌         | Conflict |

Here:

* `b → a` is allowed in map `a`
* BUT `a` in map `b` is already mapped to `a`, not `b`

❌ Two characters mapping to one → return **false**

---

## **3. How the code works internally**

1. I create **two HashMaps**:

   * `a` → maps characters from `s` to `t`
   * `b` → maps characters from `t` to `s`
2. I loop through both strings character by character.
3. For each index `i`:

   * I check if `s[i]` already has a mapping in `a`:

     * If yes and it doesn’t match `t[i]` → return `false`
   * I do the same check for `t[i]` in map `b`
4. If the entire loop finishes without conflict, I return `true`.

---

## **4. Time and Space Complexity**

### **Time Complexity**

* I iterate through the strings once → `O(n)`
* HashMap operations (`put`, `get`, `containsKey`) are `O(1)`

✅ **Total Time Complexity: `O(n)`**

---

### **Space Complexity**

* I store mappings for at most all unique characters
* Worst case: all characters are unique

✅ **Space Complexity: `O(n)`**

---

## **5. My final takeaway**

The core logic I followed was:

> **Isomorphism is a two-way guarantee, not a one-way rule.**

Using two HashMaps ensures:

* No character maps to multiple characters
* No character receives mappings from multiple characters

---
