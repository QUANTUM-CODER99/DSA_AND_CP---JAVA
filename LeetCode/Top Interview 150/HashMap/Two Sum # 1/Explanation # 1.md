### **1. My core idea while approaching this problem**

When I wrote this `twoSum` method, my main goal was to **find two indices in the array whose numbers add up to the target**. I wanted to do it efficiently, so instead of using a nested loop (which would be slow), I thought:

* Can I **remember the numbers I’ve seen so far** and check if the number I need to reach the target exists?
* If I store each number in a **hash map**, I can check in **O(1)** time whether the complement (`target - nums[i]`) exists.
* That way, I can find the answer in **one pass through the array**, without checking every pair.

So basically, my thought process was:

> "Let’s go through each number, see if its 'partner' to make the target already exists, and if not, remember this number for later."

---

### **2. Step-by-step example with a table**

Suppose I have:

```java
nums = [2, 7, 11, 15], target = 9
```

I create a `Map<Integer,Integer>` called `result` to store numbers and their indices.

| i (index) | nums[i] | target - nums[i] | result.containsKey(target-nums[i])? | result map after step | Action               |
| --------- | ------- | ---------------- | ----------------------------------- | --------------------- | -------------------- |
| 0         | 2       | 7                | No                                  | {2 → 0}               | Add 2 to map         |
| 1         | 7       | 2                | Yes                                 | {2 → 0, 7 → 1}        | Found! Return [0, 1] |

✅ So, at index 1, I realized that `7 + 2 = 9`. I already had `2` in the map from index 0, so I immediately returned `[0,1]`.

If the array didn’t have a solution, the loop would end and I would return an **empty array** `[]`.

---

### **3. How the code works internally**

1. I initialize a HashMap called `result` to store `<number, index>`.
2. I loop through the array `nums`.
3. For each number `nums[i]`, I check if the **complement** (`target - nums[i]`) exists in the map.

   * If yes → I return the indices `[index of complement, i]`.
   * If no → I store `nums[i]` in the map to use later.
4. If the loop finishes without finding a pair, I return an empty array.

---

### **4. Time and Space Complexity**

**Time Complexity:**

* I loop through the array **once** → `O(n)`
* Lookup in a hash map is `O(1)` → total `O(n)`
  ✅ So the **time complexity is O(n)**.

**Space Complexity:**

* I store each number in the map → worst case all `n` numbers → `O(n)`
  ✅ So the **space complexity is O(n)**.

---

### **5. My takeaway**

When I solved this problem, the key idea I had in mind was:

> Use a HashMap to remember what I’ve seen so far, so I don’t have to check every pair. One pass is enough!

It’s like **thinking ahead** — always asking, “Do I already have the number that completes the target?”

Do you want me to do that?
