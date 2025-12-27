## 1. Core Idea I Had While Approaching This Problem

When I saw the **Majority Element** problem, I reminded myself of the definition:

> The majority element is the one that appears **more than ⌊n / 2⌋ times**.

My thinking was simple and logical:

* If I **sort the array**, all equal elements will come **together**
* Once elements are grouped, I can **count consecutive occurrences**
* The element with the **highest frequency** must be the majority element

So my approach was:

👉 **Sort → Count consecutive elements → Track the maximum frequency**

This may not be the most optimal solution, but it is very **intuitive and safe**.

---

## 2. Handling the Small Edge Case First

```java
if (nums.length < 3)
    return nums[0];
```

In my head:

* If the array has **1 or 2 elements**, then:

  * The first element **must** be the majority element
* No need for extra work here ✅

---

## 3. Why I Sort the Array

```java
Arrays.sort(nums);
```

Sorting helps me because:

* All duplicates get grouped together 📊
* I can count occurrences just by scanning once

Example after sorting:

```
[2,2,2,1,1] → [1,1,2,2,2]
```

---

## 4. Variables and What They Mean

```java
int maxCount = Integer.MIN_VALUE;
int maxValue = nums[0];
int p = 0;
```

🧠 My mental model:

| Variable   | Meaning                        |
| ---------- | ------------------------------ |
| `p`        | Start index of current group   |
| `i`        | Moving pointer to scan array   |
| `maxCount` | Largest frequency seen so far  |
| `maxValue` | Element with highest frequency |

---

## 5. The Main Loop (Heart of the Solution ❤️)

```java
for (int i = 1; i <= nums.length; i++)
```

I loop **one step beyond the array** so that I can process the **last group** properly.

### Key Condition

```java
if ((i == nums.length || nums[p] != nums[i]) && maxCount < (i - p))
```

What I’m thinking here:

* `i == nums.length` → I reached the end 🛑
* `nums[p] != nums[i]` → current group ended
* `(i - p)` → length of current group
* If this group is bigger than the previous max → update result 🏆

---

## 6. Step-by-Step Example (with Table)

### Example Input

```java
nums = [2,2,1,1,1,2,2]
```

### After Sorting

```
[1,1,1,2,2,2,2]
```

---

### Loop Walkthrough

| Group | Value | Start (p) | End (i) | Count (i - p) |
| ----- | ----- | --------- | ------- | ------------- |
| 1     | 1     | 0         | 3       | 3             |
| 2     | 2     | 3         | 7       | 4             |

* Group `1` → count = 3
* Group `2` → count = 4 (bigger ✅)

So:

```java
maxValue = 2;
```

---

## 7. Final Output

```java
return maxValue; // 2
```

✔ Correct majority element
✔ Appears more than n/2 times
✔ Logic is clear and easy to debug

---

## 8. Time and Space Complexity

### ⏱️ Time Complexity

* Sorting: **O(n log n)**
* One pass through array: **O(n)**

✅ **Overall:**
**O(n log n)**

---

### 📦 Space Complexity

* Sorting is done in-place
* Only a few variables used

✅ **Space Complexity:**
**O(1)**

---

## 9. Final Summary 

* I sorted the array to group duplicates together
* I scanned the array and counted consecutive elements
* I tracked the element with the highest frequency
* That element must be the majority element
* The solution is simple, readable, and reliable
