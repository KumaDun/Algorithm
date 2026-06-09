class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        left = max(nums)
        right = sum(nums)

        def cansplit(target):
            groups = 1
            cur_sum = 0
            for num in nums:
                if cur_sum + num <= target:
                    cur_sum += num
                else:
                    groups += 1
                    cur_sum = num
            return groups <= k

        while left < right:
            mid = (left + right) // 2
            if cansplit(mid):
                right = mid
            else:
                left = mid + 1
        return left