## 🔍 What I Was Thinking While Solving This Problem

When I saw this problem, I told myself:

> “The array is already sorted 📊, and I’m allowed to keep **at most two copies** of each number.”

So my goal became very clear:

👉 **Never allow a third duplicate to enter the valid part of the array.**

Instead of counting frequencies (which would be extra work), I used a **two-pointer + greedy idea** that naturally enforces this rule.

---

## 🚀 Why the First Two Elements Are Always Safe

```java
if (nums.length <= 2) return nums.length;
```

In my head 👇

* If the array has **0, 1, or 2 elements**, it already follows the rule
* So I don’t need to do anything special here ✅

```java
int p = 2;
```

🧠 My mental model:

* I **always keep the first two elements**
* Pointer `p` shows **where the next valid element should go**
* Everything before `p` is already “approved” ✔️

---

## 🧠 The Key Trick (Heart of the Solution ❤️)

```java
if (nums[i] != nums[p - 2])
```

This line is where the magic happens ✨

What I’m thinking is:

> “If the current number is the same as the number two positions behind, then adding it would create **three copies** 😬 — not allowed!”

So:

* `nums[p - 2]` → second last kept number
* Same value ❌ → skip it
* Different value ✅ → keep it

This way, I never allow more than **two duplicates** 🚫🚫🚫

---

## 📊 Step-by-Step Example (With Emoji Vibes)

### Input

```java
nums = [1,1,1,2,2,3]
```

---

### Initial Setup

| Index | 0 | 1 | 2 | 3 | 4 | 5 |
| ----- | - | - | - | - | - | - |
| nums  | 1 | 1 | 1 | 2 | 2 | 3 |

* `p = 2`
* Valid part = `[1, 1]` ✅ (always allowed)

---

### Loop Walkthrough 🏃‍♂️

| i | nums[i] | nums[p-2] | Decision | Why?             |
| - | ------- | --------- | -------- | ---------------- |
| 2 | 1       | 1         | ❌ Skip   | Would be 3rd `1` |
| 3 | 2       | 1         | ✅ Keep   | New number       |
| 4 | 2       | 1         | ✅ Keep   | Only 2nd `2`     |
| 5 | 3       | 2         | ✅ Keep   | New number       |

Array gradually becomes:

```
[1, 1, 2, 2, 3, _]
```

---

## 🎯 Final Answer

```java
return p; // 5
```

✔ Valid array: `[1, 1, 2, 2, 3]`
✔ Each number appears **at most twice**
✔ In-place, no extra memory 🧠💡

---

## ⚡ Why This Approach Works So Well

* Sorted array = duplicates are next to each other 📏
* Checking `p - 2` blocks the **third duplicate automatically**
* No counting, no extra arrays, no confusion 😌
* Just clean pointer movement

---

## ⏱️ Time & Space Complexity

⏰ **Time Complexity:**
**O(n)** — one simple pass through the array

📦 **Space Complexity:**
**O(1)** — only pointers, no extra space

---

## 🧾 Final Summary (My Own Words)

* I always allow the first two elements 👍
* I use a pointer to control where valid elements go
* I compare with the element **two steps back**
* This naturally enforces the “at most twice” rule 🚦
* The solution is elegant, efficient, and interview-ready 💯
