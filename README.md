# Algorithm
Algorithm Reviewing
* MergeSort:
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
