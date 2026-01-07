## 🧠 My Core Idea While Approaching This Problem

The goal of the **RandomizedSet** problem is to design a data structure that can:

1. **Insert** an element
2. **Remove** an element
3. **Return a random element**

At the start, my mindset was:

> “I need a collection where I can easily store values and randomly access any index.”

So the **simplest structure** that came to my mind was an **ArrayList** 📋 because:

* It supports dynamic resizing
* It allows **index-based access**, which is perfect for `getRandom()`

I intentionally kept the implementation simple and readable, focusing on **correctness first** ✅.

---

## 🏗️ Data Structure Used

```java
ArrayList<Integer> cases;
```

* This list stores **all the elements currently present** in the set.
* Every operation (`insert`, `remove`, `getRandom`) is performed on this list.

---

## 🔍 Method-wise Explanation

---

### 1️⃣ Constructor – Initializing the Set

```java
public RandomizedSet() {
    cases = new ArrayList<>();
}
```

🧠 **Thought Process**:

* Whenever a new `RandomizedSet` is created, I initialize an empty `ArrayList`.
* This list represents the current state of the set.

---

### 2️⃣ Insert Operation

```java
public boolean insert(int val) {
    if(cases.contains(val)) return false;
    cases.add(val);
    return true;
}
```

🧠 **My Logic**:

* First, I check whether the value already exists.
* If it does, I **don’t insert duplicates** → return `false`.
* Otherwise, I add the value and return `true`.

📌 **Example**

| Operation  | cases before | cases after | Return |
| ---------- | ------------ | ----------- | ------ |
| insert(10) | []           | [10]        | true   |
| insert(20) | [10]         | [10, 20]    | true   |
| insert(10) | [10, 20]     | [10, 20]    | false  |

---

### 3️⃣ Remove Operation

```java
public boolean remove(int val) {
    if(!cases.contains(val)) return false;
    cases.remove(Integer.valueOf(val));
    return true;
}
```

🧠 **My Logic**:

* I first check if the value exists.
* If it doesn’t, removal is impossible → return `false`.
* If it does exist, I remove it using:

  ```java
  Integer.valueOf(val)
  ```

  This ensures I remove the **object**, not the index ⚠️.

📌 **Example**

| Operation  | cases before | cases after | Return |
| ---------- | ------------ | ----------- | ------ |
| remove(20) | [10, 20]     | [10]        | true   |
| remove(30) | [10]         | [10]        | false  |

---

### 4️⃣ getRandom Operation 🎲

```java
public int getRandom() {
    int randomIndex = (int)(Math.random()*cases.size());
    return cases.get(randomIndex);
}
```

🧠 **My Logic**:

* `Math.random()` gives a value between **0 and 1**.
* I multiply it by `cases.size()` to get a valid index.
* Then I return the element at that random index.

📌 **Example**

If:

```
cases = [10, 40, 70]
```

Possible `randomIndex` values:

```
0 → 10
1 → 40
2 → 70
```

Each element has an **equal probability** 🎯.

---

## ⏱️ Time & Space Complexity

### 🕒 Time Complexity

| Operation | Complexity                      |
| --------- | ------------------------------- |
| insert    | O(n) (due to contains)          |
| remove    | O(n) (due to contains + remove) |
| getRandom | O(1)                            |

---

### 🧠 Space Complexity

* ArrayList stores `n` elements → **O(n)**

---

## ⚠️ Important Note (Design Insight)

This solution is **correct and easy to understand**, but:

* `insert` and `remove` are **not O(1)** due to `contains()`.

👉 For optimal O(1) performance, a **HashMap + ArrayList** combination is usually used.

However, for learning and clarity purposes, this approach is:

* ✅ Clean
* ✅ Readable
* ✅ Conceptually strong

---

## 🎯 Final Takeaway

> I implemented `RandomizedSet` using an `ArrayList` because it allows simple insertion, removal, and efficient random access.

This solution helped me focus on **core logic and behavior** before jumping into heavy optimizations 🚀😊
