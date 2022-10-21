class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hashTable = {}
        for i in range(len(nums)):
            hashTable[nums[i]] = i
            
        for i in range(len(nums)):
            diff = target - nums[i]
            if (diff in hashTable and hashTable[diff] != i):
                return(i, hashTable[diff])