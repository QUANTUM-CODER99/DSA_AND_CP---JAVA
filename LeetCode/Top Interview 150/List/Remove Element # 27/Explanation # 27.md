## 1. Core Idea I Had While Approaching This Problem

When I first approached this problem, my main thought was:

> “I don’t want to deal with shifting elements inside the same array while iterating, because that can get tricky.”

So instead, I decided to:

* **Create a new list**
* **Store only the elements that are NOT equal to `val`**
* Copy those elements back into the original array

This way, I could clearly separate:

* **Filtering logic** (removing `val`)
* **Placing results back into `nums`**

Even though this isn’t the most space-optimal solution, it is very **simple and easy to understand**.

---

## 2. Step-by-Step Explanation Using Example + Table

### Example Input

```java
nums = [3,2,2,3]
val = 3
```

---

### Step 1: Traverse and Filter Elements

```java
List<Integer> ans = new ArrayList<>();
```

I created a list to store valid elements.

| Index | nums[i] | nums[i] != val | ans after step |
| ----- | ------- | -------------- | -------------- |
| 0     | 3       | ❌              | []             |
| 1     | 2       | ✅              | [2]            |
| 2     | 2       | ✅              | [2, 2]         |
| 3     | 3       | ❌              | [2, 2]         |

So after this loop, `ans` contains only the elements I want to keep.

---

### Step 2: Copy Elements Back to nums

```java
for(int i = 0; i < ans.size(); i++)
    nums[i] = ans.get(i);
```

| Index | nums after copy |
| ----- | --------------- |
| 0     | 2               |
| 1     | 2               |
| 2     | (ignored)       |
| 3     | (ignored)       |

The problem statement allows the elements **after index `k - 1` to be anything**, so I don’t care about them.

---

### Step 3: Return the New Length

```java
return ans.size();
```

The new length is:

```
k = 2
```

---

## 3. Why This Approach Works

In my mind:

* The order of remaining elements **does not change**
* I only care about the **first `k` elements**
* Using an extra list avoids tricky index manipulation

This makes the solution:

* Easy to write
* Easy to debug
* Very clear conceptually

---

## 4. Time and Space Complexity

### Time Complexity

* First loop → `O(n)`
* Second loop → `O(n)`

[
\textbf{O(n)}
]

---

### Space Complexity

* Extra `ArrayList` used to store elements

[
\textbf{O(n)}
]

---

## 5. Important Note (Interview Perspective)

While this solution is **correct**, I’m aware that:

* The problem asks for **in-place modification**
* This approach uses **extra space**

In interviews, I should also know the **two-pointer in-place solution**, which achieves:

* **O(n)** time
* **O(1)** space

But for understanding and clarity, this approach is perfectly valid.

---

## 6. Final Summary 

* I filtered out unwanted elements using an extra list
* I copied the valid elements back into the original array
* I returned the count of remaining elements
* The solution is clean, readable, and logically simple

This approach prioritizes **clarity over optimal space usage**, which is often helpful while learning.
