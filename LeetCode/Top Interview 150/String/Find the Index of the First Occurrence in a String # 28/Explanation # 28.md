## 🧠 My Thought Process While Solving This Problem

When I looked at this problem (**Find the Index of the First Occurrence in a String**), my first thought was:

> “Why reinvent the wheel when Java already provides a highly optimized method for this exact task?”

The goal of the problem is simple:

* Find the **first index** where `needle` appears in `haystack`
* If it doesn’t exist, return `-1`

Java’s `String` class already gives me the `indexOf()` method, which does **exactly the same thing**.

So instead of writing a manual string-matching algorithm, I chose to **leverage the standard library** for clarity, correctness, and efficiency 🚀

---

## 💡 Core Idea Behind This Solution

The core idea is:

* Use `haystack.indexOf(needle)`
* Let Java handle all the edge cases internally
* Return the result directly

```java
return haystack.indexOf(needle);
```

That’s it.
Simple, clean, and readable ✨

---

## 📌 Why `indexOf()` Works Perfectly Here

The `indexOf(String str)` method:

* Returns the **index of the first occurrence** of `str`
* Returns **-1** if the substring is not found

Which aligns **exactly** with the problem requirements ✅

---

## 📊 Example Walkthrough

### Example 1

```text
haystack = "sadbutsad"
needle   = "sad"
```

* `"sad"` first appears at index **0**
* `indexOf("sad") → 0`

✔️ Output: `0`

---

### Example 2

```text
haystack = "leetcode"
needle   = "leeto"
```

* `"leeto"` does not exist in `"leetcode"`
* `indexOf("leeto") → -1`

✔️ Output: `-1`

---

### Example 3 (Edge Case)

```text
haystack = "hello"
needle   = ""
```

* An empty string is always found at index `0`
* `indexOf("") → 0`

✔️ Output: `0`

---

## 🧮 Time and Space Complexity

### ⏱️ Time Complexity

* **O(n × m)** in the worst case

  * `n` = length of `haystack`
  * `m` = length of `needle`
* Internally, Java uses efficient string-search algorithms, so in practice this performs very well ⚡

### 🗂️ Space Complexity

* **O(1)**
* No extra space is used apart from method calls

---

## 🎯 Why This Solution Is a Good Choice

✔️ Clean and minimal
✔️ Uses built-in, well-tested Java functionality
✔️ Avoids unnecessary complexity
✔️ Easy to understand and maintain

Sometimes, the **best solution is the simplest one** 😄

---

## 🏁 Final Thought

This solution demonstrates that:

> Writing good code is not about writing *more* code — it’s about writing *smart* code 💡
