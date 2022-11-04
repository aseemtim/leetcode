class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        lookup = {}
        count = 0
        for i in nums:
            if(i in lookup.keys()):
                lookup[i] = lookup[i] + 1
                count += lookup[i]
            else:
                lookup[i] = 0
        return count