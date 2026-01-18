## 🧠 My Thought Process (Core Idea)

When I approached this problem, my **core idea** was to check whether all characters of string `s` appear **in order** inside string `t`, **without changing their relative order**.

Important realization 💡:

* The characters of `s` **do not need to be consecutive** in `t`
* They just need to appear **in the same sequence**

So instead of trying all combinations, I decided to use a **two-pointer approach**, which is both simple and efficient 🚀

---

## ✨ Key Observations

1. If `s` is longer than `t`, then `s` **cannot** be a subsequence → return `false` immediately ❌
2. I can scan both strings **once** using two pointers
3. Every time I find a matching character, I move forward in `s`

---

## 👉 Two Pointer Strategy

* Pointer `i` → tracks position in string `s`
* Pointer `j` → tracks position in string `t`

### Logic:

* If `s.charAt(i) == t.charAt(j)` → move `i` forward ✅
* Always move `j` forward to continue scanning `t`

---

## 🧪 Example Walkthrough

### Input:

```text
s = "abc"
t = "ahbgdc"
```

### Pointer Movement (Tabular View)

| Step | i (s) | s[i] | j (t) | t[j] | Match? | Action   |
| ---: | ----: | ---- | ----: | ---- | ------ | -------- |
|    1 |     0 | a    |     0 | a    | ✅      | i++, j++ |
|    2 |     1 | b    |     1 | h    | ❌      | j++      |
|    3 |     1 | b    |     2 | b    | ✅      | i++, j++ |
|    4 |     2 | c    |     3 | g    | ❌      | j++      |
|    5 |     2 | c    |     4 | d    | ❌      | j++      |
|    6 |     2 | c    |     5 | c    | ✅      | i++, j++ |

### Final State:

```text
i == s.length() → true
```

🎉 So `"abc"` **is a subsequence** of `"ahbgdc"`

---

## ❌ Another Example (Failure Case)

### Input:

```text
s = "axc"
t = "ahbgdc"
```

Here, `'x'` is never found in `t`, so `i` never reaches the end of `s`.

➡️ Result: `false`

---

## ✅ Why This Approach Works Well

✔ Simple and readable
✔ No extra data structures
✔ Single pass through both strings
✔ Efficient for large inputs 💪

---

## ⏱ Time Complexity

### **O(n + m)**

* `n` = length of `s`
* `m` = length of `t`
* Each pointer moves forward only once

---

## 💾 Space Complexity

### **O(1)**

* No extra space used
* Only two integer pointers

---

## 🌟 Summary

✔ I used a **two-pointer technique**
✔ Matched characters in order
✔ Ensured efficiency with constant space
✔ Clean and optimal solution ✨

This approach helped me solve the problem in the **most intuitive and optimal way** 😊
