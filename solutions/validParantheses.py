class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        bracesLookup = {'(': ')', '{': '}', '[': ']'}
        closingBraces = []
        for i in s:
            if (i in bracesLookup.keys()):
                closingBraces.append(bracesLookup[i])
            elif (not closingBraces or i != closingBraces.pop()):
                return False
        return (closingBraces == [])