## 🧠 My Core Idea While Solving This Problem

When I approached this **Zigzag Conversion** problem, my main idea was to **simulate the zigzag pattern exactly as it is written on paper**, instead of trying to mathematically calculate indices.

Rather than jumping characters around in the string, I imagined this:

👉 Each row in the zigzag can be treated as a **separate container**
👉 I move **downward** through the rows, then **upward diagonally**, repeatedly
👉 Finally, I **read row by row** to form the result string

So my mindset was:

> “Why not store characters row-wise while traversing the string in a zigzag manner?”

This naturally led me to use:

* An **array of lists**, where each list represents a row
* A **direction variable (`d`)** to control whether I’m moving up or down ⬆️⬇️

---

## 🧩 Why I Used an Array of Lists

```java
List<Character>[] rows = new ArrayList[numRows];
```

Each index in `rows` represents **one row of the zigzag**.

I initialized each list explicitly to avoid `NullPointerException` 🚫:

```java
for (int i = 0; i < numRows; i++)
    rows[i] = new ArrayList<>();
```

This setup lets me **freely add characters** to any row while traversing the string.

---

## 🔁 Zigzag Traversal Logic (The Heart of the Solution)

I used two variables:

* `idx` → keeps track of the **current row**
* `d` → controls the **direction**

  * `+1` → moving downward
  * `-1` → moving upward

```java
int idx = 0, d = 1;
```

### Direction Rules:

* If I’m at the **top row**, I must go **down**
* If I’m at the **bottom row**, I must go **up**

```java
if (idx == 0) d = 1;
else if (idx == numRows - 1) d = -1;
```

This perfectly mimics the zigzag movement 🔄

---

## 📊 Example Walkthrough

### Input:

```text
s = "PAYPALISHIRING"
numRows = 3
```

### Zigzag Pattern:

```
Row 0: P   A   H   N
Row 1: A P L S I I G
Row 2: Y   I   R
```

### Step-by-Step Table

| Character | Row Index (`idx`) | Direction (`d`) |
| --------- | ----------------- | --------------- |
| P         | 0                 | ↓               |
| A         | 1                 | ↓               |
| Y         | 2                 | ↑               |
| P         | 1                 | ↑               |
| A         | 0                 | ↓               |
| L         | 1                 | ↓               |
| I         | 2                 | ↑               |
| S         | 1                 | ↑               |
| H         | 0                 | ↓               |
| I         | 1                 | ↓               |
| R         | 2                 | ↑               |
| I         | 1                 | ↑               |
| N         | 0                 | ↓               |
| G         | 1                 | ↓               |

This table clearly shows how `idx` and `d` work together to form the zigzag pattern 🧩

---

## 🧵 Building the Final String

Once all characters are placed correctly in their rows, I simply **read row by row**:

```java
StringBuilder result = new StringBuilder();
for (List<Character> row : rows) {
    for (char c : row) {
        result.append(c);
    }
}
```

This gives the final output:

```text
"PAHNAPLSIIGYIR"
```

---

## ⚡ Edge Case Handling

```java
if (numRows == 1 || numRows >= s.length())
    return s;
```

I included this because:

* With **1 row**, zigzag doesn’t exist
* If rows ≥ string length, characters stay as they are

This avoids unnecessary computation and keeps the solution clean ✨

---

## ⏱️ Time & Space Complexity

### ✅ Time Complexity: **O(n)**

* I traverse the string **once**
* I build the result string **once**
* Total work is linear with respect to string length

### ✅ Space Complexity: **O(n)**

* Extra space is used to store characters across all rows
* The total number of stored characters is `n`

---

## 🎯 Final Thought

This solution is:

* **Easy to understand**
* **Visually intuitive**
* **Efficient and clean**
