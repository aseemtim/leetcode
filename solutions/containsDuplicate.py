class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        lookup = {}
        for i in nums:
            if(i in lookup):
                return True
            lookup[i] = True
        return False