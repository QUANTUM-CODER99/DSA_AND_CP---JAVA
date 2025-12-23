### **1. My core idea behind this approach**

When I think about the problem of grouping anagrams, my **core idea** is:

> *All anagrams, when sorted, will produce the same string. So, if I can use this sorted string as a “key,” I can group all words that are anagrams of each other together.*

So, my mental steps were:

1. Iterate over each string in the array.
2. Convert it to a char array and sort it → this gives me a canonical form.
3. Use the sorted string as a key in a HashMap.
4. If the key doesn’t exist, create a new list for that key.
5. Add the original string to the list corresponding to the key.
6. Finally, collect all lists from the map → that’s my grouped anagrams.

Essentially, I’m using the **sorted version of each string as a signature** to group them.

---

### **2. Step-by-step example with a table**

Let’s take an example:

```java
strs = ["eat","tea","tan","ate","nat","bat"]
```

**Step 1: Initialize map**

| Map (key → list) |
| ---------------- |
| {}               |

**Step 2: Process each string**

---

**String: "eat"**

* Convert to char array → `['e','a','t']`
* Sort → `['a','e','t']` → key = `"aet"`

| Key   | List    |
| ----- | ------- |
| "aet" | ["eat"] |

---

**String: "tea"**

* Convert → `['t','e','a']`
* Sort → `['a','e','t']` → key = `"aet"`
* Key exists → add to existing list

| Key   | List          |
| ----- | ------------- |
| "aet" | ["eat","tea"] |

---

**String: "tan"**

* Convert → `['t','a','n']`
* Sort → `['a','n','t']` → key = `"ant"`
* Key doesn’t exist → create new list

| Key   | List          |
| ----- | ------------- |
| "aet" | ["eat","tea"] |
| "ant" | ["tan"]       |

---

**String: "ate"**

* Convert → `['a','t','e']`
* Sort → `['a','e','t']` → key = `"aet"`
* Key exists → add to list

| Key   | List                |
| ----- | ------------------- |
| "aet" | ["eat","tea","ate"] |
| "ant" | ["tan"]             |

---

**String: "nat"**

* Convert → `['n','a','t']`
* Sort → `['a','n','t']` → key = `"ant"`
* Key exists → add to list

| Key   | List                |
| ----- | ------------------- |
| "aet" | ["eat","tea","ate"] |
| "ant" | ["tan","nat"]       |

---

**String: "bat"**

* Convert → `['b','a','t']`
* Sort → `['a','b','t']` → key = `"abt"`
* Key doesn’t exist → create new list

| Key   | List                |
| ----- | ------------------- |
| "aet" | ["eat","tea","ate"] |
| "ant" | ["tan","nat"]       |
| "abt" | ["bat"]             |

---

**Step 3: Return all lists**

```java
[["eat","tea","ate"], ["tan","nat"], ["bat"]]
```

---

### **3. Time and Space Complexity**

**Time Complexity:**

1. For each string of length `k`, sorting takes `O(k log k)`.
2. We process `n` strings → total time = `O(n * k log k)`
   (where `n = number of strings`, `k = max string length`)

**Space Complexity:**

1. We store all strings in the map → `O(n * k)`
2. Extra space for char arrays → `O(k)` per iteration, but dominated by map storage

So, **space complexity** = `O(n * k)`.

---

✅ **Summary in my mind**

* **Idea:** Sort strings → use sorted string as key in a map → group original strings.
* **Steps:** Iterate → sort → map → add → collect values.
* **Example:** ["eat","tea","tan","ate","nat","bat"] → [["eat","tea","ate"], ["tan","nat"], ["bat"]]
* **Complexity:** `O(n * k log k)` time, `O(n * k)` space.

---
