## **1. My core idea while approaching this problem**

When I looked at this problem, my main thought was:

> **Each character in `pattern` should map to exactly one word in the sentence, and no two characters should map to the same word.**

So I realized I need to enforce **two rules at the same time**:

1. **Consistency**

   * If a pattern character has already been mapped, it must map to the **same word again**.
2. **Uniqueness**

   * If a word is already used by some other character, I must not reuse it.

To handle this cleanly, I decided to:

* Use a **HashMap** to store `character → word` mapping.
* Use a **HashSet** to ensure no two characters map to the same word.

That way, I can validate the pattern in **one pass**.

---

## **2. Step-by-step example using tables**

### ✅ Example 1:

```java
pattern = "abba"
s = "dog cat cat dog"
```

After splitting:

```java
arr = ["dog", "cat", "cat", "dog"]
```

#### Initial state:

* `check = {}`
* `rep = {}`

| i | pattern[i] | word | check (char → word) | rep (used words) | Result |
| - | ---------- | ---- | ------------------- | ---------------- | ------ |
| 0 | a          | dog  | a → dog             | dog              | OK     |
| 1 | b          | cat  | a → dog, b → cat    | dog, cat         | OK     |
| 2 | b          | cat  | b → cat (same)      | dog, cat         | OK     |
| 3 | a          | dog  | a → dog (same)      | dog, cat         | OK     |

✅ All checks pass → return **true**

---

### ❌ Example 2:

```java
pattern = "abba"
s = "dog cat cat fish"
```

| i | pattern[i] | word | check     | rep      | Result |
| - | ---------- | ---- | --------- | -------- | ------ |
| 3 | a          | fish | a → dog ❌ | dog, cat | FAIL   |

❌ `'a'` was already mapped to `"dog"`, but now tries `"fish"`

---

### ❌ Example 3:

```java
pattern = "ab"
s = "dog dog"
```

| i | pattern[i] | word | check                   | rep | Result |
| - | ---------- | ---- | ----------------------- | --- | ------ |
| 0 | a          | dog  | a → dog                 | dog | OK     |
| 1 | b          | dog  | ❌ rep already has "dog" | dog | FAIL   |

❌ Two characters mapping to the same word is not allowed.

---

## **3. How the code works internally**

1. I split the sentence into words using spaces.
2. I check if the number of words equals the pattern length.
3. I create:

   * `check` → character-to-word mapping
   * `rep` → set of already-used words
4. I loop through the pattern:

   * If the character already exists, I check consistency.
   * If it’s new, I ensure the word isn’t already mapped.
5. If all checks pass, I return `true`.

---

## **4. Time and Space Complexity**

### **Time Complexity**

* Splitting the string → `O(n)`
* One pass through pattern → `O(n)`
* HashMap / HashSet operations → `O(1)` average

✅ **Overall Time Complexity: `O(n)`**

---

### **Space Complexity**

* HashMap can store up to `n` entries
* HashSet can store up to `n` words

✅ **Space Complexity: `O(n)`**

---

## **5. My final takeaway**

The key idea I followed was:

> **Pattern matching requires both consistency and uniqueness.**

Using:

* A `HashMap` to preserve character-to-word consistency
* A `HashSet` to prevent duplicate word mappings

This approach is:
✔ Simple
✔ Safe
✔ Easy to explain in interviews

---

### 🔑 One-line interview explanation

> “I use a HashMap to maintain character-to-word consistency and a HashSet to ensure one-to-one mapping.”

---
