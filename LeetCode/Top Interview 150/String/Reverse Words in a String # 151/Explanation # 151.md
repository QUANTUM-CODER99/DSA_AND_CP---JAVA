## 🔁 Reverse Words in a String – My Approach Explained

### 🧠 Core Idea Behind My Approach

When I approached this problem, my main goal was:

> **Reverse the order of words, not the characters, while handling extra spaces cleanly.**

So instead of manually scanning the string character by character, I decided to:

* **Trim leading and trailing spaces**
* **Split the string into words using regex**
* **Traverse the words in reverse order and rebuild the string**

This keeps the logic **simple, readable, and effective** ✨

---

## 🪜 Step-by-Step Breakdown

### 1️⃣ Remove Unnecessary Spaces

```java
String arr[] = s.trim().split("\\s+");
```

What I’m doing here:

* `trim()` removes extra spaces from the start and end 🧹
* `\\s+` splits the string by **one or more spaces**
* This ensures no empty words appear in the array

---

### 2️⃣ Reverse the Words

```java
for (int i = arr.length - 1; i > -1; i--)
    reverse += arr[i] + " ";
```

Here:

* I start from the **last word**
* Append each word to the result string
* Add a space after every word for separation

---

### 3️⃣ Clean the Final Output

```java
return reverse.trim();
```

* Removes the **extra trailing space**
* Ensures the output format is clean and correct ✅

---

## 📊 Example Walkthrough (Tabular Format)

### Example Input:

```text
s = "  hello   world  "
```

### After `trim()`:

```text
"hello   world"
```

### After `split("\\s+")`:

| Index | Word  |
| ----- | ----- |
| 0     | hello |
| 1     | world |

---

### Reversing Process:

| Step | Word Added | Result String    |
| ---- | ---------- | ---------------- |
| 1    | world      | `"world "`       |
| 2    | hello      | `"world hello "` |

After `trim()` 👉 **`"world hello"`**

---

### Another Example:

```text
s = "the sky is blue"
```

| Original Order | Reversed Order |
| -------------- | -------------- |
| the            | blue           |
| sky            | is             |
| is             | sky            |
| blue           | the            |

✅ **Output:** `"blue is sky the"`

---

## ⏱️ Time & Space Complexity

### ⏰ Time Complexity: **O(n)**

* `n` = length of the input string
* Splitting and looping through words both take linear time

⚠️ Note:

* Since string concatenation (`reverse +=`) creates new strings, this can **internally behave closer to O(n²)** in Java.
* Using `StringBuilder` would be more optimal 🚀

---

### 💾 Space Complexity: **O(n)**

* Extra space for:

  * Word array
  * Result string

---

## ⚡ Possible Optimization (Optional Improvement)

```java
StringBuilder sb = new StringBuilder();
for (int i = arr.length - 1; i >= 0; i--) {
    sb.append(arr[i]).append(" ");
}
return sb.toString().trim();
```

✔️ More efficient
✔️ Avoids repeated string creation
✔️ Preferred in interviews 💯

---

## 🎯 Final Thoughts

✨ What I like about this solution:

* It handles **extra spaces automatically**
* Code is **short and easy to understand**
* Uses built-in Java functions smartly 🧠

This approach is perfect when clarity matters and constraints are reasonable 👍

---
