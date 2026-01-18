## 🧠 My Thought Process (Core Idea)

While approaching this problem, **my main idea** was to simplify the string first and then check whether it reads the same forwards and backwards.

Instead of checking the palindrome condition directly on the original string (which contains spaces, symbols, and mixed cases), I decided to:

1. **Normalize the string**

   * Convert all characters to **lowercase**
   * **Ignore non-alphanumeric characters** (spaces, punctuation, symbols)

2. **Create a clean version of the string**

   * This makes palindrome checking straightforward and avoids unnecessary edge cases

3. **Use the two-pointer technique**

   * Compare characters from the **start and end**
   * Move inward until they meet

This approach keeps the logic clean, readable, and easy to debug 😊

---

## ✨ Step 1: Filtering & Normalizing the String

In the `isPalindrome()` method, I loop through each character and:

* Convert it to lowercase
* Keep it only if it is a **letter (a–z)** or **digit (0–9)**

### Example Input

```text
"A man, a plan, a canal: Panama"
```

### Character Filtering (Tabular View)

| Index | Character | Lowercase | Alphanumeric? | Added to `convert` |
| ----: | --------- | --------- | ------------- | ------------------ |
|     0 | 'A'       | 'a'       | ✅             | a                  |
|     1 | ' '       | ' '       | ❌             | ❌                  |
|     2 | 'm'       | 'm'       | ✅             | m                  |
|     3 | 'a'       | 'a'       | ✅             | a                  |
|     4 | 'n'       | 'n'       | ✅             | n                  |
|     5 | ','       | ','       | ❌             | ❌                  |
|   ... | ...       | ...       | ...           | ...                |

### Final Converted String

```text
"amanaplanacanalpanama"
```

✔ Clean
✔ Lowercase
✔ Only letters and digits

---

## 🔍 Step 2: Checking Palindrome Using Two Pointers

In the `checkPalindrome()` method, I use:

* `left` pointer → start of the string
* `right` pointer → end of the string

### Pointer Movement (Tabular View)

| Left Index | Left Char | Right Index | Right Char | Match? |
| ---------: | --------- | ----------: | ---------- | ------ |
|          0 | a         |          20 | a          | ✅      |
|          1 | m         |          19 | m          | ✅      |
|          2 | a         |          18 | a          | ✅      |
|          3 | n         |          17 | n          | ✅      |
|        ... | ...       |         ... | ...        | ...    |

If at any point characters don’t match, I immediately return `false`.

If all characters match until the pointers cross, I return `true`. 🎯

---

## ✅ Why This Approach Works Well

* Separating **string cleaning** and **palindrome checking** makes the code modular
* Two-pointer technique avoids unnecessary string reversal
* Easy to understand and efficient 👍

---

## ⏱ Time Complexity

### Overall Time Complexity: **O(n)**

* Filtering the string → **O(n)**
* Checking palindrome → **O(n)**
* Combined → **O(n)**

---

## 💾 Space Complexity

### Space Complexity: **O(n)**

* I create a new string `convert` to store filtered characters

---

## 🌟 Summary

✔ I first cleaned the input string
✔ Ignored cases and special characters
✔ Used a two-pointer technique to compare characters
✔ Achieved an efficient and readable solution

This method helped me solve the problem **clearly, efficiently, and safely** 🚀
