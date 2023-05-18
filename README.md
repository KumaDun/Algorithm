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
## Quick Search
### Idea
	1. Choose a pivot element x at random
	2. Compare all elements to the pivot
	3. Partition all elements into two sets, S smaller than x, L larger than x
	4. Recursively sort S and L, let's annote |S|=k
### RunTime
*Please copy latex code to 3rd party latex editor to read*
	1. Any two elements are never compared more than once
	2. If p is the pivot, x<p, y>p, then x and y are never compared
	3. Denote the k th smallest element in the array as ek
	4. X = total # of comparisons, Xij indicates if ei and ej are compared
	5. Then $\large X = \sum_{1\le i<j \le n}Xij = \sum_{i=1}^n \sum_{j=i+1}^n Pr[X_{ij} = 1]$
	6. Which pivot to pick so that $e_i, e_j$ be compared? only when either $e_i$ or $e_j$ are chosen as the pivot (2 total)
	7. Which pivot to pick so that $e_i,e_j$ are not ever be compared? $e_{i+1},e_{i+2},\dots,e_{j-1}$
	8. $E[X_{ij}]=2 \cdot \frac{1}{j-i-1+2}=\frac{2}{j-i+1}$
	9. $$\large \begin{align}X=\sum_{i=1}^n \sum_{j=i+1}^n Pr[X_{ij} = 1] &= \sum_{d=1}^{n-1} \frac{2(n-d)}{d+1} \,|\, (j-i)=d\\
	&=2n\sum_{d=1}^{n-1}\frac{1}{d+1} - \sum_{d=1}^{n-1}\frac{d}{d+1}\\ \\&= 2nlogn - O(n) \in O(nlogn)\end{align}$$
	10. The smaller $j-i$, the higher proberbility $e_i,e_j$ will be compared, that's why the algorithm saves time


