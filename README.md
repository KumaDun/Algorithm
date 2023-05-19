# Algorithm
Algorithm Reviewing
## MergeSort:
```
merge(A, B):
	C = new array[len(A) + len(B)]
	i, j, k <- 0
	while i < len(A) and j < len(B):
	if A[i] < B[j]:
		C[k] <- A[i]
		i++, k++
	else:
		C[k] <- B[j]
		j++, k++
	while i < len(A):
		C[k++] <-A[i++]
	while j < len(B):
		C[k++] <- B[j++]
	return C

MergeSort(A):
	rec-mergesort(A, 0,len(A)-1)

rec-mergesort(A, lo, hi):
	if (hi - lo <= 0) return
	mid = (lo + hi) / 2
	rec-mergesort(A, lo, mid)
	rec-mergesort(A, mid+1,hi)
	C = merge(A[lo:mid],A[mid+1:hi])
```
## Binary Search
$$ T(n) = T(\frac{n}{2}) + 1 \in O(\log n)$$
*Apply Master Theorem a=1, b=2, c=0 and a = b^c*
```
BinarySearch(𝐴, val, lo, hi): 
	if hi<lo
		return -1
mid ← (lo + hi) / 2
if 𝐴[mid] > val:
	return BinarySearch(𝐴, val, lo, mid - 1)
else if 𝐴[mid] < val:
	return BinarySearch(𝐴, val, mid + 1, hi)
else
	return mid
# to initially call the function:
BinarySearch(𝐴, val, 0, len(𝐴) – 1)
```
## Quick Sort
### Idea
	1. Choose a pivot element x at random
	2. Compare all elements to the pivot
	3. Partition all elements into two sets, S smaller than x, L larger than x
	4. Recursively sort S and L, let's annote |S|=k
### RunTime
1. Any two elements are never compared more than once
2. If p is the pivot, $x\lt p$, $y\lt p$, then x and y are never compared
3. Denote the k th smallest element in the array as ek
4. X = total \# of comparisons, $X_{ij}$ indicates if $e_i$ and $e_j$ are compared
5. Then $$X = \sum_{1\le i \lt j \le n}X_{ij} = \sum_{i=1}^n \sum_{j=i+1}^n Pr\[X_{ij}=1\]$$
6. Which pivot to pick so that $e_i, e_j$ be compared? only when either $e_i$ or $e_j$ are chosen as the pivot (2 total)
7. Which pivot to pick so that $e_i,e_j$ are not ever be compared? $e_{i+1},e_{i+2},\dots,e_{j-1}$
8. $E\[X_{ij}\]=2 \cdot \frac{1}{j-i-1+2}=\frac{2}{j-i+1}$
9. 
$$
\begin{align}
X=\sum_{i=1}^n \sum_{j=i+1}^n Pr\[X_{ij} = 1\] &= \sum_{d=1}^{n-1} \frac{2(n-d)}{d+1} | (j-i)=d \\
&=2n\sum_{d=1}^{n-1}\frac{1}{d+1} - \sum_{d=1}^{n-1}\frac{d}{d+1}\\
&= 2nlogn - O(n) \in O(nlogn) \\
\end{align}
$$

10. The smaller $j-i$, the higher probability $e_i,e_j$ will be compared, that's why the algorithm saves time

## Quick Select
* Select the $k^{th}$ smallest element of an array
* Option1: Use quicksort to sort and then select A[k-1], time requires O(nlogn)
### Idea:
1. when partition A, only need to recurse on the side of the $k^{th}$ smallest element
2. Choose pivot $x$ at random
3. Compare and partition all elements into two sets
    * S and L, all elements in S before x, all elements in L after x
    * Denote $x$ be in the $i^{th}$ position
4. 
$$
\begin{cases}
\text{if } k=i  \text{ return } x \\
\text{if } k\gt i  \text{ recurse on the elements to the left of } x \\
\text{if } k\lt i  \text{ recurse on the elements to the right of } x\\
\end{cases}
$$


### Run Time:
$O(n)$

## Priority Queue | MinHeap
### Operation
* Insert
   1. Put to maintain complete tree structure
   2. Percolate and bubble up
* Extract min (most priority)
   1. Extract the root
   2. Fill the root with the last leaf
   3. Percolate and bubble down (swap with smaller of children)
* Decrease key (increase priority)
### Idea
* Maintain as a rooted tree
* key at parent $\lt$ key at children
* Use complete binary tree as structure
* Observation:
   1. \# of leaves at level $j$ is $2^j$
   2. A height $h$ complete binary tree has $(2^{h+1}-1)$ nodes (complete, full)
   3. A tree with one root is of height $0$
   4. Must have a complete level of leaves at $(h-1)$ level

### Heaps as array (by indexing)
* For indexing starting at 0
   * if a node at index $k$, its left child at $2k+1$, its right child at $2k+2$
   * its parent at $\lfloor \frac{k-1}{2}\rfloor$
* For indexing starting at 1
   * if a node at index $k$, its left child at $2k$, its right child at $2k+1$
   * its parent at $\lfloor \frac{k}{2}\rfloor$
### Build a heap - Heapify
1. Build a tree as complete tree initially without considering order
2. Backwardly check element and its children order (not parent)
3. Bubble down if necessary (**check its new children again** after swap down)

**Heapify is of $O(n)$**, better than building with insertion $O(nlogn)$
