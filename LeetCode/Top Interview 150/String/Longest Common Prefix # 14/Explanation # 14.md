## 🔤 Longest Common Prefix – My Approach Explained

### 🧠 Core Idea Behind My Approach

When I started thinking about this problem, my core idea was:

> **If a longest common prefix exists, it must be a prefix of the first string.**

So instead of comparing every string with every other string, I decided to:

* Take the **first string as a reference**
* Compare its characters **index by index** with the same index of all other strings
* The moment a mismatch occurs, I stop 🚦

This keeps the solution **simple, efficient, and intuitive**.

---

## 🪜 Step-by-Step Thought Process

### 1️⃣ Handle Edge Cases First

```java
if (strs.length == 0) {
    return "";
} else {
    if (strs.length == 1) {
        return strs[0];
    }
}
```

✔️ If the array is empty → no prefix
✔️ If there’s only one string → that string itself is the prefix

Handling edge cases early avoids unnecessary computation ⚠️

---

### 2️⃣ Character-by-Character Comparison

```java
for (int i = 0; i < strs[0].length(); i++) {
    char c = strs[0].charAt(i);
```

Here:

* I loop through each character of the **first string**
* Store the current character (`c`) for comparison

---

### 3️⃣ Compare With All Other Strings

```java
for (int l = 0; l < strs.length; l++) {
    if (i >= strs[l].length() || strs[l].charAt(i) != c) {
        return strs[0].substring(0, i);
    }
}
```

At each index `i`, I check:

* ❌ If any string is **shorter**
* ❌ If any string has a **different character**

The moment this happens, I return the prefix found so far 🛑

---

## 📊 Example Walkthrough (Tabular Form)

### Example 1:

```text
strs = ["flower", "flow", "flight"]
```

| Index | Character | flower | flow | flight | Match? |
| ----- | --------- | ------ | ---- | ------ | ------ |
| 0     | f         | f      | f    | f      | ✅      |
| 1     | l         | l      | l    | l      | ✅      |
| 2     | o         | o      | o    | i      | ❌      |

🔴 Mismatch at index `2`
✅ **Result:** `"fl"`

---

### Example 2:

```text
strs = ["dog", "racecar", "car"]
```

| Index | Character | dog | racecar | car | Match? |
| ----- | --------- | --- | ------- | --- | ------ |
| 0     | d         | d   | r       | c   | ❌      |

❌ No common prefix
✅ **Result:** `""`

---

### Example 3:

```text
strs = ["interview", "internet", "internal"]
```

| Prefix Progress     | Result |
| ------------------- | ------ |
| i → in → int → inte | ✅      |
| inter → intern      | ❌      |

✅ **Result:** `"inte"`

---

## ⏱️ Time & Space Complexity

### ⏰ Time Complexity: **O(n × m)**

* `n` → number of strings
* `m` → length of the shortest string
* Each character of the first string is compared with all strings

### 💾 Space Complexity: **O(1)**

* No extra data structures used
* Only constant space for variables

---

## 🎯 Final Thoughts

✨ What I like about this solution:

* It’s **simple and readable**
* It avoids unnecessary comparisons
* It exits early as soon as a mismatch is found ⚡
* Perfect for **interviews and clean code submissions**

This approach aligns naturally with how prefixes work, making it both **intuitive and efficient** 💪😊

---
